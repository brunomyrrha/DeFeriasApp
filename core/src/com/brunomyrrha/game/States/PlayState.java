package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.brunomyrrha.game.Resources.*;
import com.brunomyrrha.game.Resources.State;


public class PlayState extends State {

    private ImageLoader background, sesc, bgTrees;
    private AnimatedChar lion;
    public static Controller controller;
    private Stage stage;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        //Enable debug for Logcat
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //Enabling stagging and actors
        controller = new Controller();
        background = new ImageLoader("bg",1f);
        bgTrees = new ImageLoader("bgTrees",1f);
        sesc = new ImageLoader("sescLogo",1f);
        lion = new AnimatedChar("lionIdle",.06f,2.5f);
        stage = new Stage();
    }

    @Override
    public void handleInput() {
        if (controller.isHungerPressed()) {
            gsm.set(new HungerState(gsm));
        } else if (controller.isHealthPressed()) {
            gsm.set(new HealthState(gsm));
        } else if (controller.isCulturePressed()) {
            gsm.set(new CultureState(gsm));
        } else if (controller.isEducationPressed()) {
            gsm.set(new EducationState(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        lion.draw();
        sb.draw(background.texture(),0,0,background.width(),background.height());
        sb.draw(lion.textureRegion(),lion.centerScreen(),100, lion.width(),lion.height());
        sb.draw(bgTrees.texture(),bgTrees.centerScreen(),0,bgTrees.width(),bgTrees.height());
        sb.draw(sesc.texture(),sesc.centerScreen(),10,sesc.width(),sesc.height());
        sb.end();
        controller.draw();
    }

    @Override
    public void dispose(){
        lion.dispose();
        background.dispose();
        lion.dispose();
        bgTrees.dispose();
        sesc.dispose();
        controller.dispose();
    }
}
