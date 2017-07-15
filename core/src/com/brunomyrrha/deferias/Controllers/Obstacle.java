package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Obstacle {
    private static int VARIATION = 700;
    private static int GAP = 300;
    private static int LOWEST = 50;
    private static Texture treeTop, treeBot;

    private Rectangle hitBoxTop, hitBoxBot, points;
    private Vector2 positionTop, positionBot;
    private Random rand;

    public Obstacle (float x){
        treeTop = new Texture(Gdx.files.internal("images/treeTop.png"));
        treeBot = new Texture(Gdx.files.internal("images/treeBot.png"));
        rand = new Random();
        positionTop = new Vector2(x, rand.nextInt(VARIATION)+GAP+LOWEST);
        positionBot = new Vector2(x, positionTop.y - GAP - treeTop.getHeight());
        hitBoxTop = new Rectangle(getPositionTop().x,getPositionTop().y,treeTop.getWidth(),treeTop.getHeight());
        hitBoxBot = new Rectangle(getPositionTop().x,getPositionBot().y,treeBot.getWidth(), treeBot.getHeight());
        points = new Rectangle(getPositionBot().x+treeBot.getWidth(),positionBot.y + treeBot.getHeight(),1,GAP);
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
        hitBoxBot.setPosition(x,positionBot.y);
        hitBoxTop.setPosition(x,positionTop.y);
        points.setPosition(x+treeBot.getWidth(),positionBot.y + treeBot.getHeight());
    }

    public Boolean collides (Rectangle player) {
        return player.overlaps(hitBoxBot) || player.overlaps(hitBoxTop);
    }

    public Boolean collect (Rectangle player){
        return player.overlaps(points);
    }
}
