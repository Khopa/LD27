package khopa.ld27.game.views.scenes.mainMenu.controllers;

import khopa.ld27.game.controllers.common.views.animations.GUIAnimation;
import khopa.ld27.game.views.scenes.mainMenu.Menu;
import khopa.ld27.game.views.scenes.mainMenu.controllers.listenners.PlayButtonListener;
import khopa.ld27.game.views.scenes.mainMenu.controllers.listenners.QuitButtonListener;
import khopa.ld27.game.views.scenes.mainMenu.views.MenuStage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Controller for the menu view
 *  
 * @author Clément Perreau
 * 
 */
public class MenuController {

	/**
	 * Controlled view
	 */
	private MenuStage view; 
	
	public MenuController(MenuStage view, Menu menu) {
		this.view = view;
		this.initActions();
	}

	private void initActions() {
		
		// Play
		this.view.getPlay().addListener(new PlayButtonListener());
		this.view.getQuit().addListener(new QuitButtonListener());
		this.view.getCaption().addAction(GUIAnimation.scaling());
		this.view.getTitle().addAction(GUIAnimation.titleAnim());
		
		this.view.getBackground().addAction(Actions.forever(
		 		 Actions.sequence(
				 Actions.color(new Color(.5f, 5f, .8f, 1f), .8f),
				 Actions.color(new Color(.8f, .5f, .5f, 1f), 1.2f))));

	}


}
