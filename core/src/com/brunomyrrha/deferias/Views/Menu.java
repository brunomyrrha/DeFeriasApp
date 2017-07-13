package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.brunomyrrha.deferias.Controllers.Animated;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.State;
import com.brunomyrrha.deferias.DeFerias;

/**
 * Created by brunomyrrha on 12/07/17.
 */

public class Menu extends State {
    //Staging and Rendering fonts
    private Label title;
    private Table table;
    private Stage stage;

    private Texture background;
    private Animated lion;

    public Menu(GameStateManager gsm){
        super(gsm);
        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        title = DeFerias.FONT.getLabel("De Férias");
        table = new Table();
        stage = new Stage();

        table.add(title);
        table.setFillParent(true);
        table.top().pad(20);
        stage.addActor(table);

        background = new Texture(Gdx.files.internal("images/bg.png"));
        lion = new Animated("lion",.06f);
    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        lion.draw();
        sb.draw(lion.textureRegion(),((Gdx.graphics.getWidth()/2)-lion.textureRegion().getRegionWidth()/2),0);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
