package khopa.ld27.game.views.scenes.mainMenu;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.views.resources.MusicManager;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.mainMenu.controllers.MenuController;
import khopa.ld27.game.views.scenes.mainMenu.views.MenuStage;

import com.badlogic.gdx.utils.Disposable;

/**
 * This component is a libgdx stage for a main menu
 * @author Clément Perreau
 */
public class Menu implements Disposable {


	/**
	 * View as a libgdx stage
	 */
	private MenuStage view;
	
	/*
	 * Controller
	 */
	@SuppressWarnings("unused")
	private MenuController controller;
	
	// ---- Component Implementation ---- \\
	
	public static void deploy(){
		Menu menu = new Menu();
		menu.init();
		GDXApp.getSingleInstance().setStage(menu.getView());
	}
	
	private void init() {
		
		// Load textures
		TextureManager.loadTexture("data/gfx/sprites/gui.png", "Buttons", 256, 64);
		TextureManager.loadTexture("data/gfx/background/background.png", "Background", 1920, 1080);
		TextureManager.loadTexture("data/gfx/sprites/title.png", "Title", 1024, 128);
		TextureManager.loadTexture("data/gfx/sprites/artwork.png", "Artwork", 512, 1024);
		
		// Load Music
		//MusicManager.load("data/bgm/wonderStar.ogg", "wonderStar");
		//MusicManager.play("wonderStar"); I remove the music cause it was bad :D
		
		this.view = new MenuStage();
		this.controller = new MenuController(this.view, this);
		
	}
	
	public void dispose() {
		
		// Unload textures
		TextureManager.disposeTexture("Buttons");
		TextureManager.disposeTexture("Background");
		TextureManager.disposeTexture("Artwork");
		TextureManager.disposeTexture("Title");
		
		// Dispose music
		MusicManager.dispose("wonderStar");
		
	}

	public MenuStage getView() {
		return view;
	}
	
}
