package khopa.ld27.game.views.scenes.game.controllers;

import khopa.ld27.game.views.scenes.game.StellarCountDown;
import khopa.ld27.game.views.scenes.game.views.GameStage;
import khopa.ld27.game.views.scenes.game.views.actors.ShipActor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * 
 * Game Controller
 * 
 * @author Clément Perreau
 *
 */
public class GameController {

	/**
	 * Stage to control
	 */
	private GameStage view;
	
	/**
	 * Game Component
	 */
	@SuppressWarnings("unused")
	private StellarCountDown game;
	
	public GameController(GameStage view, StellarCountDown game){
		this.setView(view);
		this.game = game;
		init();
	}

	// -- Getters -- \\
	
	private void init() {
		ShipActor hero = this.view.getEntitiesLayer().getHero();
		hero.addAction(new HeroController(hero, view.getEntitiesLayer(), this));
		view.addAction(new EnnemyManager(view.getEntitiesLayer()));
		view.addAction(new CollisionManager(view));
		view.getBackground().addAction(Actions.forever(Actions.sequence(
				Actions.color(Color.BLUE,3f),
				Actions.color(Color.RED,3f))));
	}

	public GameStage getView() {
		return view;
	}

	// -- Setters -- \\
	
	public void setView(GameStage view) {
		this.view = view;
	}
	
	
}
