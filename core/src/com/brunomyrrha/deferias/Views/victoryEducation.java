package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.State;
import com.brunomyrrha.deferias.DeFerias;

import javax.swing.text.View;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class victoryEducation extends State {
    private Texture victory, tipTableTexture,bg;
    private Stage stage;
    private Label label;
    private Table table;
    private Viewport viewport;


    public victoryEducation(GameStateManager gsm, String word){
        super(gsm);
        tipTableTexture = new Texture(Gdx.files.internal("images/tipTableTexture.png"));
        victory = new Texture(Gdx.files.internal("images/victory.png"));
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage(viewport);
        label = DeFerias.FONT.getLabel(word);
        table = new Table();
        table.add(label);
        table.setFillParent(true);
        stage.addActor(table);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new Menu(gsm));
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        stage.draw();
        sb.begin();
        sb.draw(tipTableTexture,0,0);
        sb.draw(victory,0,0);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
