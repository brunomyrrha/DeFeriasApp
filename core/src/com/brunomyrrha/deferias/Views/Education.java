package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.LoadManager;
import com.brunomyrrha.deferias.Controllers.State;
import com.brunomyrrha.deferias.Controllers.WordSelector;
import com.brunomyrrha.deferias.DeFerias;

import java.util.Random;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Education extends State {
    private Texture background, tipTableTexture;
    private WordSelector wordSelector;
    private String word;
    private Array<Character> wordMatrix;
    private int trys = 0;

    //TextButton loader
    private TextButton textButton;
    private Array<TextButton> matrix;
    private Skin skin;
    private Label label;
    private Image closeButton;

    //Table and stage creators
    private Stage stage;
    private Table table, tipTable,closeTable;
    private Viewport viewport;

    public Education(final GameStateManager gsm, final LoadManager lm){
        super(gsm,lm);
        //Stage, camera, settings
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage(viewport);

        table = new Table();
        tipTable = new Table();
        closeTable = new Table();

        closeTable.setFillParent(true);
        table.setFillParent(true);
        tipTable.setFillParent(true);
        Gdx.input.setInputProcessor(stage);

        //Image loader
        background = lm.getTexture("bgSesc.png");
        tipTableTexture = lm.getTexture("tipTableTexture.png");
        closeButton = new Image(lm.getTexture("btnClose.png"));

        //Word loader, chooser, constructor
        wordMatrix = new Array<Character>();
        matrix = new Array<TextButton>();
        wordSelector = new WordSelector();
        word = wordSelector.chooseWord();
        label = DeFerias.FONT.getLabel(word.length()+" letras");
        skin = lm.getSkin("stoneButton.json");
        tipTable.add(label);
        tipTable.top().pad(90);

        //Stage loaders
        generateMatrix(word);
        addTable();
        table.padTop(150);

        closeButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gsm.set(new Menu(gsm,lm));
            }
        });
        closeTable.add(closeButton);
        closeTable.top().left().pad(15);


        stage.addActor(table);
        stage.addActor(tipTable);
        stage.addActor(closeTable);
        System.out.println(word);
    }

    private void generateMatrix(String word){
        Random rand = new Random();
        String base = "abcdefghijlmnopqrstuvxz";

        //Add Correct Buttons
        for (int i = 0; i < word.length(); i++){
            wordMatrix.add(word.charAt(i));
            textButton = new TextButton(word.charAt(i)+"",skin, "toggle");
            textButton.getLabel().setFontScale(1.5f);
            textButton.addListener(new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                }
            });
            matrix.add(textButton);
        }

        //Add Incorrect Buttons
        for (int i = word.length(); i < 12; i++){
            Character c = base.charAt(rand.nextInt(base.length()-1));
            while (wordMatrix.contains(c,true)){
                c = base.charAt(rand.nextInt(base.length()-1));
            }
            wordMatrix.add(c);
            textButton = new TextButton(c+"",skin,"default");
            textButton.getLabel().setFontScale(1.5f);
            textButton.addListener(new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    trys++;
                    reset();
                }
            });
        matrix.add(textButton);
        }
        //Shuffling Matrix
        matrix.shuffle();
    }

    private void addTable(){
        int line = 0;
        for (TextButton tb : matrix){
            if (line == 3){
                table.row();
                line = 0;
            }
            table.add(tb).pad(10);
            line ++;
        }
    }

    private void reset() {
        Gdx.input.vibrate(300);
        for (TextButton tb : matrix){
            if (tb.isChecked()){
                tb.toggle();
            }
        }
    }

    private int count() {
        int i = 0;
        for (TextButton tb : matrix){
            if (tb.isChecked()){
                i++;
            }
        }
        return i;
    }

    public boolean win (){
        if (word.length() == count()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void handleInput() {
        if (win()){
            gsm.set(new Victory(gsm,word,trys,lm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(tipTableTexture,(Menu.WIDTH/2)-(tipTableTexture.getWidth()/2),Menu.HEIGHT-tipTableTexture.getHeight()+10);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
