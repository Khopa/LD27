package khopa.ld27.game.views.scenes.game.views;

import khopa.ld27.game.GDXApp;
import khopa.ld27.game.views.common.ILayer;
import khopa.ld27.game.views.scenes.GameOver;
import khopa.ld27.game.views.scenes.game.ScoreManager;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class HUDLayer extends Group implements ILayer{

	
	@SuppressWarnings("unused")
	private Actor art; // unused
	
	private Label firepower;
	
	private Label score;
	
	private float firepowerValue = 10f; // 600 sec
	
	
	public HUDLayer(){
		initActors();
		layersZ();
		layout();
		firepowerValue = 10;
	}
	
	@Override
	public void initActors() {
		//art = new SpriteActor(TextureManager.getTexture("hud").getTile(0));
		firepower = new Label("Firepower : 10:00", GDXApp.getSingleInstance().getSkin());
		score = new Label("Score : ", GDXApp.getSingleInstance().getSkin());
	}

	@Override
	public void layersZ() {
		//this.addActor(art);
		this.addActor(firepower);
		this.addActor(score);
	}

	@Override
	public void layout() {
		//art.setPosition(0, 0);
		firepower.setPosition(5, 17);
		score.setPosition(5, GDXApp.getHeight()-24f);
	}
	
	
	public void lowerFirepower(float remove){
		firepowerValue-=remove;
		firepower.setText("Firepower : " + String.format("%.1f", firepowerValue) + "s");
		if(firepowerValue <= 0){
			GDXApp.getSingleInstance().setStage(new GameOver());
		}
	}
	
	@Override
	public void act(float delta) {
		score.setText("Score : " + ScoreManager.getScore());
	}
	
	public void reset(){
		firepowerValue = 10f;
	}

	public float getFirepowerValue() {
		return firepowerValue;
	}
	

}
