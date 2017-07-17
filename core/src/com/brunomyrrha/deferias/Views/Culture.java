package com.brunomyrrha.deferias.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.deferias.Controllers.Bird;
import com.brunomyrrha.deferias.Controllers.GameStateManager;
import com.brunomyrrha.deferias.Controllers.LoadManager;
import com.brunomyrrha.deferias.Controllers.Obstacle;
import com.brunomyrrha.deferias.Controllers.State;
import com.brunomyrrha.deferias.DeFerias;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Culture extends State {
    private static final int TREE_COUNT = 2;
    private int TREE_SPACING = 250;
    private float time;

    private Bird bird;
    private Texture background, scoreTable, sesc;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private Label label;
    private OrthographicCamera camera;
    private Obstacle tree;
    private Array<Obstacle> trees;
    private float seconds = 0;

    public Culture(GameStateManager gsm, LoadManager lm) {
        super(gsm, lm);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Menu.WIDTH,Menu.HEIGHT);
        viewport = new FitViewport(Menu.WIDTH,Menu.HEIGHT);
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchMenuKey(true);


        stage = new Stage(viewport);
        table = new Table();

        //Image Loads
        scoreTable = lm.getTexture("tipTableTexture.png");
        background = lm.getTexture("bg.png");
        sesc = lm.getTexture("bgParrot.png");

        table.setPosition(Menu.WIDTH/2-50,Menu.HEIGHT-195);
        bird = new Bird(lm);
        tree = new Obstacle(1,lm);
        trees = new Array<Obstacle>();

        for (int i = 1; i <= TREE_COUNT; i++){
            trees.add(new Obstacle(i*(TREE_SPACING + tree.getTextureTop().getWidth()+150),lm));
        }

        stage.addActor(table);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            bird.jump();
        }
        time+=Gdx.graphics.getRawDeltaTime();
        if (Math.round(time) % 10 == 0){
            TREE_SPACING++;
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        bird.update(deltaTime);
        camera.position.x = bird.getPosition().x + 390;
        camera.update();

        for (Obstacle obstacle: trees){
            if (camera.position.x - 650 >= obstacle.getPositionTop().x){
                obstacle.reposition(camera.position.x + TREE_SPACING * TREE_COUNT);
            }
            if (obstacle.collides(bird.getHitBox())){
                Gdx.input.vibrate(300);
                gsm.set(new Victory(gsm,Math.round(seconds)+" segundos",lm));
            }
        }
        seconds += Gdx.graphics.getRawDeltaTime();
        bird.setMovement();
        table.clear();
        label = DeFerias.FONT.getLabel(Math.round(seconds)+ "s");
        table.addActor(label);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background,camera.position.x-400,0);
        for(Obstacle obstacle : trees){
            sb.draw(obstacle.getTextureTop(),obstacle.getPositionTop().x,obstacle.getPositionTop().y);
            sb.draw(obstacle.getTextureBot(),obstacle.getPositionBot().x,obstacle.getPositionBot().y);
//            System.out.println(obstacle.getPositionTop());
        }
        sb.draw(scoreTable,camera.position.x-scoreTable.getWidth()/2,Menu.HEIGHT-scoreTable.getHeight()+10);
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        sb.draw(sesc,camera.position.x-400,0);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
