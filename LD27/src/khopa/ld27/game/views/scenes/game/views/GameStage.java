package khopa.ld27.game.views.scenes.game.views;

import khopa.ld27.game.views.common.ILayer;
import khopa.ld27.game.views.common.actors.SpriteActor;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.game.StellarCountDown;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * 
 * LibGDX Stage for the main game
 * 
 * @author Clément Perreau
 *
 */
public class GameStage extends Stage implements ILayer {

	/**
	 * HUD layer
	 */
	private Actor background;
	
	/**
	 * HUD layer
	 */
	private HUDLayer hud;
	
	/**
	 * Entities layer
	 */
	private EntitiesLayer entitiesLayer;
	
	/**
	 * Game
	 */
	private StellarCountDown game;
	
	public GameStage(StellarCountDown game){
		this.game = game;
		initActors();
		layersZ();
		layout();
	}

	@Override
	public void initActors() {
		this.background = new SpriteActor(TextureManager.getTexture("background").getTile(0));
		this.hud = new HUDLayer();
		this.entitiesLayer = new EntitiesLayer();
	}

	@Override
	public void layersZ() {
		this.addActor(this.background);
		this.addActor(this.hud);
		this.addActor(this.entitiesLayer);
	}

	@Override
	public void layout() {
		this.background.setPosition(0, 0); 
		this.hud.setPosition(0, 0);
		this.entitiesLayer.setPosition(0, 0);
	}

	public StellarCountDown getGame() {
		return game;
	}

	public Actor getBackground() {
		return background;
	}

	public EntitiesLayer getEntitiesLayer() {
		return entitiesLayer;
	}

	public HUDLayer getHud() {
		return hud;
	}
	
}
