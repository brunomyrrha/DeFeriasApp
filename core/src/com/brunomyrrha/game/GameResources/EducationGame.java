package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.States.EducationState;


/**
 * Created by brunomyrrha on 03/07/17.
 */

public class EducationGame {
    private OrthographicCamera orthographicCamera;
    private Viewport viewport;
    private Stage stage;

    private TextureAtlas textureAtlas;
    private TextureRegion textureRegion;
    private Image image;
    private Table table;

    private int size, winCount;
    private boolean win = false;

    public EducationGame(OrthographicCamera orthographicCamera, Viewport viewport, float SCALE){
        this.orthographicCamera = orthographicCamera;
        this.viewport = viewport;
        stage = new Stage(this.viewport, EducationState.batch);
        textureAtlas = new TextureAtlas(Gdx.files.internal("letras.atlas"));
        table = new Table();
        table.setFillParent(true);
        Gdx.input.setInputProcessor(stage);
    }
    public void setWord(String word){
        size = word.length();
        textureRegion = textureAtlas.findRegion(word.charAt(0)+"");
        for (int i = 0; i < 4 ; i++){
            for (int j = 0; j < 4; j++){
                image = new Image(textureRegion);
                table.add(image);
            }
            table.row();
        }
        stage.addActor(table);
    }

    public boolean gameOver(){
        if (winCount >= size){
            return true;
        } else {
            return false;
        }
    }

    public void draw(){
        stage.draw();
    }
}
