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

    private CharSelector letter;
    private Table table;

    public EducationGame(OrthographicCamera orthographicCamera, Viewport viewport, float SCALE){
        this.orthographicCamera = orthographicCamera;
        this.viewport = viewport;
        stage = new Stage(this.viewport, EducationState.batch);
        table = new Table();
        table.setFillParent(true);
        Gdx.input.setInputProcessor(stage);
    }

    public void setWord(String word){
        for (int i = 0; i < 4 ; i++){
            for (int j = 0; j < 4; j++){
                letter = new CharSelector("a");
                table.addActor(letter.letter());
            }
            table.row();
        }
//        stage.addActor(table);
    }

    public boolean gameOver(){
        if (true){
            return true;
        } else {
            return false;
        }
    }

    public void draw(){
        stage.draw();
    }
}
