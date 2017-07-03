package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class HealthState extends State {
    private float counter = 0;
    public HealthState(GameStateManager gsm){
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
            PlayState.SICK = false;
            PlayState.counter = 0;
            gsm.pop();
            this.dispose();
        }
    }

    @Override
    public void render(Stage stage) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void dispose() {

    }
}
