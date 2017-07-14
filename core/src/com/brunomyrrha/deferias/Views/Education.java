package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
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

    //ImageButton loader
    private ImageButton imageButton;
    private Skin skin;
    private Label label;

    //Table and stage creators
    private Stage stage;
    private Table table, tipTable;
    private Viewport viewport;

    public Education(GameStateManager gsm){
        super(gsm);
        //Stage, camera, settings
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage(viewport);
        table = new Table();
        tipTable = new Table();
        table.setFillParent(true);
        tipTable.setFillParent(true);
        Gdx.input.setInputProcessor(stage);

        //Image loader
        background = new Texture(Gdx.files.internal("images/bgSesc.png"));
        tipTableTexture = new Texture(Gdx.files.internal("images/tipTableTexture.png"));

        //Word loader, chooser, constructor
        wordSelector = new WordSelector();
        word = wordSelector.chooseWord();
        label = DeFerias.FONT.getLabel("Letras: " +word.length()+"");
        skin = new Skin(Gdx.files.internal("images/stoneButton.json"));
        tipTable.add(label);
        tipTable.top().pad(90);

        //Stage loaders
        stage.addActor(table);
        stage.addActor(tipTable);
        System.out.println(word);
    }

    private void generateMatrix(String word){
        Random rand = new Random();
        String base = "abcdefghijlmnopqrstuvxz";

        for (int i = 0; i < word.length(); i++){

        }
    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(tipTableTexture,(Menu.WIDTH/2)-(tipTableTexture.getWidth()/2),Menu.HEIGHT-tipTableTexture.getHeight());
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        background.dispose();
    }
}
