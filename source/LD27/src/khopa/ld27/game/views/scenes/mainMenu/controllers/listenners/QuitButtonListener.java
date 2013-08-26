package khopa.ld27.game.views.scenes.mainMenu.controllers.listenners;

import khopa.ld27.game.controllers.common.views.listeners.ButtonController;

import com.badlogic.gdx.Gdx;

public class QuitButtonListener extends ButtonController{
	
	@Override
	public void doAction() {
		Gdx.app.exit();
	}

}
