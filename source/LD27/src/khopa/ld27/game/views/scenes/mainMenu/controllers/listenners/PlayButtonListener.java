package khopa.ld27.game.views.scenes.mainMenu.controllers.listenners;

import khopa.ld27.game.controllers.common.views.listeners.ButtonController;
import khopa.ld27.game.views.scenes.game.StellarCountDown;

public class PlayButtonListener extends ButtonController {

	@Override
	public void doAction() {
		StellarCountDown.deploy();
	}
	
}
