package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.brunomyrrha.game.Resources.ImageLoader;

import java.util.Random;

/**
 * Created by brunomyrrha on 10/07/2017.
 */

public class TreeObstacle {
    private static final int FLUCTUATION = 100;
    private static final int TREE_GAP = 100;
    private static final int LOWEST_OPENING = 100;

    private ImageLoader treeTop, treeBottom;
    private Vector2 posTreeTop, posTreeBottom;
    private Random rand;

    public TreeObstacle(float x){
        treeTop = new ImageLoader("treeTop",1.5f);
        treeBottom = new ImageLoader("treeBottom",1.5f);
        rand = new Random ();

        posTreeTop = new Vector2(x, rand.nextInt(FLUCTUATION) + TREE_GAP + LOWEST_OPENING);
        posTreeBottom = new Vector2(x, posTreeTop.y - TREE_GAP - treeBottom.getHeight());
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
}
