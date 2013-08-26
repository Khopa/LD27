package khopa.ld27.game.views.scenes.game.views;

import java.util.ArrayList;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.models.ships.Ship;
import khopa.ld27.game.views.common.ILayer;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.game.controllers.CollisionManager;
import khopa.ld27.game.views.scenes.game.views.actors.ShipActor;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class EntitiesLayer extends Group implements ILayer{
	
	/**
	 * Hero
	 */
	private ShipActor hero;
	
	/**
	 * Bullets
	 */
	private ArrayList<Actor> bullets;
	
	/**
	 * Ennemies
	 */
	private ArrayList<ShipActor> ennemies;
	
	public EntitiesLayer(){
		initActors();
		layersZ();
		layout();
	}

	@Override
	public void initActors() {
		bullets = new ArrayList<Actor>();
		ennemies = new ArrayList<ShipActor>();
		this.hero = new ShipActor(new Ship(3), TextureManager.getTexture("ships").getTile(1));
	}

	@Override
	public void layersZ() {
		this.addActor(hero);
	}

	@Override
	public void layout() {
		this.hero.setPosition(GDXApp.getWidth()/2-hero.getWidth()/2, hero.getHeight());
	}

	public ShipActor getHero() {
		return hero;
	}
	
	// ------ \\
	
	public void spawnBulletEntity(Actor bullet){
		bullets.add(bullet);
		this.addActor(bullet);
		CollisionManager.getInstance().addBullet(bullet);
	}
	
	public void spawnEnnemyEntity(ShipActor ennemy){
		ennemies.add(ennemy);
		this.addActor(ennemy);
		CollisionManager.getInstance().addTarget(ennemy);
	}
	
}
