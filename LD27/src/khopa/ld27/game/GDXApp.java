package khopa.ld27.game;

import khopa.ld27.game.views.resources.MusicManager;
import khopa.ld27.game.views.resources.SoundManager;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.mainMenu.Menu;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * 
 * LibGDX application (Ludum Dare 27)
 * 
 * @author Clément Perreau
 * 
 */
public class GDXApp implements ApplicationListener{

	/**
	 * Singleton
	 */
	private static GDXApp singleInstance;
	
	/**
	 * Resolution Width
	 */
	private static float w;
	
	/**
	 * Resolution Height
	 */
	private static float h;
	
	/**
	 * Elapsed time
	 */
	private float elapsedTime;
	
	/**
	 * Stage (current stage)
	 */
	private Stage stage;
	
	/**
	 * Skin
	 */
	private Skin skin;
	

	// ---- Application Listener ---- \\
	
	@Override
	public void create() {		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		GDXApp.singleInstance = this;
		this.init();
	}
	
	/**
	 * Perform initialisation
	 */
	private void init(){
		
		TextureManager.init();
		MusicManager.init();
		SoundManager.init();
		
		Menu.deploy();
	}
	

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if(stage != null){
			stage.act();
			stage.draw();
		}
		this.elapsedTime = getElapsedTime() + (Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	// ---- 

	public static GDXApp getSingleInstance() {
		return singleInstance;
	}

	public float getElapsedTime() {
		return elapsedTime;
	}

	public Stage getStage() {
		return stage;
	}

	public static float getWidth() {
		return w;
	}

	public static float getHeight() {
		return h;
	}

	public Skin getSkin() {
		return skin;
	}
	
	// ---- Setters ---- \\

	public void setStage(Stage stage) {
		if(this.stage != null) this.stage.dispose();
		Gdx.input.setInputProcessor(stage);
		this.stage = stage;
	}

}
