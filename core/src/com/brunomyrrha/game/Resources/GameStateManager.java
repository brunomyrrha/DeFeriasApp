package com.brunomyrrha.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Stack;

/**
 * Created by brunomyrrha on 30/06/2017.
 */

public class GameStateManager  {
    private Stack<State> states;

    public GameStateManager (){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.peek().dispose();
        states.pop();

    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float deltaTime){
        states.peek().update(deltaTime);
    }

    public void render (SpriteBatch sb){
        states.peek().render(sb);
    }
}
