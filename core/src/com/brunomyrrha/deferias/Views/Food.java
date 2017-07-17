package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.State;

/**
 * Created by brunomyrrha on 15/07/17.
 */

public class Food extends State {

    private Texture background;

    public Food(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, Menu.WIDTH, Menu.HEIGHT);
        background = new Texture(Gdx.files.internal("images/bgSesc.png"));
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
