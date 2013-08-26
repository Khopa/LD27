package khopa.ld27.game.views.scenes.game.controllers;

import java.util.Random;

import khopa.ld27.game.views.resources.SoundManager;
import khopa.ld27.game.views.scenes.game.views.EntitiesLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;

/**
 * Spawn ennemies
 * 
 * @author Clément Perreau
 *
 */
public class EnnemyManager extends Action {

	private static Random rnd = new Random();
	
	private float nextSpawn = 0.5f;
	
	private EntitiesLayer layer;
	
	public EnnemyManager(EntitiesLayer layer){
		this.layer = layer;
	}
	
	@Override
	public boolean act(float delta) {
		
		nextSpawn -= Gdx.graphics.getDeltaTime();
		
		if(nextSpawn < 0){
			
			nextSpawn = rnd.nextFloat()*2.8f;
			layer.spawnEnnemyEntity(EnnemyFactory.ennemy());
			SoundManager.play("spawn"+Integer.toString(rnd.nextInt(6)));
		}
		
		
		return false;
	}
	
}
