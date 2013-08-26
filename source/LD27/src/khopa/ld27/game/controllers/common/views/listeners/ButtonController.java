package khopa.ld27.game.controllers.common.views.listeners;

import khopa.ld27.game.controllers.common.views.animations.GUIAnimation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * This listener implements animation for buttons
 * @author Clément Perreau
 */
public class ButtonController extends InputListener{
	
	/**
	 * Color when touched
	 */
	protected static final Color pressed = new Color(.8f,.5f,.5f,1f);
	
	/**
	 * Hovered Action
	 */
	protected Action hovered;
	
	/**
	 * To know if the mouse is still on it
	 */
	protected boolean onIt = false;
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		event.getListenerActor().removeAction(hovered);
		event.getListenerActor().setColor(new Color(.5f,1f,1f,1f));
		event.getListenerActor().setScale(.95f);
		onIt = true;
		return true;
	}

	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer,
			int button) {
		event.getListenerActor().setScale(1f);
		for(Action action : event.getListenerActor().getActions()){
			event.getListenerActor().removeAction(action);
		}
		if(onIt) doAction();
	}

	@Override
	public void enter(InputEvent event, float x, float y, int pointer,
			Actor fromActor) {
		this.hovered = GUIAnimation.hovered();
		event.getListenerActor().addAction(hovered);
	}

	@Override
	public void exit(InputEvent event, float x, float y, int pointer,
			Actor toActor) {
		event.getListenerActor().setScale(1f);
		for(Action action : event.getListenerActor().getActions()){
			event.getListenerActor().removeAction(action);
		}
		event.getListenerActor().setColor(Color.WHITE);
		onIt= false;
	}
	
	/**
	 * To override to give the button a behaviour
	 */
	public void doAction(){
		
	}

	public boolean isOnIt() {
		return onIt;
	}
	
}
