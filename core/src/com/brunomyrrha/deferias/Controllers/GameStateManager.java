package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by brunomyrrha on 12/07/17.
 */

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void update(float deltaTime){
        states.peek().update(deltaTime);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
