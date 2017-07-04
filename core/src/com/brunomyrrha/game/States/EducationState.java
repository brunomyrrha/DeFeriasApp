package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.GameResources.EducationGame;
import com.brunomyrrha.game.GameResources.WordSelector;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class EducationState extends State {
    public static SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera orthographicCamera;

    private boolean running = true;
    private WordSelector wordSelector;
    private String word;
    private EducationGame educationGame;

    public EducationState(GameStateManager gsm){
        super(gsm);

        batch = new SpriteBatch();
        orthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),orthographicCamera);
        educationGame = new EducationGame(orthographicCamera,viewport,1f);
        wordSelector = new WordSelector();
        wordSelector.importData();
        word = wordSelector.sortWord();
        educationGame.setWord(word);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    @Override
    protected void handleInput() {
        Gdx.app.log("LOGCAT",word);
        if (educationGame.gameOver()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(Stage stage) {
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        educationGame.draw();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }

}
