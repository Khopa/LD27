package khopa.ld27.game.views.scenes.game.controllers;

import java.util.Random;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.models.ships.Ship;
import khopa.ld27.game.views.common.actors.SpriteActor;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.game.views.actors.ShipActor;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class EnnemyFactory {

	private static Random rnd = new Random();
	
	
	public static ShipActor ennemy(){
		int xSpawn = rnd.nextInt((int) (GDXApp.getWidth()-64));
		int ySpawn = (int) GDXApp.getHeight();
		
		ShipActor actor = new ShipActor(new Ship(5), TextureManager.getTexture("ships").getTile(0));
		actor.setPosition(xSpawn, ySpawn);
		actor.addAction(Actions.forever(Actions.moveBy(0, -1000, 8f)));
		return actor;
	}
	
	
	/**
	 * wreck of an ennemy ship
	 * @return
	 */
	public static SpriteActor[] wrecks(float x, float y){
		SpriteActor[] actors = new SpriteActor[4];
		actors[0] = new SpriteActor(TextureManager.getTexture("ships").getTile(4));
		actors[1] = new SpriteActor(TextureManager.getTexture("ships").getTile(5));
		actors[2] = new SpriteActor(TextureManager.getTexture("ships").getTile(4));
		actors[3] = new SpriteActor(TextureManager.getTexture("ships").getTile(6));
		for(Actor a: actors){
			a.addAction(ShipAnimation.destroyed());
			a.setPosition(x+rnd.nextInt(30)-15, y+rnd.nextInt(30)-15);
		}
		return actors;
	}
	
	/**
	 * Explosion
	 */
	public static SpriteActor explosion(float x){
		SpriteActor explosion = new SpriteActor(TextureManager.getTexture("ships").getTile(2));
		explosion.addAction(ShipAnimation.explosion());
		explosion.setPosition(x, 64);
		return explosion;
	}
	
}
