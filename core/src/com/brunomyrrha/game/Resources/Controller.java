package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.States.PlayState;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class Controller {
    private Stage stage;
    private boolean  hungerPressed, healthPressed, educationPressed, culturePressed;
    private OrthographicCamera orthographicCamera;
    private Viewport viewport;

    public boolean isHungerPressed() {
        return hungerPressed;
    }

    public Controller(OrthographicCamera orthographicCamera, Viewport viewport, float SCALE){
        this.orthographicCamera = orthographicCamera;
        this.viewport = viewport;
        stage = new Stage(this.viewport, PlayState.batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.left().top();
        Image btnFood = new Image(new Texture("btn_food.png"));
        Image btnHealth = new Image(new Texture("btn_food.png"));
        Image btnEducation = new Image(new Texture("btn_food.png"));
        Image btnCulture = new Image(new Texture("btn_food.png"));

        btnFood.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));
        btnHealth.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));
        btnEducation.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));
        btnCulture.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));

        table.padLeft(Gdx.graphics.getWidth()*.5f-(btnFood.getWidth()));
        table.padTop(Gdx.graphics.getHeight()*.2f-(btnFood.getHeight()));

        btnFood.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                hungerPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                hungerPressed = false;
            }
        });
        table.add(btnFood).size(btnFood.getWidth(),btnFood.getHeight()).pad(5,5,5,5);
        table.add(btnHealth).size(btnFood.getWidth(),btnFood.getHeight()).pad(5,5,5,5);
        table.row();
        table.add(btnEducation).size(btnFood.getWidth(),btnFood.getHeight()).pad(5,5,5,5);
        table.add(btnCulture).size(btnFood.getWidth(),btnFood.getHeight()).pad(5,5,5,5);
        stage.addActor(table);
    }

    public void draw(){
        stage.draw();
    }
}
