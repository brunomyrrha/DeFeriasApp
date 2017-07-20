package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.LoadManager;
import com.brunomyrrha.deferias.Controllers.State;
import com.brunomyrrha.deferias.DeFerias;

/**
 * Created by brunomyrrha on 17/07/2017.
 */

public class Help extends State {
    private Texture background;
    private Image button;
    private Stage stage;
    private Table okTable, table, scoreTable;
    private Viewport viewport;
    private Texture nameTable;
    private Image birdIcon, wordIcon;
    private Label label,seconds, trys;

    protected Help(final GameStateManager gsm, final LoadManager lm) {
        super(gsm, lm);
        cam.setToOrtho(false, Menu.WIDTH,Menu.HEIGHT);
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage (viewport);

        label = DeFerias.FONT.getLabel("Ajuda");

        background = lm.getTexture("bgSesc.png");
        button = new Image(lm.getTexture("btnBack.png"));
        nameTable = lm.getTexture("tipTableTexture.png");
        birdIcon = new Image(lm.getTexture("birdScreen.png"));
        wordIcon = new Image(lm.getTexture("wordScreen.png"));

        birdIcon.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gsm.set(new CultureHelp(gsm,lm));
            }
        });

        wordIcon.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gsm.set(new EducationHelp(gsm,lm));
            }
        });

        button.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gsm.set(new Menu(gsm,lm));
            }
        });

        Gdx.input.setInputProcessor(stage);

        okTable = new Table();
        table = new Table();

        scoreTable = new Table();
        scoreTable.setFillParent(true);


        scoreTable.add(birdIcon).pad(7);
        scoreTable.add(wordIcon).pad(7);
        scoreTable.top().padTop(300);

        table.add(label);
        table.setFillParent(true);
        table.top().padTop(50);

        okTable.add(button);
        okTable.setFillParent(true);
        okTable.bottom().padBottom(150);

        stage.addActor(scoreTable);
        stage.addActor(okTable);
        stage.addActor(table);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(nameTable,Menu.WIDTH/2-nameTable.getWidth()/2,Menu.HEIGHT-200);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
