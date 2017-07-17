package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.LoadManager;
import com.brunomyrrha.deferias.Controllers.State;

import static com.brunomyrrha.deferias.Views.Menu.HEIGHT;
import static com.brunomyrrha.deferias.Views.Menu.WIDTH;

/**
 * Created by brunomyrrha on 17/07/2017.
 */

public class Loading extends State {
    private boolean loaded = false;
    private Texture loadBG;
    public Loading(GameStateManager gsm, LoadManager lm) {
        super(gsm,lm);
        loadBG = new Texture("images/loading.png");
        cam.setToOrtho(false,WIDTH,HEIGHT);
    }

    @Override
    protected void handleInput() {
        
    }

    @Override
    public void update(float deltaTime) {
        if (lm.loading()){
            loaded = true;
            System.out.println("Complete");
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(loadBG,0,0);
        sb.end();
    }

    @Override
    public void dispose() {
        loadBG.dispose();
    }
}
