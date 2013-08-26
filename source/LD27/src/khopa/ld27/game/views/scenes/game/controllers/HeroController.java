package khopa.ld27.game.views.scenes.game.controllers;

import java.util.Random;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.views.resources.SoundManager;
import khopa.ld27.game.views.scenes.game.views.EntitiesLayer;
import khopa.ld27.game.views.scenes.game.views.actors.ShipActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class HeroController extends Action {

	public static final int FIRE_KEY = Input.Keys.SPACE;
	public static final int LEFT_KEY = Input.Keys.LEFT;
	public static final int RIGHT_KEY = Input.Keys.RIGHT;
	public static final int UP_KEY = Input.Keys.UP;
	public static final int DOWN_KEY = Input.Keys.DOWN;
	
	private ShipActor shipActor;
	
	private Random rnd = new Random();
	
	private EntitiesLayer layer;
	
	private GameController controller;
	
	private float cooldown = 0;
	
	public HeroController(ShipActor actor, EntitiesLayer layer, GameController controller){
		this.shipActor = actor;
		this.layer = layer;
		this.controller = controller;
	}

	@Override
	public boolean act(float delta) {
		
		
		if(Gdx.input.isKeyPressed(FIRE_KEY) && cooldown <= 0 && controller.getView().getHud().getFirepowerValue()>0){
			SoundManager.play("fire"+Integer.toString(rnd.nextInt(4)));
			cooldown = shipActor.getModel().getWeapon().getCooldown();
			layer.spawnBulletEntity(BulletFactory.bullet(shipActor.getX()+17+rnd.nextInt(8)-7, shipActor.getY()+49));
			layer.spawnBulletEntity(BulletFactory.bullet(shipActor.getX()+46+rnd.nextInt(8)-7, shipActor.getY()+49));
			controller.getView().getHud().lowerFirepower(Gdx.graphics.getDeltaTime());
		}
		
		float s = shipActor.getModel().getThruster(); 
		if(Gdx.input.isKeyPressed(RIGHT_KEY)){
			shipActor.addAction(Actions.moveBy(s*Gdx.graphics.getDeltaTime(), 0, Gdx.graphics.getDeltaTime()));
		}
		else if(Gdx.input.isKeyPressed(LEFT_KEY)){
			shipActor.addAction(Actions.moveBy(-s*Gdx.graphics.getDeltaTime(), 0, Gdx.graphics.getDeltaTime()));
		}
		
		if(Gdx.input.isKeyPressed(UP_KEY)){
			shipActor.addAction(Actions.moveBy(0, s*Gdx.graphics.getDeltaTime(), Gdx.graphics.getDeltaTime()));
		}
		else if(Gdx.input.isKeyPressed(DOWN_KEY)){
			shipActor.addAction(Actions.moveBy(0, -s*Gdx.graphics.getDeltaTime(), Gdx.graphics.getDeltaTime()));
		}
		
		clamp();
		cooldown -= Gdx.graphics.getDeltaTime();
		
		return false;
	}

	/**
	 * Ensure the ship stay on the screen
	 */
	private void clamp() {
		
		if(shipActor.getX() < 0) shipActor.setX(0);
		else if(shipActor.getX() > GDXApp.getWidth()-shipActor.getWidth()) shipActor.setX(GDXApp.getWidth()-shipActor.getWidth()); 		
	
		if(shipActor.getY() < 0) shipActor.setY(0);
		else if(shipActor.getY() > GDXApp.getHeight()-shipActor.getHeight()) shipActor.setY(GDXApp.getHeight()-shipActor.getHeight());
	
	}

	
	

	
}
