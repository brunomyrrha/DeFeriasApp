package com.brunomyrrha.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.brunomyrrha.game.States.GameStateManager;
import com.brunomyrrha.game.States.PlayState;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class DeFeriasGame extends ApplicationAdapter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static final String TITLE = "De Férias - O Jogo";

    private GameStateManager gsm;
    private Stage stage;

    @Override
    public void create () {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        gsm = new GameStateManager();
        Gdx.gl.glClearColor(1,0,0,1);

        gsm.push(new PlayState(gsm));
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //limpa tudo
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(stage);
    }

    @Override
    public void dispose (){


    }

}
