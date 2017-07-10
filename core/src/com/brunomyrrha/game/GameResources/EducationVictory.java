package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.brunomyrrha.game.Resources.GameStateManager;
import com.brunomyrrha.game.Resources.ImageLoader;
import com.brunomyrrha.game.Resources.State;
import com.brunomyrrha.game.States.PlayState;

/**
 * Created by brunomyrrha on 07/07/2017.
 */

public class EducationVictory extends State {
    private SpriteBatch batch;
    private ImageLoader btnOk, bg, victoryStar, answer;
    private String word;
    private Table table;
    private Label label;
    private Label.LabelStyle style;
    private Stage stage;

    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private BitmapFont font72;

    public EducationVictory(GameStateManager gsm,String word) {
        super(gsm);
        batch = new SpriteBatch();
        stage = new Stage();

        this.word = word;
        table = new Table();
        answer = new ImageLoader("answerTable",.9f);
        btnOk = new ImageLoader("btn_ok",1.2f);
        bg = new ImageLoader("vitoria",1f);
        victoryStar = new ImageLoader("parabens_star",.8f);

        //Generate text fonts
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Zebrawood.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Math.round(100*(Gdx.graphics.getWidth()*.001f));
        parameter.color = Color.valueOf("#7ac144");
        parameter.borderColor = Color.valueOf("#0e8040");
        parameter.borderWidth = 3f;
        font72 = generator.generateFont(parameter);
        generator.dispose();

        style = new Label.LabelStyle();
        style.font = font72;
        label = new Label(word,style);
        table.add(label);
        table.setFillParent(true);
        table.pad(Gdx.graphics.getHeight()*.4f);
        stage.addActor(table);
    }


    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(Stage stage) {
        batch.begin();
        batch.draw(bg.texture(),0,0,bg.width(),bg.height());
        batch.draw(victoryStar.texture(),victoryStar.centerScreen(),(Gdx.graphics.getHeight()-victoryStar.height()-50f),victoryStar.width(),victoryStar.height());
        batch.draw(btnOk.texture(),btnOk.centerScreen(),(Gdx.graphics.getHeight()*.1f),btnOk.width(),btnOk.height());
        batch.draw(answer.texture(),answer.centerScreen(),Gdx.graphics.getHeight()*.42f,answer.width(),answer.height());
        batch.end();
        this.stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
