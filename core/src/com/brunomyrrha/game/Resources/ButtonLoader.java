package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by brunomyrrha on 01/07/17.
 */

public class ButtonLoader extends ImageButton {
    private ImageLoader imageUp, imageDown;

    public ButtonLoader(Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
    }

    public ButtonLoader (ImageLoader imageUp,ImageLoader imageDown){
        super (new SpriteDrawable(new Sprite(imageUp.texture())), new SpriteDrawable(new Sprite(imageDown.texture())));
        this.imageUp = imageUp;
        this.imageDown = imageDown;
    }
    public Texture texture(){
        return imageUp.texture();
    }

    public float centerScreen (){
        return imageUp.centerScreen();
    }
}
