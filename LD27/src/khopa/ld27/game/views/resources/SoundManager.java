package khopa.ld27.game.views.resources;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

	/**
	 * enabled or not
	 */
	protected static boolean ENABLED = true;
	
	/**
	 * sound level (0f-1f)
	 */
	protected static float volume = 1f;
	
	/**
	 * path to sounds
	 */
	protected static String directory = "data/sfx/";
	
	/**
	 * file type
	 */
	protected static String extension = ".ogg";
	
	
	/**
	 * sounds dictionnary
	 */
	protected static HashMap<String, Sound> soundDictionnary;
	
	/**
	 * init
	 */
	public static void init(){
		soundDictionnary = new HashMap<String, Sound>();
	}
	
	/**
	 * Play sound, load it if not loaded
	 */
	public static void play(String name){
		
		if(!ENABLED) return;
		
		if(!soundDictionnary.containsKey(name)){
			soundDictionnary.put(name, Gdx.audio.newSound(Gdx.files.internal(directory+name+extension)));
		}
		soundDictionnary.get(name).play(volume);
	}
	
	/**
	 * dispose sound
	 */
	public static void dispose(String name){
		soundDictionnary.get(name).dispose();
		soundDictionnary.remove(name);
	}
	
	
	/**
	 *  Sound Level
	 */
	public static void setVolume(float value){
		volume = value;
	}
	
	public static float getVolume(){
		return volume;
	}
	
	
	
}
