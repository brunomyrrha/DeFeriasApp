package com.brunomyrrha.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.brunomyrrha.game.Resources.AnimatedChar;
import com.brunomyrrha.game.Resources.ImageLoader;


public class PlayState extends State {
    private Stage stage;
    private ImageLoader background, sesc, bgTrees, btnFoodUp;
    private AnimatedChar lion;




    public PlayState(GameStateManager gsm)
    {
        super(gsm);

        stage = new Stage (new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        background = new ImageLoader("bg",1f);
        bgTrees = new ImageLoader("bgTrees",1f);
        sesc = new ImageLoader("sescLogo",1f);
        lion = new AnimatedChar("lionIdle",.06f,3f);
        btnFoodUp = new ImageLoader("btn_food_up",1.2f);

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
        this.stage.act();
        this.stage.draw();

//
//        spriteBatch.begin();
//        lion.draw();
//        spriteBatch.draw(background.texture(),0,0,background.width(),background.height());
//        spriteBatch.draw(lion.textureRegion(),lion.centerScreen(),30, lion.width(),lion.height());
//        spriteBatch.draw(bgTrees.texture(),bgTrees.centerScreen(),0,bgTrees.width(),bgTrees.height());
//        spriteBatch.draw(sesc.texture(),sesc.centerScreen(),10,sesc.width(),sesc.height());
//        //Button
//        spriteBatch.draw(btnFoodUp.texture(),(btnFoodUp.width()*0)+btnFoodUp.centerScreen()-btnFoodUp.width()*.5f,Gdx.graphics.getHeight()-(btnFoodUp.texture().getHeight()),btnFoodUp.width(),btnFoodUp.height());
//        spriteBatch.draw(btnFoodUp.texture(),(btnFoodUp.width()*1)+btnFoodUp.centerScreen()-btnFoodUp.width()*.5f,Gdx.graphics.getHeight()-(btnFoodUp.texture().getHeight()),btnFoodUp.width(),btnFoodUp.height());
//        spriteBatch.draw(btnFoodUp.texture(),(btnFoodUp.width()*0)+btnFoodUp.centerScreen()-btnFoodUp.width()*.5f,Gdx.graphics.getHeight()-(btnFoodUp.texture().getHeight()*1.8f),btnFoodUp.width(),btnFoodUp.height());
//        spriteBatch.draw(btnFoodUp.texture(),(btnFoodUp.width()*1)+btnFoodUp.centerScreen()-btnFoodUp.width()*.5f,Gdx.graphics.getHeight()-(btnFoodUp.texture().getHeight()*1.8f),btnFoodUp.width(),btnFoodUp.height());
//        spriteBatch.end();
    }

    @Override
    public void dispose(){
        stage.dispose();
    }
}
