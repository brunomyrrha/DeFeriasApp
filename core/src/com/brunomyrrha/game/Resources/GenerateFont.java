package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by brunomyrrha on 10/07/2017.
 */

public class GenerateFont {
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private BitmapFont font;
    private Label label;
    private Label.LabelStyle style;

    private void create(){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Zebrawood.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Math.round(100*(Gdx.graphics.getWidth()*.001f));
        parameter.color = Color.valueOf("#7ac144");
        parameter.borderColor = Color.valueOf("#0e8040");
        parameter.borderWidth = 3f;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public Label getLabel (String text){
        label = new Label(text, style);
        return label;
    }

}
