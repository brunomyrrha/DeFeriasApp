package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.brunomyrrha.game.DeFeriasGame;
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
    private Stage stage;

    public EducationVictory(GameStateManager gsm,String word) {
        super(gsm);
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        this.word = word;
        table = new Table();
        answer = new ImageLoader("answerTable",.9f);
        btnOk = new ImageLoader("btn_ok",1.2f);
        bg = new ImageLoader("vitoria",1f);
        victoryStar = new ImageLoader("parabens_star",.8f);

        //Generate text fonts
        table.add(DeFeriasGame.font.getLabel(word));
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
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg.texture(),0,0,bg.width(),bg.height());
        sb.draw(victoryStar.texture(),victoryStar.centerScreen(),(Gdx.graphics.getHeight()-victoryStar.height()-50f),victoryStar.width(),victoryStar.height());
        sb.draw(btnOk.texture(),btnOk.centerScreen(),(Gdx.graphics.getHeight()*.1f),btnOk.width(),btnOk.height());
        sb.draw(answer.texture(),answer.centerScreen(),Gdx.graphics.getHeight()*.42f,answer.width(),answer.height());
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();

    }
}
