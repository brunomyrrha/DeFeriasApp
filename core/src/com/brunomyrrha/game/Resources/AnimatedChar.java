package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

/**
 * Created by brunomyrrha on 27/06/2017.
 */

public class AnimatedChar extends ApplicationAdapter{

    private float TIMEFRAME = 0f;

    private static String filename;
    private Texture texture;
    private TextureRegion textureRegion;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float SCALE;

    public AnimatedChar(String filename, float FRAME_DURATION, float SCALE){
        this.filename = filename;
        texture = new Texture(filename+".png");
        textureRegion = new TextureRegion();
        textureAtlas = new TextureAtlas(Gdx.files.internal(filename+".atlas"));
        Array<TextureAtlas.AtlasRegion> arrayAtlas = textureAtlas.findRegions(filename);
        animation = new Animation<TextureRegion>(FRAME_DURATION,arrayAtlas, Animation.PlayMode.LOOP);
        this.SCALE = SCALE;
    }

    public void draw () {
        TIMEFRAME += Gdx.graphics.getDeltaTime();
        textureRegion = (TextureRegion) animation.getKeyFrame(TIMEFRAME);
    }
    public TextureRegion textureRegion(){
        return textureRegion;
    }
    public float centerScreen (){
        return (Gdx.graphics.getWidth()*.5f)-(((Gdx.graphics.getWidth()*(0.001f)*SCALE)*textureRegion.getRegionWidth())*.5f);
    }
    public float width(){
        return (Gdx.graphics.getWidth()*(0.001f)*SCALE)*textureRegion.getRegionWidth();
    }

    public float height(){
        return (Gdx.graphics.getWidth()*(0.001f)*SCALE)*textureRegion.getRegionHeight();
    }
}
