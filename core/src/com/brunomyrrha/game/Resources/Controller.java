package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private boolean  hungerPressed, healthPressed, educationPressed, culturePressed;
    private Table table;
    private Stage stage;
    private Image btnFood, btnHealth, btnCulture, btnEducation;

    public Controller() {
        table = new Table();
        stage = new Stage();
        table.setFillParent(true);
        table.left().top();
        btnFood = new Image(new Texture(Gdx.files.internal("img/" + "btn_food.png")));
        btnHealth = new Image(new Texture(Gdx.files.internal("img/" + "btn_health.png")));
        btnEducation = new Image(new Texture(Gdx.files.internal("img/" + "btn_education.png")));
        btnCulture = new Image(new Texture(Gdx.files.internal("img/" + "btn_culture.png")));
        btnFood.setSize(300 * (Gdx.graphics.getWidth() * (0.001f)), 234 * (Gdx.graphics.getWidth() * (0.001f)));
        btnHealth.setSize(300 * (Gdx.graphics.getWidth() * (0.001f)), 234 * (Gdx.graphics.getWidth() * (0.001f)));
        btnEducation.setSize(300 * (Gdx.graphics.getWidth() * (0.001f)), 234 * (Gdx.graphics.getWidth() * (0.001f)));
        btnCulture.setSize(300 * (Gdx.graphics.getWidth() * (0.001f)), 234 * (Gdx.graphics.getWidth() * (0.001f)));

        table.padLeft(Gdx.graphics.getWidth() * .5f - (btnFood.getWidth()));
        table.padTop(Gdx.graphics.getHeight() * .2f - (btnFood.getHeight()));
        Gdx.input.setInputProcessor(stage);

        //Create Input Listeners
        setControllers();

        //Create Button Table
        table.add(btnFood).size(btnFood.getWidth(), btnFood.getHeight()).pad(5, 5, 5, 5);
        table.add(btnHealth).size(btnFood.getWidth(), btnFood.getHeight()).pad(5, 5, 5, 5);
        table.row();
        table.add(btnEducation).size(btnFood.getWidth(), btnFood.getHeight()).pad(5, 5, 5, 5);
        table.add(btnCulture).size(btnFood.getWidth(), btnFood.getHeight()).pad(5, 5, 5, 5);
        stage.addActor(table);
    }

    public void setControllers(){
        btnFood.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                hungerPressed = true;
            }
        });

        btnHealth.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                healthPressed = true;
            }
        });

        btnEducation.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                educationPressed = true;
            }
        });

        btnCulture.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                culturePressed = true;
            }
        });
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

    public void draw(){
        stage.draw();
    }
    public void dispose(){
        stage.dispose();
    }
}
