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

public class HealthState extends State {
    private float counter = 0;
    public HealthState(com.brunomyrrha.game.Resources.GameStateManager gsm){
        super(gsm);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        counter += Gdx.graphics.getRawDeltaTime();
        Gdx.app.debug("Countdown:",counter+"");
        if (counter > 2){
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void dispose() {

    }
}
