package khopa.ld27.game.views.scenes;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.controllers.common.views.animations.GUIAnimation;
import khopa.ld27.game.views.common.ILayer;
import khopa.ld27.game.views.common.actors.SpriteActor;
import khopa.ld27.game.views.resources.TextureManager;
import khopa.ld27.game.views.scenes.game.ScoreManager;
import khopa.ld27.game.views.scenes.game.StellarCountDown;
import khopa.ld27.game.views.scenes.mainMenu.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class GameOver extends Stage implements ILayer{

	private Actor background;
	private Actor text;
	private Label score;
	private Label killed;
	private Label wasted;
	private Label passed;
	private Label instruction;
	
	private int scoreValue;
	
	public GameOver(){
		this.scoreValue = ScoreManager.getScore();
		initActors();
		layersZ();
		layout();
	}
	
	@Override
	public void initActors() {
		TextureManager.loadTexture("data/gfx/sprites/nomorefirepower.png", "gameover", 1024, 256);
		background = new SpriteActor(TextureManager.getTexture("background").getTile(0));
		text = new SpriteActor(TextureManager.getTexture("gameover").getTile(0));
		
		score = new Label("Score : " + Integer.toString(scoreValue), GDXApp.getSingleInstance().getSkin());
		
		killed = new Label("Killed Ennemies : " + Integer.toString(ScoreManager.getKills())
				           + "  ==> " + Integer.toString(ScoreManager.getKills()*ScoreManager.ENNEMY_KILLED),
				           GDXApp.getSingleInstance().getSkin());
		
		passed = new Label("Ennemy Missed : " + Integer.toString(ScoreManager.getPassed())
		           + "  ==> " + Integer.toString(ScoreManager.getPassed()*ScoreManager.ENNEMY_PASSED),
		           GDXApp.getSingleInstance().getSkin());
		
		wasted = new Label("Wasted Firepower : " + Integer.toString(ScoreManager.getWasted())
		           + "  ==> " + Integer.toString(ScoreManager.getWasted()*ScoreManager.FIREPOWER_WASTED),
		           GDXApp.getSingleInstance().getSkin());
		
		instruction = new Label("Push R to restart, or ESCAPE to exit to main menu", GDXApp.getSingleInstance().getSkin());
	}
	
	@Override
	public void layersZ() {
		addActor(background);
		addActor(text);
		addActor(score);
		addActor(killed);
		addActor(passed);
		addActor(wasted);
		addActor(instruction);
		background.addAction(GUIAnimation.hovered());
	}
	
	@Override
	public void layout() {
		
		text.setPosition(GDXApp.getWidth()/2-text.getWidth()/2, GDXApp.getHeight()-text.getHeight());
		killed.setPosition(GDXApp.getWidth()/2-killed.getWidth()/2, 3f/5f*GDXApp.getHeight());
		passed.setPosition(GDXApp.getWidth()/2-killed.getWidth()/2, 3f/5f*GDXApp.getHeight()-24);
		wasted.setPosition(GDXApp.getWidth()/2-killed.getWidth()/2, 3f/5f*GDXApp.getHeight()-48);
		score.setPosition(GDXApp.getWidth()/2-killed.getWidth()/2, 3f/5f*GDXApp.getHeight()-72);
		
		instruction.setPosition(GDXApp.getWidth()/2-instruction.getWidth()/2, 45);
		
		text.addAction(GUIAnimation.scaling());
	}
	
	
	@Override
	public void act() {
		
		super.act();
		
		if(Gdx.input.isKeyPressed(Input.Keys.R)){
			StellarCountDown.deploy();
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Menu.deploy();
		}
		
	}
	
	
}
