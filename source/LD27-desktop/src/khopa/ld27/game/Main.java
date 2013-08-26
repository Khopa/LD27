package khopa.ld27.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "LD27";
		cfg.useGL20 = false;
		cfg.width = 1024;
		cfg.height = 768;
		cfg.fullscreen = true;
		
		new LwjglApplication(new GDXApp(), cfg);
	}
}
