package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.Resources.AnimatedChar;
import com.brunomyrrha.game.Resources.ButtonLoader;
import com.brunomyrrha.game.Resources.Controller;
import com.brunomyrrha.game.Resources.ImageLoader;


public class PlayState extends State {
    public static SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera orthographicCamera;

    private ImageLoader background, sesc, bgTrees;
    private AnimatedChar lion;
    private Controller controller;


    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        //Enable debug for Logcat
        Gdx.app.setLogLevel(Application.LOG_DEBUG);


        //Enabling stagging and actors
        batch = new SpriteBatch();
        orthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),orthographicCamera);
        controller = new Controller(orthographicCamera, viewport,1f);
        background = new ImageLoader("bg",1f);
        bgTrees = new ImageLoader("bgTrees",1f);
        sesc = new ImageLoader("sescLogo",1f);
        lion = new AnimatedChar("lionIdle",.06f,3f);
    }

    @Override
    public void handleInput() {
        if(controller.isHungerPressed()) {
            Gdx.app.debug("Click","Click Ok");
            gsm.set(new NurseState(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(Stage stage) {
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        lion.draw();
        batch.draw(background.texture(),0,0,background.width(),background.height());
        batch.draw(lion.textureRegion(),lion.centerScreen(),30, lion.width(),lion.height());
        batch.draw(bgTrees.texture(),bgTrees.centerScreen(),0,bgTrees.width(),bgTrees.height());
        batch.draw(sesc.texture(),sesc.centerScreen(),10,sesc.width(),sesc.height());
        batch.end();

        controller.draw();
    }

    @Override
    public void dispose(){
        batch.dispose();
    }
}
