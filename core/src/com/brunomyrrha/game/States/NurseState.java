package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class NurseState extends State {
    private float counter = 0;
    public NurseState(GameStateManager gsm){
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
        if (counter > 5){
            gsm.set(new PlayState(gsm));
            this.dispose();
        }
    }

    @Override
    public void render(Stage stage) {
    }

    @Override
    public void dispose() {

    }
}
