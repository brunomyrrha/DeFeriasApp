package com.brunomyrrha.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brunomyrrha.game.DeFeriasGame;
import com.brunomyrrha.game.States.Teste;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DeFeriasGame.WIDTH;
		config.height = DeFeriasGame.HEIGHT;
		config.title = DeFeriasGame.TITLE;
		new LwjglApplication(new Teste(), config);
	}
}
