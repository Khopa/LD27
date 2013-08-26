package khopa.ld27.game.views.resources;

import java.util.HashMap;
import java.util.Set;

import khopa.ld27.game.views.common.Tileset;

public class TextureManager{

	/**
	 * Texture map
	 */
	private static HashMap<String, Tileset> textureMap;
	
	
	public static void init(){
		textureMap = new HashMap<String, Tileset>();
	}

	public static void loadTexture(String path, String key, int cutX, int cutY) {
		if(!textureMap.containsKey(key)){
			textureMap.put(key, new Tileset(path, cutX, cutY));
		}
	}

	public static void disposeTexture(String key) {
		if(textureMap.containsKey(key)){
			textureMap.get(key).dispose();
			textureMap.remove(key);
		}
	}

	public static Tileset getTexture(String key) {
		return textureMap.get(key);
	}


	public static Set<String> getKeys(){
		return textureMap.keySet();
	}
	
	
}
