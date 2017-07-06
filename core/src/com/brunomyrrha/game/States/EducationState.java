package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.GameResources.WordSelector;
import com.brunomyrrha.game.Resources.ImageLoader;

import java.util.Random;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class EducationState extends State {
    private Viewport viewport;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private Table table;
    private TextButton button;

    private WordSelector wordSelector;
    private String word;

    private ImageLoader bg;

    private String answer = "0";

    public EducationState(GameStateManager gsm){
        super(gsm);
        //Enabling debug
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //Creating viewports
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        stage = new Stage(viewport,batch);

        skin = new Skin(Gdx.files.internal("button.json"));

        table = new Table();
        table.setFillParent(true);

        //importing and choosing words
        wordSelector = new WordSelector();
        wordSelector.importData();
        word = wordSelector.sortWord();
        bg = new ImageLoader("bg_edu",1f);
        generateMatrix(word);

        stage.addActor(table);
        Gdx.app.log("Palavra:",word);
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
            button = new TextButton(c.toString(),skin,"default");
            button.getLabel().setFontScale(2,2);
            button.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    check(c);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                }
            });
            table.add(button);
            i++;
        }
    }


    private void check(Character c) {
        if (word.contains(c.toString())) {
            if (answer.equals("0")) {
                answer = "";
            }
            answer += c;
            Gdx.app.log("LOGCAT", answer);
            Gdx.app.log("LOGCAT", word.indexOf(c.toString()) + "");
        } else {
            answer = "0";
            Gdx.app.log("LOGCAT", answer);
        }
    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        if ((word.contains(answer)) && (word.length() == answer.length())){
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
        this.stage.dispose();
        batch.dispose();
    }

}
