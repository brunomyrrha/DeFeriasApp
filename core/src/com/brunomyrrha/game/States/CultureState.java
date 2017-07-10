package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brunomyrrha.game.GameResources.Bird;
import com.brunomyrrha.game.GameResources.TreeObstacle;
import com.brunomyrrha.game.Resources.GameStateManager;
import com.brunomyrrha.game.Resources.ImageLoader;
import com.brunomyrrha.game.Resources.State;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class CultureState extends State {
    private Bird bird;
    private ImageLoader bg;
    private TreeObstacle tree;

    public CultureState(GameStateManager gsm) {
        super(gsm);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        cam.setToOrtho(false,72,350);
        bird = new Bird(Gdx.graphics.getWidth()*.1f, Gdx.graphics.getHeight()*.5f);
        bg = new ImageLoader("flappyBg",1f);
        tree = new TreeObstacle(1);
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
        Gdx.app.log("POSITION","X:"+bird.getPosition().x+" Y:"+bird.getPosition().y);
        bird.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(bg.texture(),0,0,bg.width(),bg.height());
        sb.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y, bird.bird.width(),bird.bird.height());
        sb.draw(tree.getTreeTop().texture(),tree.getPosTreeTop().x,tree.getPosTreeTop().y,tree.getTreeTop().width(),tree.getTreeTop().height());
        sb.draw(tree.getTreeBottom().texture(),tree.getPosTreeBottom().x,tree.getPosTreeBottom().y,tree.getTreeBottom().width(),tree.getTreeBottom().height());
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
