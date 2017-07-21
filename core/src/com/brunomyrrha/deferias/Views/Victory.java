package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
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
 * Created by brunomyrrha on 14/07/2017.
 */

public class Victory extends State {
    private Texture victory, tipTableTexture,background;
    private Stage stage;
    private Label label, labelCount;
    private Table table, okTable;
    private Viewport viewport;
    private Image button;

    public Victory(final GameStateManager gsm, int word, final LoadManager lm){
        super(gsm,lm);
        cam.setToOrtho(false,Menu.WIDTH,Menu.HEIGHT);
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        //Asset Loader
        tipTableTexture = lm.getTexture("tipTableTexture.png");
        victory = lm.getTexture("victory.png");
        background = lm.getTexture("bgSesc.png");
        button = new Image(lm.getTexture("btnOk.png"));
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

        //Camera and Staging
        label = DeFerias.FONT.getLabel(word+" segundos");
        table = new Table();
        okTable = new Table();
        okTable.add(button);
        okTable.setFillParent(true);
        okTable.bottom().padBottom(150);

        table.add(label);
        table.bottom().padBottom(560);
        table.setFillParent(true);
        stage.addActor(table);
        stage.addActor(okTable);
    }

    public Victory(final GameStateManager gsm, String word, int trys, final LoadManager lm){
        super(gsm,lm);
        cam.setToOrtho(false,Menu.WIDTH,Menu.HEIGHT);
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        //Asset Loader
        tipTableTexture = lm.getTexture("table.png");
        victory = lm.getTexture("victory.png");
        background = lm.getTexture("bgSesc.png");
        button = new Image(lm.getTexture("btnOk.png"));
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

        //Camera and Staging
        label = DeFerias.FONT.getLabel(word);
        labelCount = DeFerias.FONT.getLabel("Erros: "+trys);
        table = new Table();
        okTable = new Table();
        okTable.add(button);
        okTable.setFillParent(true);
        okTable.bottom().padBottom(150);

        table.add(label);
        table.row();
        table.add(labelCount);
        table.setFillParent(true);
        stage.addActor(table);
        stage.addActor(okTable);
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
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(tipTableTexture,Menu.WIDTH/2-tipTableTexture.getWidth()/2,Menu.HEIGHT/2-tipTableTexture.getHeight()/2);
        sb.draw(victory,(Menu.WIDTH/2)-(victory.getWidth()/2),Menu.HEIGHT-victory.getHeight()-20);
        sb.end();
        stage.draw();

    }

    @Override
    public void dispose() {

    }
}
