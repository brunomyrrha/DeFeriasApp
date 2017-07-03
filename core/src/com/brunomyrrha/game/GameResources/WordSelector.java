package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import java.util.Random;

/**
 * Created by brunomyrrha on 03/07/2017.
 */

public class WordSelector {
    private String words[];
    private Array<String> wordbase;
    private FileHandle file;
    private Random rand;

    public WordSelector(){
        file = Gdx.files.internal("lista.txt");
        wordbase = new Array<String>();
        rand = new Random ();
        Table table = new Table();
        importData();
    }

    public void importData() {
        String word = file.readString();
        words = word.split(";");
        for(String item : words){
            item.trim();
            wordbase.add(item);
        }
    }

    public String sortWord() {
        return wordbase.random();
    }

}
