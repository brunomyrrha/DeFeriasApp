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

public class Victory extends State {
    private Texture victory, tipTableTexture,background,btnOk;
    private Stage stage;
    private Label label;
    private Table table;
    private Viewport viewport;


    public Victory(GameStateManager gsm, String word){
        super(gsm);
        tipTableTexture = new Texture(Gdx.files.internal("images/tipTableTexture.png"));
        victory = new Texture(Gdx.files.internal("images/victory.png"));
        background = new Texture(Gdx.files.internal("images/bgSesc.png"));
        btnOk = new Texture (Gdx.files.internal("images/btnOk.png"));

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
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(tipTableTexture,Menu.WIDTH/2-tipTableTexture.getWidth()/2,Menu.HEIGHT/2-90);
        sb.draw(victory,(Menu.WIDTH/2)-(victory.getWidth()/2),Menu.HEIGHT-victory.getHeight()-20);
        sb.draw(btnOk,Menu.WIDTH/2-btnOk.getWidth()/2,230);
        sb.end();
        stage.draw();

    }

    @Override
    public void dispose() {

    }
}
