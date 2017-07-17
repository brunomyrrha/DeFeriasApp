package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by brunomyrrha on 17/07/2017.
 */

public class LoadManager {
    private AssetManager assetManager;

    public LoadManager(){
        assetManager = new AssetManager();

        //Load all textures
        assetManager.load("images/bg.png", Texture.class);
        assetManager.load("images/bgParrot.png", Texture.class);
        assetManager.load("images/bgSesc.png", Texture.class);
        assetManager.load("images/btnCulture.png", Texture.class);
        assetManager.load("images/btnEducation.png", Texture.class);
        assetManager.load("images/btnOk.png", Texture.class);
        assetManager.load("images/parrot.png", Texture.class);
        assetManager.load("images/sesc.png", Texture.class);
        assetManager.load("images/tipTableTexture.png", Texture.class);
        assetManager.load("images/treeBot.png", Texture.class);
        assetManager.load("images/treeTop.png", Texture.class);
        assetManager.load("images/victory.png", Texture.class);

        //Load Texture Atlas
        assetManager.load("images/lion.atlas", TextureAtlas.class);

        //Load Skins JSON
        assetManager.load("images/stoneButton.json", Skin.class);
    }

    public boolean loading(){
        return assetManager.update();
    }

    public float loadingStatus(){
        return assetManager.getProgress();
    }

    public Texture getTexture(String name){
        return assetManager.get("images/"+name,Texture.class);
    }

    public TextureAtlas getTextureAtlas(String name){
        return assetManager.get("images/"+name,TextureAtlas.class);
    }

    public Skin getSkin(String name){
        return assetManager.get("images/"+name,Skin.class);
    }
}
