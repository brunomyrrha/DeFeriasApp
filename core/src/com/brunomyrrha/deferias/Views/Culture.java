package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.Bird;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.Obstacle;
import com.brunomyrrha.deferias.Controllers.State;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Culture extends State {
    private static final int TREE_COUNT = 4;
    private static final int TREE_SPACING = 200;

    private Bird bird;
    private Texture background;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private OrthographicCamera camera;
    private Obstacle tree;
    private Array<Obstacle> trees;

    public Culture(GameStateManager gsm) {
        super(gsm);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Menu.WIDTH,Menu.HEIGHT);
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        stage = new Stage(viewport);
        table = new Table();
        bird = new Bird();
        tree = new Obstacle(1);
        trees = new Array<Obstacle>();
        for (int i = 1; i <= TREE_COUNT; i++){
            trees.add(new Obstacle(i*(TREE_SPACING + tree.getTextureTop().getWidth())));
        }
        background = new Texture(Gdx.files.internal("images/bgSesc.png"));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        bird.update(deltaTime);
        camera.position.x = bird.getPosition().x+390;
        camera.update();

        for (Obstacle obstacle: trees){
            if (camera.position.x > tree.getPositionTop().x + tree.getTextureTop().getWidth()*2 + bird.getTexture().getWidth()*2){
                tree.reposition((tree.getPositionTop().x + tree.getTextureTop().getWidth() + TREE_SPACING )*TREE_COUNT);
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background,camera.position.x-400,0);
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        for(Obstacle obstacle : trees){
            sb.draw(tree.getTextureTop(),tree.getPositionTop().x,tree.getPositionTop().y);
            sb.draw(tree.getTextureBot(),tree.getPositionBot().x,tree.getPositionBot().y);
        }
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        bird.getTexture().dispose();
        stage.dispose();
    }
}
