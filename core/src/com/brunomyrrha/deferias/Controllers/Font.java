package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.brunomyrrha.deferias.DeFerias;
import com.brunomyrrha.deferias.Views.Menu;

/**
 * Created by brunomyrrha on 12/07/17.
 */

public class Font {
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private BitmapFont font;
    private Label label;
    private Label.LabelStyle style;

    public Font (){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Zebrawood.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Math.round((Menu.WIDTH)*.1f);
        parameter.color = Color.valueOf("#7ac144");
        parameter.borderColor = Color.valueOf("#0e8040");
        parameter.borderWidth = 4;
        font = generator.generateFont(parameter);
        style = new Label.LabelStyle();
        style.font = font;
        generator.dispose();
    }

    public Font (int size){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Zebrawood.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = Color.valueOf("#7ac144");
        parameter.borderColor = Color.valueOf("#0e8040");
        parameter.borderWidth = 4;
        font = generator.generateFont(parameter);
        style = new Label.LabelStyle();
        style.font = font;
        generator.dispose();
    }

    public Label getLabel(String text){
        return label = new Label(text, style);
    }
}
