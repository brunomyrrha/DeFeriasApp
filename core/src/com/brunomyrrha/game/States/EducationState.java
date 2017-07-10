package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.brunomyrrha.game.GameResources.WordSelector;
import com.brunomyrrha.game.Resources.ImageLoader;
import com.brunomyrrha.game.Resources.*;
import com.brunomyrrha.game.GameResources.*;
import java.util.Random;

import static com.brunomyrrha.game.DeFeriasGame.font;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class EducationState extends State {
    private Stage stage;
    private Skin skin;
    private Table table, tipTable;
    private Label label;
    private Array<TextButton> matrix, correctAnswer;
    private ImageLoader bg, answerTable;
    private TextButton button, buttonRight;
    private WordSelector wordSelector;
    private String word, returnText;
    private Array<Character> wordMatrix;
    private int newLine = 0;
    private int answer = 0;
    private float SCALE;

    public EducationState(GameStateManager gsm){
        super(gsm);

        //Enabling debug
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //Creating viewports
        SCALE = (Gdx.graphics.getWidth()*.001f)*2;
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("button.json"));
        table = new Table();
        table.setFillParent(true);
        tipTable = new Table();
        tipTable.setFillParent(true);
        tipTable.top();
        tipTable.left();

        //importing and choosing words
        wordSelector = new WordSelector();
        wordSelector.importData();
        word = wordSelector.sortWord();
        matrix = new Array<TextButton>();
        correctAnswer = new Array<TextButton>();
        bg = new ImageLoader("bg_edu",1f);
        answerTable = new ImageLoader("answerTable",.9f);
        wordMatrix = new Array<Character>();
        generateMatrix(word);

        //generating text
        tipTable.padTop(Gdx.graphics.getHeight()*.115f);
        tipTable.padLeft(Gdx.graphics.getWidth()*.28f);

        //Getting game stage done
        stage.addActor(tipTable);
        stage.addActor(table);
        Gdx.app.log("Palavra:",word);
        Gdx.input.setInputProcessor(stage);
    }

    public void generateMatrix(final String word) {
        Random rand = new Random();
        String base = "abcdefghijlmnopqrstuvxz";

        //Add the correct buttons to matrix.
        for (int i = 0; i < word.length(); i++){
            wordMatrix.add(word.charAt(i));
            buttonRight = new TextButton(word.charAt(i)+"",skin,"toggle");
            buttonRight.setName(word.charAt(i)+"");
            buttonRight.getLabel().setFontScale(SCALE);
            buttonRight.addListener(new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }
                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                }
            });
            matrix.add(buttonRight);
            correctAnswer.add(buttonRight);
        }

        //Add the wrong buttons to matrix.
        for (int i = word.length(); i < 9; i++) {
            Character c = base.charAt(rand.nextInt(base.length()-1));
            while (wordMatrix.contains(c,true)){
                c = base.charAt(rand.nextInt(base.length()-1));
            }
            wordMatrix.add(c);
            button = new TextButton(c+"",skin,"default");
            button.getLabel().setFontScale(SCALE);
            button.addListener(new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    reset();
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                }
            });
            matrix.add(button);
        }

        //Shuffle buttons.
        matrix.shuffle();

        //Add buttons to table.
        for (TextButton tb : matrix){
            if (newLine == 3){
                table.row();
                newLine = 0;
            }
            table.add(tb).size((SCALE*button.getWidth()*.4f),(SCALE*button.getHeight()*.4f));
            newLine++;
        }
    }

    private void countToggle(){
        label = font.getLabel("");
        answer = 0;
        returnText = word.length()+" letras";
        tipTable.removeActor(label);
        label.setText(returnText);
        tipTable.add(label).size(label.getWidth(), label.getHeight());
        for(TextButton tb : matrix){
            if(tb.isChecked()){
                if(word.contains(tb.getText())) {
                    answer++;
                }
            }
        }
    }

    private void reset() {
        Gdx.input.vibrate(500);
        for (TextButton tb : matrix){
            if (tb.isChecked()){
                tb.toggle();
                tipTable.removeActor(label);
            }
        }
        tipTable.removeActor(label);
    }

    public boolean win() {
        if (word.length() == answer) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void handleInput() {
        countToggle();
        if (win()){
            dispose();
            gsm.set(new EducationVictory(gsm,word));
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
        sb.draw(bg.texture(),0,0,bg.width(),bg.height());
        sb.draw(answerTable.texture(),answerTable.centerScreen(),(Gdx.graphics.getHeight()-(answerTable.height())),answerTable.width(),answerTable.height());
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        bg.dispose();
        answerTable.dispose();
    }
}
