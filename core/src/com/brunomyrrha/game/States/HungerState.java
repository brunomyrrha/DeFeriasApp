package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.brunomyrrha.game.Resources.State;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class HungerState extends State {
    private boolean running = true;
    float counter = 0;

    public HungerState(com.brunomyrrha.game.Resources.GameStateManager gsm){
        super(gsm);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            running = false;
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        counter += Gdx.graphics.getRawDeltaTime();
        if (counter > .9f){
            gsm.pop();
            this.dispose();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void dispose() {

    }
}
