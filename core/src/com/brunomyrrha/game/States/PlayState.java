package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.brunomyrrha.game.Resources.AnimatedChar;
import com.brunomyrrha.game.Resources.ButtonLoader;
import com.brunomyrrha.game.Resources.ImageLoader;


public class PlayState extends State {
    private Stage stage;
    private ImageLoader background, sesc, bgTrees, btnFoodUpTexture,btnFoodDownTexture;
    private AnimatedChar lion;
    private ButtonLoader btnFood;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        //Enable debug for Logcat
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //Enabling stagging and actors
        stage = new Stage (new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));

        background = new ImageLoader("bg",1f);
        bgTrees = new ImageLoader("bgTrees",1f);
        sesc = new ImageLoader("sescLogo",1f);
        lion = new AnimatedChar("lionIdle",.06f,3f);

        //Starting button creation
        btnFoodUpTexture = new ImageLoader("btn_food_up",1.5f);
        btnFoodDownTexture = new ImageLoader("btn_food_down",1.5f);
        btnFood = new ButtonLoader(btnFoodUpTexture,btnFoodDownTexture);

        //Enabling handling
        btnFood.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
               return true;
            }
        });

        //Add button to stage
        stage.addActor(btnFood);


        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void handleInput() {
        if(false) {
            gsm.set(new NurseState(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(Stage stage) {
        stage.act(Gdx.graphics.getDeltaTime());
        lion.draw();

//        stage.getBatch().begin();
//        stage.getBatch().draw(background.texture(),0,0,background.width(),background.height());
//        stage.getBatch().draw(lion.textureRegion(),lion.centerScreen(),30, lion.width(),lion.height());
//        stage.getBatch().draw(bgTrees.texture(),bgTrees.centerScreen(),0,bgTrees.width(),bgTrees.height());
//        stage.getBatch().draw(sesc.texture(),sesc.centerScreen(),10,sesc.width(),sesc.height());
//        stage.getBatch().end();

        stage.draw();
    }

    @Override
    public void dispose(){
        stage.dispose();
    }
}
