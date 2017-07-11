package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.brunomyrrha.game.Resources.ImageLoader;

import java.util.Random;

/**
 * Created by brunomyrrha on 10/07/2017.
 */

public class TreeObstacle {
    private static int FLUCTUATION = 700;
    private static int TREE_GAP;
    private static int LOWEST_OPENING = 20;
    public static int WIDTH = 50;
    public static float SCALE = 0;

    private Rectangle boundsTop, boundsBottom;

    private ImageLoader treeTop, treeBottom;
    private Vector2 posTreeTop, posTreeBottom;
    private Random rand;

    public TreeObstacle(float x){
        SCALE = Gdx.graphics.getWidth()*.0001f;
        TREE_GAP = Math.round(Bird.BIRD_HEIGHT*2f);
        treeTop = new ImageLoader("treeTop",.5f);
        treeBottom = new ImageLoader("treeBottom",.5f);
        rand = new Random ();

        posTreeTop = new Vector2(x, rand.nextInt(FLUCTUATION)+TREE_GAP+LOWEST_OPENING);
        posTreeBottom = new Vector2(x, posTreeTop.y - TREE_GAP - treeBottom.height());

        boundsTop = new Rectangle(posTreeTop.x, posTreeTop.y, treeTop.getWidth()*.9f, treeTop.height()*.9f);
        boundsBottom = new Rectangle(posTreeBottom.x,posTreeBottom.y,treeBottom.getWidth(),treeBottom.height());
    }

    public ImageLoader getTreeTop() {
        return treeTop;
    }

    public ImageLoader getTreeBottom() {
        return treeBottom;
    }

    public Vector2 getPosTreeTop() {
        return posTreeTop;
    }

    public Vector2 getPosTreeBottom() {
        return posTreeBottom;
    }

    public void reposition(float x){
        posTreeTop.set(x, rand.nextInt(FLUCTUATION)+TREE_GAP+LOWEST_OPENING);
        posTreeBottom.set(x, posTreeTop.y - TREE_GAP - treeBottom.height());
        boundsTop.setPosition(posTreeTop.x,posTreeTop.y);
        boundsBottom.setPosition(posTreeBottom.x,posTreeBottom.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsBottom) || player.overlaps(boundsTop);
    }
}
