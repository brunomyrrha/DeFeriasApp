package com.brunomyrrha.game.States;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunomyrrha.game.GameResources.WordSelector;
import com.brunomyrrha.game.Resources.ImageLoader;

import java.util.Random;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class EducationState extends State {
    private Viewport viewport;
    private SpriteBatch batch;

    private Stage stage;
    private Skin skin;

    private WordSelector wordSelector;
    private String word;
    private BitmapFont font48;

    private TextButton teste;

    private ImageButton playStone;
    private ImageButton.ImageButtonStyle playStoneStyle;

    private ImageLoader bg;


    public EducationState(GameStateManager gsm){
        super(gsm);
        //Enabling debug
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        //Creating viewports
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch = new SpriteBatch();

        stage = new Stage(viewport,batch);
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"),new TextureAtlas("ui/uiskin.atlas"));
        //importing and choosing words
        wordSelector = new WordSelector();
        wordSelector.importData();
        word = wordSelector.sortWord();

        playStoneStyle = new ImageButton.ImageButtonStyle();

        playStoneStyle.imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("img/stoneButton.png")));
        playStoneStyle.imageDown = new TextureRegionDrawable(new TextureRegion(new Texture("img/stoneButtonClicked.png")));
        playStoneStyle.pressedOffsetX = 1;
        playStoneStyle.pressedOffsetY = -1;

        playStone = new ImageButton(playStoneStyle);
        stage.addActor(playStone);

        bg = new ImageLoader("bg_edu",1f);

        initFonts();
        generateMatrix(word);
        Gdx.app.log("Palavra:",word);
        Gdx.input.setInputProcessor(stage);
    }

    public void generateMatrix(final String word) {
        Array <Character> list = new Array<Character>();
        Random rand = new Random();
        String base = "abcdefghijklmnopqrstuvwxyz";
        Character value;

        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        for (int i = word.length(); i < 9; i++){
            value = base.charAt(rand.nextInt(base.length()));

            for (Character c : list){
                while (value == c){
                    value = base.charAt(rand.nextInt(base.length()));
                }
            }
            list.add(value);
        }
        list.shuffle();
        int i = 0;
        for(final Character c: list) {
            if (i > 2){
//                table.row();
                i = 0;
            }

            Gdx.app.log("LOG",c.toString());
            i++;
        }
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        if (word.equals(true)) {
            gsm.pop();
            gsm.push(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void render(Stage stage) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(bg.texture(),0,0,bg.width(),bg.height());
        font48.draw(batch,"Teste",100,100);
        batch.end();
        this.stage.draw();
    }

    @Override
    public void dispose() {
        this.stage.dispose();
        batch.dispose();
        font48.dispose();
    }

    private void initFonts(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Zebrawood.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = 48;
        params.color = Color.GREEN;
        params.shadowColor = Color.BLACK;
        font48 = generator.generateFont(params);
    }
}
