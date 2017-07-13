package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by brunomyrrha on 12/07/17.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    protected Stage stage;

    protected State(GameStateManager gsm){
        cam = new OrthographicCamera();
        mouse = new Vector3();

    }

    protected abstract void handleInput();
    public abstract void update (float deltaTime);
    public abstract void render (SpriteBatch sb);
    public abstract void dispose();

}
