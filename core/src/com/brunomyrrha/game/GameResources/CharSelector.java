package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by brunomyrrha on 04/07/2017.
 */

public class CharSelector {
    private TextureAtlas buttonAtlas, buttonClickedAtlas;
    private TextureRegion buttonRegion, buttonClickedRegion;
    private Image clicked, notClicked;


    public CharSelector (String letter){
        buttonAtlas = new TextureAtlas(Gdx.files.internal("letras.atlas"));
        buttonRegion = buttonAtlas.findRegion(letter);
        notClicked = new Image(buttonRegion);
//        buttonClicked = new TextureAtlas(Gdx.files.internal("letrasClicadas.atlas"));
//        buttonRegion = button.findRegion(letter);
//        buttonClickedRegion = buttonClicked.findRegion(letter);
//        clicked = new Image(buttonClickedRegion);
//        notClicked = new Image(buttonRegion);
    }

    public Image letter() {
        return notClicked;
        }
}

