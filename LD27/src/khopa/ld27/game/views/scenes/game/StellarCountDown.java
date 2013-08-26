package khopa.ld27.game.views.scenes.game;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.game.controllers.GameController;
import khopa.ld27.game.views.scenes.game.views.GameStage;

public class StellarCountDown {

	/**
	 * View
	 */
	private GameStage view;
	
	/**
	 * Controller
	 */
	@SuppressWarnings("unused") 
	private GameController controller;

	public static void deploy(){
		StellarCountDown game = new StellarCountDown();
		game.init();
		GDXApp.getSingleInstance().setStage(game.getView());
	}

	public void init() {
	
		ScoreManager.reset();
		
		TextureManager.loadTexture("data/gfx/sprites/ships.png", "ships", 64, 64);
		TextureManager.loadTexture("data/gfx/sprites/hud.png", "hud", 128, 128);
		TextureManager.loadTexture("data/gfx/sprites/bullets.png", "bullets", 4, 4);
		TextureManager.loadTexture("data/gfx/background/background.png", "background", 1920, 1080);
		
		/*MusicManager.load("data/bgm/stellarCountDown.ogg", "stellar");
		MusicManager.play("stellar");*/ 
		
		this.view = new GameStage(this);
		this.controller = new GameController(view, this);
		
	}


	public void dispose() {
		TextureManager.disposeTexture("ships");
		TextureManager.disposeTexture("background");
	}
	
	public GameStage getView() {
		return view;
	}

	
	
}
