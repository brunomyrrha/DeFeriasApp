package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.LoadManager;
import com.brunomyrrha.deferias.Controllers.State;

/**
 * Created by brunomyrrha on 20/07/2017.
 */

public class CultureHelp extends State {
    private Texture background;
    private Texture back;
    protected CultureHelp(GameStateManager gsm, LoadManager lm) {
        super(gsm, lm);
        background = lm.getTexture("helpBird.png");
        back = lm.getTexture("btnBack.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new Help(gsm,lm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(back, Menu.WIDTH/2-back.getWidth()/2,150);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
