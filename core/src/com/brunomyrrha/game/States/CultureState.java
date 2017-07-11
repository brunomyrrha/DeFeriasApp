package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.brunomyrrha.game.GameResources.Bird;
import com.brunomyrrha.game.GameResources.TreeObstacle;
import com.brunomyrrha.game.Resources.GameStateManager;
import com.brunomyrrha.game.Resources.ImageLoader;
import com.brunomyrrha.game.Resources.State;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class CultureState extends State {
    private static final int TREE_SPACING = 200;
    private static final int TREE_COUNT = 4;

    private Bird bird;
    private ImageLoader bg;
    private TreeObstacle tree;

    private Array<TreeObstacle> trees;

    public CultureState(GameStateManager gsm) {
        super(gsm);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        bird = new Bird(0,0);
        bg = new ImageLoader("flappyBg",1f);
        tree = new TreeObstacle(1);
        trees = new Array<TreeObstacle>();
        for (int i = 1; i <= TREE_COUNT; i++){
            trees.add(new TreeObstacle(i * (TREE_SPACING + tree.WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        bird.update(deltaTime);
        cam.position.x = bird.getPosition().x + (Gdx.graphics.getWidth()*.0001f);
        for (TreeObstacle tree : trees){
            if ((cam.position.x - (cam.viewportWidth*.5f)) > (tree.getPosTreeTop().x + tree.getTreeTop().width())){
                tree.reposition(tree.getPosTreeTop().x + ((tree.WIDTH + TREE_SPACING))*TREE_COUNT);
            }

            if (tree.collides(bird.getBounds())){
                gsm.set(new CultureState(gsm));
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg.texture(),cam.position.x-(cam.viewportWidth*.5f),0,bg.width()*.5f,bg.height()*.5f);
        sb.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y, bird.bird.width(),bird.bird.height());
        for (TreeObstacle treeObstacle: trees){
            sb.draw(treeObstacle.getTreeTop().texture(),treeObstacle.getPosTreeTop().x,treeObstacle.getPosTreeTop().y,treeObstacle.getTreeTop().width(),treeObstacle.getTreeTop().height());
            sb.draw(treeObstacle.getTreeBottom().texture(),treeObstacle.getPosTreeBottom().x,treeObstacle.getPosTreeBottom().y,treeObstacle.getTreeBottom().width(),treeObstacle.getTreeBottom().height());
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
