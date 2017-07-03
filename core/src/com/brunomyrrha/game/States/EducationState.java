package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.brunomyrrha.game.GameResources.WordSelector;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class EducationState extends State {
    private boolean running = true;
    private WordSelector wordSelector;
    private String word;
    private BitmapFont bitmapFont;
    private SpriteBatch spriteBatch;



    int i;
    float counter = 0;

    public EducationState(GameStateManager gsm){
        super(gsm);
        bitmapFont = new BitmapFont();
        wordSelector = new WordSelector();
        wordSelector.importData();
        word = wordSelector.sortWord();
        i = word.length();
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    @Override
    protected void handleInput() {
        Gdx.app.log("LOGCAT",word + " | "+i);
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
    public void render(Stage stage) {
        Gdx.gl.glClearColor(0,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
    }

}
