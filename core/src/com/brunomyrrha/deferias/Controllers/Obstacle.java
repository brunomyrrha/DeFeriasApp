package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Obstacle {
    private static int VARIATION = 400;
    private static int GAP = 400;
    private static int LOWEST = 100;
    private static Texture treeTop, treeBot;

    private Vector2 positionTop, positionBot;
    private Random rand;

    public Obstacle (float x){
        treeTop = new Texture(Gdx.files.internal("images/treeTop.png"));
        treeBot = new Texture(Gdx.files.internal("images/treeBot.png"));

        rand = new Random();

        positionTop = new Vector2(x, rand.nextInt(VARIATION)+GAP+LOWEST);
        positionBot = new Vector2(x, positionTop.y - GAP - treeTop.getHeight());
    }

    public Texture getTextureTop(){
        return treeTop;
    }

    public Texture getTextureBot(){
        return treeBot;
    }

    public Vector2 getPositionTop() {
        return positionTop;
    }

    public Vector2 getPositionBot() {
        return positionBot;
    }

    public void reposition (float x){
        positionTop.set(x, rand.nextInt(VARIATION)+GAP+LOWEST);
        positionBot.set(x, positionTop.y - GAP - treeTop.getHeight());
    }
}
