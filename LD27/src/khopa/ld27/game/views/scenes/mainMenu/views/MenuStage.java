package khopa.ld27.game.views.scenes.mainMenu.views;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.views.common.ILayer;
import khopa.ld27.game.views.common.actors.SpriteActor;
import khopa.ld27.game.views.resources.TextureManager;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * 
 * Stage View for the main menu
 * 
 * @author Clément Perreau
 *
 */
public class MenuStage extends Stage implements ILayer{
	
	
	private Table menuTable;
	private Actor background;
	private Actor title;
	private Actor artwork;
	private Actor play;
	private Actor quit;	
	private Actor caption;	
	private Actor instruction;
	private Actor sign;

	public MenuStage() {
		this.initActors();
		this.layersZ();
		this.layout();
	}

	public Actor getBackground() {
		return background;
	}

	@Override
	public void initActors() {
		this.background = new SpriteActor(TextureManager.getTexture("Background").getTile(0));
		this.artwork = new SpriteActor(TextureManager.getTexture("Artwork").getTile(0));
		this.title   = new SpriteActor(TextureManager.getTexture("Title").getTile(0));
		this.play    = new SpriteActor(TextureManager.getTexture("Buttons").getTile(4));
		this.quit    = new SpriteActor(TextureManager.getTexture("Buttons").getTile(6));
		this.caption = new SpriteActor(TextureManager.getTexture("Buttons").getTile(1));
		this.instruction = new Label("Press space to Shoot, Arrow Keys to move.", GDXApp.getSingleInstance().getSkin());
		this.sign = new Label("By Khopa for LUDUM DARE 27 Compo", GDXApp.getSingleInstance().getSkin());
	}

	@Override
	public void layersZ() {
		this.addActor(this.background);
		this.addActor(this.title);
		this.addActor(this.artwork);
		this.addActor(this.play);
		this.addActor(this.quit);
		this.addActor(this.caption);
		this.addActor(this.instruction);
		this.addActor(this.sign);
	}

	@Override
	public void layout() {
		title.setPosition(GDXApp.getWidth()/2 - title.getWidth()/2, GDXApp.getHeight()-title.getHeight());
		artwork.setPosition(-play.getWidth()/2, -artwork.getHeight()/2);
		play.setPosition(GDXApp.getWidth()/2 - play.getWidth()/2, 5.5f*play.getHeight());
		quit.setPosition(GDXApp.getWidth()/2 - play.getWidth()/2, 3.5f*play.getHeight());
		caption.setPosition(GDXApp.getWidth()/2 - caption.getWidth()/2, GDXApp.getHeight()-title.getHeight()*1.5f);
		instruction.setPosition(GDXApp.getWidth()-instruction.getWidth()-5, GDXApp.getHeight()/2-instruction.getHeight()/2);
		sign.setPosition(GDXApp.getWidth()-sign.getWidth()-5, 17);
	}

	
	// ---- Getters ---- \\
	
	public Table getMenuTable() {
		return menuTable;
	}

	public Actor getPlay() {
		return play;
	}

	public Actor getQuit() {
		return quit;
	}

	public Actor getCaption() {
		return caption;
	}

	public Actor getTitle() {
		return title;
	}

	

}
