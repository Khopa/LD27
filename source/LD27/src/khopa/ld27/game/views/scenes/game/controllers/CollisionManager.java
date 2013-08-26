package khopa.ld27.game.views.scenes.game.controllers;

import java.util.ArrayList;
import java.util.Random;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.views.resources.SoundManager;
import khopa.ld27.game.views.scenes.game.ScoreManager;
import khopa.ld27.game.views.scenes.game.views.GameStage;
import khopa.ld27.game.views.scenes.game.views.actors.ShipActor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CollisionManager extends Action {

	private ArrayList<Actor> bullets;
	
	private ArrayList<ShipActor> targets;
	
	public static CollisionManager instance;
	
	private static Random rnd = new Random();
	
	private GameStage layer;
	
	public CollisionManager(GameStage layer){
		bullets = new ArrayList<Actor>();
		targets = new ArrayList<ShipActor>();
		instance = this;
		this.layer = layer;
	}
	
	@Override
	public boolean act(float delta) {
		
		ArrayList<Actor> bToRemove = new ArrayList<Actor>();
		ArrayList<ShipActor> aToRemove = new ArrayList<ShipActor>();
		
		for(ShipActor t:targets){
			if(t.getY()<0){
				aToRemove.add(t);
				layer.getEntitiesLayer().addActor(EnnemyFactory.explosion(t.getX()));
				layer.getBackground().addAction(Actions.color(Color.CYAN, 0.2f));
				SoundManager.play("slash"+Integer.toString(rnd.nextInt(6)));
				ScoreManager.pass();
				continue;
			}
		}
		
		for(Actor b:bullets){
			
			if(b.getY()>GDXApp.getHeight()+b.getHeight()){
				bToRemove.add(b);
				ScoreManager.waste();
				continue;
			}
			
			for(ShipActor t:targets){
				if(aToRemove.contains(t)) continue;
				
				if(collide(b,t)){
					bToRemove.add(b);
					t.getModel().takeDamage();
					if(t.getModel().isDead()){
						aToRemove.add(t);
						SoundManager.play("dead"+Integer.toString(rnd.nextInt(6)));
						ScoreManager.kill();
						for(Actor a : EnnemyFactory.wrecks(t.getX(), t.getY())){
							layer.getEntitiesLayer().addActor(a);
						}
					}
					else{
						t.addAction(ShipAnimation.hit());
					}
					break;
				}
			}
		}
		
		
		for(Actor b:bToRemove) b.remove();
		for(Actor t:aToRemove) t.remove();
		
		bullets.removeAll(bToRemove);
		targets.removeAll(aToRemove);
		
		return false;
	}
	
	public static boolean collide(Actor a, Actor b){
		return (a.getX() > b.getX() && a.getX()<b.getX()+b.getWidth()
		&& a.getY() > b.getY() && a.getY()<b.getY()+b.getHeight());
	}
	
	public void addTarget(ShipActor ship){
		targets.add(ship);
	}
	
	public void addBullet(Actor bullet){
		bullets.add(bullet);
	}

	public static CollisionManager getInstance() {
		return instance;
	}

}
