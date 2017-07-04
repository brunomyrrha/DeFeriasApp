package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.HashMap;

/**
 * Created by brunomyrrha on 04/07/2017.
 */
public class Letter {
    private TextureRegion textureRegion, textureRegionClicked;
    private TextureAtlas atlasClicked, atlasNotClicked;
    private Image image;

    public Letter(){
        atlasNotClicked = new TextureAtlas(Gdx.files.internal("letras.atlas"));
        atlasClicked = new TextureAtlas(Gdx.files.internal("letrasClicadas.atlas"));
    }

    public Image getImage(String s){
        return image = new Image(new TextureRegion(atlasNotClicked.findRegion(s)));
    }

    public Image getClick (String s){
        return image = new Image(new TextureRegion(atlasClicked.findRegion(s)));
    }
}
