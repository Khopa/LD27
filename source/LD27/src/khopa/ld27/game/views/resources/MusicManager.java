package khopa.ld27.game.views.resources;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicManager {


	/**
	 * Currently playing music
	 */
	private static Music music;
	
	/**
	 * Current music key
	 */
	private static String key;
	
	/**
	 * Loaded tracks
	 */
	private static HashMap<String, Music> musics;
	
	/**
	 * Music Volume
	 */
	private static float volume = 1f;

	/**
	 * Enabled ?
	 */
	private static boolean enabled = false;
	

	public static void init(){
		musics = new HashMap<String, Music>();
	}
	
	public float getVolume() {
		return volume;
	}


	public static void setVolume(float value) {
		volume = value;
		if(music != null) music.setVolume(volume);
	}


	public static void load(String path, String key) {
		Music music = Gdx.audio.newMusic(Gdx.files.internal(path));
		if(music != null){
			musics.put(key, music);
		}
	}

	public static void dispose(String key) {
		musics.get(key).dispose();
		musics.remove(key);
	}


	public static void play(String newKey) {
		if(!enabled) return;
		if(music != null){
			music.stop();
		}
		key = newKey;
		music = musics.get(key);
		music.setLooping(true);
		music.play();
	}


	public static void pause() {
		if(music != null){
			music.pause();
		}
	}


	public static boolean isPlaying() {
		if(!(music == null)) return music.isPlaying();
		return false;
	}


	public static void enable() {
		enabled = true;
		if(music != null){
			music.play();
		}
	}

	public static void disable() {
		enabled = false;
		if(music != null){
			music.pause();
		}
	}


	public static boolean isEnabled() {
		return enabled;
	}
	
	// ---- Personnal Methods ---- \\
	
	public static Music getMusic() {
		return music;
	}
}
