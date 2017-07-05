package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by brunomyrrha on 27/06/2017.
 */

public class ImageLoader extends com.badlogic.gdx.scenes.scene2d.ui.Image{

    private static String filename;
    private Texture texture;
    private float SCALE;

    public ImageLoader(String filename, float SCALE){
        this.filename = filename;
        texture = new Texture(Gdx.files.internal("img/"+filename+".png"));
        this.SCALE = SCALE;
    }

    public Texture texture(){
        return texture;
    }

    public float centerScreen (){
        return (Gdx.graphics.getWidth()*.5f)-(((Gdx.graphics.getWidth()*(0.001f)*SCALE)*texture.getWidth())*.5f);
    }
    public float width(){
        return (Gdx.graphics.getWidth()*(0.001f)*SCALE)*texture.getWidth();
    }

    public float height(){
        return (Gdx.graphics.getWidth()*(0.001f)*SCALE)*texture.getHeight();
    }
}
