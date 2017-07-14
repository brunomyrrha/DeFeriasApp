package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.Animated;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.State;

/**
 * Created by brunomyrrha on 12/07/17.
 */

public class Menu extends State {
    //Staging and Rendering fonts
    public static final int WIDTH = 800;
    public static final int HEIGHT = 1280;

    private Table table;
    private Stage stage;
    private Viewport viewport;

    private Image btnCulture,btnHealth,btnEducation,btnFood;

    private Texture background,sesc;
    private Animated lion;

    public Menu(final GameStateManager gsm){
        super(gsm);
        cam.setToOrtho(false,WIDTH,HEIGHT);
        viewport = new FitViewport(WIDTH,HEIGHT);
        table = new Table();
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        //Image loads
        background = new Texture(Gdx.files.internal("images/bg.png"));
        sesc = new Texture(Gdx.files.internal("images/sesc.png"));
        lion = new Animated("lion",.06f);
        btnCulture = new Image (new Texture(Gdx.files.internal("images/btnCulture.png")));
        btnHealth = new Image (new Texture(Gdx.files.internal("images/btnHealth.png")));
        btnEducation = new Image(new Texture(Gdx.files.internal("images/btnEducation.png")));
        btnFood = new Image(new Texture(Gdx.files.internal("images/btnFood.png")));

        //Listerners
        btnCulture.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Culture State");
            }
        });

        btnHealth.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Health State");
            }
        });

        btnFood.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Food State");
            }
        });

        btnEducation.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Education State");
                gsm.set(new Education(gsm));
                dispose();
            }
        });

        //Table Adds
        table.add(btnCulture).size(btnCulture.getWidth(),btnCulture.getHeight()).pad(10);
        table.add(btnEducation).size(btnEducation.getWidth(),btnEducation.getHeight()).pad(10);
        table.row();
        table.add(btnFood).size(btnFood.getWidth(),btnFood.getHeight()).pad(10);
        table.add(btnHealth).size(btnHealth.getWidth(),btnFood.getHeight()).pad(10);
        table.setFillParent(true);
        table.top().pad(360);
        //Table loads
        stage.addActor(table);
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
        lion.draw();
        sb.draw(lion.textureRegion(),150,60);
        sb.draw(sesc,0,0);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        lion.dispose();
        background.dispose();
        sesc.dispose();
        stage.dispose();
    }
}
