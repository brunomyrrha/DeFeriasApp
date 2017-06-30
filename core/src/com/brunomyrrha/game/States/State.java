package com.brunomyrrha.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
   }


    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(Stage stage);
    public abstract void dispose();
}
