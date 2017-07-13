package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
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

    private ImageButton culture,health,education,food;

    private Texture background,sesc,btnCulture,btnHealth,btnEducation,btnFood;
    private Animated lion;

    public Menu(GameStateManager gsm){
        super(gsm);
        cam.setToOrtho(false,360,540);
        title = DeFerias.FONT.getLabel("De Férias");
        table = new Table();
        stage = new Stage();

        //Image loads
        background = new Texture(Gdx.files.internal("images/bg.png"));
        sesc = new Texture(Gdx.files.internal("images/sesc.png"));
        lion = new Animated("lion",.06f);
        btnCulture = new Texture(Gdx.files.internal("images/btnCulture.png"));
        btnHealth = new Texture(Gdx.files.internal("images/btnHealth.png"));
        btnEducation = new Texture(Gdx.files.internal("images/btnEducation.png"));
        btnFood = new Texture(Gdx.files.internal("images/btnFood.png"));


        //Table loads
        table.add(title);
        table.setFillParent(true);
        table.top().pad(20);
        stage.addActor(table);

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
        sb.draw(background,0,0);
        lion.draw();
        sb.draw(lion.textureRegion(),60,20);
        sb.draw(sesc,0,0);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
