package khopa.ld27.game.views.scenes.game.views.actors;

import khopa.ld27.game.models.ships.Ship;
import khopa.ld27.game.views.common.actors.SpriteActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ShipActor extends SpriteActor{

	private Ship model;
	
	public ShipActor(Ship model, TextureRegion texture){
		super(texture);
		setModel(model);
	}

	public Ship getModel() {
		return model;
	}

	public void setModel(Ship model) {
		this.model = model;
	}
	
}
