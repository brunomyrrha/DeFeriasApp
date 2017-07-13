package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by brunomyrrha on 27/06/2017.
 */

public class Animated extends ApplicationAdapter{

    private static float TIMEFRAME = 0f;
    private TextureRegion textureRegion;
    private TextureAtlas textureAtlas;
    private Animation animation;

    public Animated(String filename, float FRAME_DURATION){
        textureRegion = new TextureRegion();
        textureAtlas = new TextureAtlas(Gdx.files.internal("images/"+filename+".atlas"));
        Array<TextureAtlas.AtlasRegion> arrayAtlas = textureAtlas.findRegions(filename);
        animation = new Animation<TextureRegion>(FRAME_DURATION,arrayAtlas, Animation.PlayMode.LOOP);
    }

    public void draw () {
        TIMEFRAME += Gdx.graphics.getDeltaTime();
        textureRegion = (TextureRegion) animation.getKeyFrame(TIMEFRAME);
    }
    public TextureRegion textureRegion() {
        return textureRegion;
    }
}