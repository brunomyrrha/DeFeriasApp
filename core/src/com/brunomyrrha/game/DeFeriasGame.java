package com.brunomyrrha.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.brunomyrrha.game.GameResources.EducationVictory;
import com.brunomyrrha.game.Resources.GenerateFont;
import com.brunomyrrha.game.States.CultureState;
import com.brunomyrrha.game.States.EducationState;
import com.brunomyrrha.game.Resources.GameStateManager;
import com.brunomyrrha.game.States.PlayState;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class DeFeriasGame extends ApplicationAdapter {
    public static GenerateFont font;
    public static final int WIDTH = 360;
    public static final int HEIGHT = 540;
    public static final String TITLE = "De Férias - O Jogo";

    private GameStateManager gsm;
    private SpriteBatch sb;

    @Override
    public void create () {
        font = new GenerateFont();
        sb = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new PlayState(gsm));
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //limpa tudo
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(sb);
    }

    @Override
    public void dispose (){
    }
}
