package khopa.ld27.game.models.weapon;

/**
 * Weapon interface
 * @author Clément Perreau
 */
public class Weapon {
	
	public float cooldown;
	
	public Weapon(float cooldown){
		setCooldown(cooldown);
	}
	
	public float getCooldown() {
		return cooldown;
	}

	public void setCooldown(float cooldown) {
		this.cooldown = cooldown;
	}

	/**
	 * Called when weapon is asked to fire
	 */
	public void fire() {
		
	}
	
}
