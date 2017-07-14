package com.brunomyrrha.deferias;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brunomyrrha.deferias.Controllers.Font;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Views.Culture;
import com.brunomyrrha.deferias.Views.Menu;

public class DeFerias extends ApplicationAdapter {
	public static Font FONT;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 640;
	public static final String TITLE = "De Férias";

	private GameStateManager gsm;
	private SpriteBatch sb;
	
	@Override
	public void create () {
		FONT = new Font();
		gsm = new GameStateManager();
		sb = new SpriteBatch();
		gsm.push(new Menu(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
	
	@Override
	public void dispose () {
		sb.dispose();
	}
}
