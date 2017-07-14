package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class WordSelector {
    private String[] words;
    private Array<String> wordBase;
    private FileHandle file;

    public WordSelector(){
        file = Gdx.files.internal("lista.txt");
        wordBase = new Array<String>();
        importData();
    }

    private void importData(){
        String word = file.readString();
        words = word.split(";");
        for (String s : words){
            wordBase.add(s);
        }
    }

    public String chooseWord(){
        return wordBase.random();
    }
}
