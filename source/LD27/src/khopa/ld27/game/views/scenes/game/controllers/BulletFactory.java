package khopa.ld27.game.views.scenes.game.controllers;

import java.util.Random;

import khopa.ld27.game.views.common.actors.SpriteActor;
import khopa.ld27.game.views.resources.TextureManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;


/**
 * Factory for bullets
 * @author Clément
 *
 */
public class BulletFactory {
	
	public static Random rnd = new Random();

	public static Actor bullet(float x, float y){
		Actor actor = new SpriteActor(TextureManager.getTexture("bullets").getTile(0));
		actor.setPosition(x, y);
		actor.setRotation(rnd.nextInt(360));
		actor.addAction(Actions.forever(Actions.moveBy(0, 800, 1f)));
		actor.addAction(Actions.forever(Actions.rotateBy(360, 1f)));
		actor.addAction(Actions.forever(Actions.sequence(
				Actions.color(Color.BLUE, .1f),
				Actions.color(Color.WHITE, .1f))));	
		return actor;
	}
	
	
}
