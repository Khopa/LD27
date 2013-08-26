package khopa.ld27.game.views.scenes.game;

public class ScoreManager {

	public static final int ENNEMY_KILLED = 250;
	public static final int FIREPOWER_WASTED = -5;
	public static final int ENNEMY_PASSED = -500;
	
	private static int kills;
	private static int passed;
	private static int wasted;
	
	public static void reset(){
		kills = 0;
		passed = 0;
		wasted = 0;
	}
	
	public static int getScore(){
		return kills*ENNEMY_KILLED+wasted*FIREPOWER_WASTED+passed*ENNEMY_PASSED;
	}
	
	public static void waste(){
		wasted++;
	}
	
	public static void kill(){
		kills++;
	}
	
	public static void pass(){
		passed++;
	}

	public static int getKills() {
		return kills;
	}

	public static int getPassed() {
		return passed;
	}

	public static int getWasted() {
		return wasted;
	}
	
}
