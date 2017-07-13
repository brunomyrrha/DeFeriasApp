package com.brunomyrrha.deferias.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brunomyrrha.deferias.DeFerias;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DeFerias.WIDTH;
		config.height = DeFerias.HEIGHT;
		config.title = DeFerias.TITLE;
		new LwjglApplication(new DeFerias(), config);
	}
}
