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
 * Created by brunomyrrha on 17/07/2017.
 */

public class Leaderboard extends State {
    private Texture background;
    private Image button;
    private Stage stage;
    private Table okTable, table;
    private Viewport viewport;
    private Texture nameTable;
    private Label label;

    protected Leaderboard(final GameStateManager gsm, final LoadManager lm) {
        super(gsm, lm);
        cam.setToOrtho(false, Menu.WIDTH,Menu.HEIGHT);
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage (viewport);
        label = DeFerias.FONT.getLabel("Recordes");

        background = lm.getTexture("bgSesc.png");
        button = new Image(lm.getTexture("btnOk.png"));
        nameTable = lm.getTexture("tipTableTexture.png");

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
        table.add(label);
        table.setFillParent(true);
        table.top().padTop(50);
        okTable.add(button);
        okTable.setFillParent(true);
        okTable.bottom().padBottom(250);
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
