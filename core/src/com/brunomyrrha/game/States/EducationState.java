package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.GameResources.Letter;
import com.brunomyrrha.game.GameResources.WordSelector;
import com.brunomyrrha.game.Resources.ImageLoader;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.lang.model.element.Element;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class EducationState extends State {
    private Viewport viewport;
    private SpriteBatch batch;
    private WordSelector wordSelector;
    private String word;
    private Stage stage;
    private Table table;
    private Letter letter;
    private Image image;
    private ImageLoader bg;
    private boolean clicked;
    private String done;

    public EducationState(GameStateManager gsm){
        super(gsm);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        stage = new Stage(viewport,batch);
        wordSelector = new WordSelector();
        wordSelector.importData();
        word = wordSelector.sortWord();
        table = new Table();
        image = new Image();
        letter = new Letter();
        bg = new ImageLoader("bg_edu",1f);
        done = "";
        table.setFillParent(true);
        table.top().padTop(40f);
        generateMatrix(word);
        Gdx.app.log("Palavra:",word);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    public void generateMatrix(final String word) {
        Array <Character> list = new Array<Character>();
        Random rand = new Random();
        String base = "abcdefghijklmnopqrstuvwxyz";
        Character value;

        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        for (int i = word.length(); i < 9; i++){
            value = base.charAt(rand.nextInt(base.length()));

            for (Character c : list){
                while (value == c){
                    value = base.charAt(rand.nextInt(base.length()));
                }
            }
            list.add(value);
        }
        list.shuffle();
        int i = 0;
        for(final Character c: list) {
            if (i > 2){
                table.row();
                i = 0;
            }
            image = letter.getImage(c.toString());
            image.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    clicked = true;
                    done+=c;
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    clicked = false;
                }
            });
            table.add(image).size(image.getWidth()*((Gdx.graphics.getWidth()*0.001f)* .75f),image.getHeight()*((Gdx.graphics.getWidth()*0.001f)* .75f));
            Gdx.app.log("LOG",c.toString());
            i++;
        }
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        if (word.equals(done)) {

            gsm.pop();
            gsm.push(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void render(Stage stage) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(bg.texture(),0,0,bg.width(),bg.height());
        batch.end();
        this.stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
