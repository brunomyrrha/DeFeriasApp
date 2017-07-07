package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.brunomyrrha.game.Resources.ImageLoader;
import com.brunomyrrha.game.States.PlayState;

/**
 * Created by brunomyrrha on 07/07/2017.
 */

public class EducationVictory extends com.brunomyrrha.game.Resources.State {
    private SpriteBatch batch;
    private ImageLoader btnOk, bg, victoryStar;

    public EducationVictory(com.brunomyrrha.game.Resources.GameStateManager gsm, String word) {
        super(gsm);
        batch = new SpriteBatch();
        btnOk = new ImageLoader("btn_ok",1.2f);
        bg = new ImageLoader("vitoria",1f);
        victoryStar = new ImageLoader("parabens_star",.8f);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.pop();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(Stage stage) {
        batch.begin();
        batch.draw(bg.texture(),0,0);
        batch.draw(victoryStar.texture(),victoryStar.centerScreen(),(Gdx.graphics.getHeight()-victoryStar.height()-50f),victoryStar.width(),victoryStar.height());
        batch.draw(btnOk.texture(),btnOk.centerScreen(),(Gdx.graphics.getHeight()*.1f),btnOk.width(),btnOk.height());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
