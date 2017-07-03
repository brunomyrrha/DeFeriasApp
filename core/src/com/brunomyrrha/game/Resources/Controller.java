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


    public Controller(OrthographicCamera orthographicCamera, Viewport viewport, float SCALE){
        this.orthographicCamera = orthographicCamera;
        this.viewport = viewport;
        stage = new Stage(this.viewport, PlayState.batch);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.left().top();
        Image btnFood = new Image(new Texture("btn_food.png"));
        Image btnHealth = new Image(new Texture("btn_health.png"));
        Image btnEducation = new Image(new Texture("btn_education.png"));
        Image btnCulture = new Image(new Texture("btn_culture.png"));

        btnFood.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));
        btnHealth.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));
        btnEducation.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));
        btnCulture.setSize(300*(Gdx.graphics.getWidth()*(0.001f)*SCALE),234*(Gdx.graphics.getWidth()*(0.001f)*SCALE));

        table.padLeft(Gdx.graphics.getWidth()*.5f-(btnFood.getWidth()));
        table.padTop(Gdx.graphics.getHeight()*.2f-(btnFood.getHeight()));

        //Create Input Listeners
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

        btnHealth.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                healthPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                healthPressed = false;
            }
        });

        btnEducation.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                educationPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                educationPressed = false;
            }
        });

        btnCulture.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                culturePressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                culturePressed = false;
            }
        });

        //Create Button Table
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

    public boolean isHungerPressed() {
        return hungerPressed;
    }

    public boolean isHealthPressed() {
        return healthPressed;
    }

    public boolean isEducationPressed() {
        return educationPressed;
    }

    public boolean isCulturePressed() {
        return culturePressed;
    }
}
