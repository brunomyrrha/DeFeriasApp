package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.brunomyrrha.game.Resources.ImageLoader;

/**
 * Created by brunomyrrha on 10/07/2017.
 */

public class Bird {
    private static final int GRAVITY = -45;
    public Vector3 position, velocity;
    public ImageLoader bird;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird.texture();
    }

    public Bird (float x, float y){

        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bird = new ImageLoader("arara",1f);
    }

    public void update(float deltatime){
        if ((position.y > 0)||(position.y < Gdx.graphics.getHeight()-bird.height())) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(deltatime);
        position.add(0,velocity.y,0);
        velocity.scl(1/deltatime);
        if (position.y < 0){
            position.y = 0;
        }
        if (position.y > Gdx.graphics.getHeight()-bird.height()){
            position.y = Gdx.graphics.getHeight()-bird.height();
        }
    }

    public void jump(){
        velocity.y = 750+(Gdx.graphics.getWidth()*.01f);
    }
}

