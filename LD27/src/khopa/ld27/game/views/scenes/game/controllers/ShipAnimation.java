package khopa.ld27.game.views.scenes.game.controllers;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ShipAnimation {

	private static Random rnd = new Random();
	
	public static Action hit(){
		return Actions.sequence(
				Actions.color(Color.RED, 0.05f),
				Actions.color(Color.WHITE, 0.05f));
	}
	
	public static Action destroyed(){
		return Actions.sequence(Actions.parallel(
					Actions.alpha(0, 1.8f),
					Actions.moveBy(rnd.nextInt(200)-100, rnd.nextInt(200)-100, 1.9f),
					Actions.rotateBy(rnd.nextInt(1080)+360, 1.9f)
				), Actions.removeActor());
	}	
	
	public static Action explosion(){
		return Actions.sequence(Actions.parallel(
				Actions.scaleTo(1, 18f, .2f),
				Actions.alpha(0, .2f)), Actions.removeActor());
	}

	
}
