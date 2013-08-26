package khopa.ld27.game.models.ships;

import khopa.ld27.game.models.weapon.Weapon;

public class Ship {

	/**
	 * Shield status (hp)
	 */
	private int shield = 3;
	
	/**
	 * Speed in pixels per second
	 */
	private float thruster = 500;
	
	private Weapon weapon;

	public Ship(int shield){
		setShield(shield);
		setWeapon(new Weapon(.001f));
	}
	
	public void takeDamage(){
		shield -= 1;
	}
	
	public boolean isDead(){
		return (shield<=0);
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public float getThruster() {
		return thruster;
	}

	public void setThruster(float thruster) {
		this.thruster = thruster;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
}
