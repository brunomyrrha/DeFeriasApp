package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.brunomyrrha.deferias.Views.Menu;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Bird {
    private static int GRAVITY = -25;
    public static int MOVEMENT = 5500; //CORRECT = 150 //TEST = 1500
    private int speed;
    private Texture bird;
    private Vector2 position, velocity;


    public Bird (){
        bird = new Texture(Gdx.files.internal("images/parrot.png"));
        position = new Vector2(0,Menu.HEIGHT/2);
        velocity = new Vector2(0,0);
        speed = 1;
    }

    public void update(float deltaTime){
        if ((position.y > 0) || (position.y < Menu.HEIGHT-bird.getHeight())){
            velocity.add(0,GRAVITY);
        }
        velocity.scl(deltaTime);
        position.add((MOVEMENT*speed)*deltaTime,velocity.y);
        position.add(0,velocity.y);
        velocity.scl(1/deltaTime);

        if (position.y < 0){
            position.y = 0;
        }
        if (position.y > Menu.HEIGHT-bird.getHeight()){
            position.y = Menu.HEIGHT-bird.getHeight();
        }
    }

    public void jump(){
        velocity.y = 400;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Texture getTexture(){
        return bird;
    }
}
