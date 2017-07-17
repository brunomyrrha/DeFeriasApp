package com.brunomyrrha.deferias.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.brunomyrrha.deferias.Views.Menu;

/**
 * Created by brunomyrrha on 14/07/2017.
 */

public class Bird {
    private static int GRAVITY = -25;
    public  int movement = 550; //CORRECT = 150
    private int speed;
    float time;
    private Texture bird;
    private Vector2 position, velocity;
    private Rectangle hitBox;


    public Bird (){
        bird = new Texture(Gdx.files.internal("images/parrot.png"));
        position = new Vector2(0,Menu.HEIGHT/2);
        velocity = new Vector2(0,0);
        speed = 1;
        hitBox = new Rectangle(bird.getWidth()/3,bird.getHeight()/4,bird.getWidth()/2,bird.getHeight()/2);
    }

    public void update(float deltaTime){
        if ((position.y > 0) || (position.y < Menu.HEIGHT-bird.getHeight())){
            velocity.add(0,GRAVITY);
        }
        velocity.scl(deltaTime);
        position.add((movement*speed)*deltaTime,velocity.y);
        position.add(0,velocity.y);
        velocity.scl(1/deltaTime);

        if (position.y < 0){
            position.y = 0;
        }
        if (position.y > Menu.HEIGHT-bird.getHeight()){
            position.y = Menu.HEIGHT-bird.getHeight();
        }
        hitBox.setPosition(position.x+bird.getWidth()/3,position.y+bird.getHeight()/4);
    }

    public void jump(){
        velocity.y = 300;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Texture getTexture(){
        return bird;
    }

    public Rectangle getHitBox(){
        return hitBox;
    }

    public void setMovement(){
        time += Gdx.graphics.getRawDeltaTime();
        if (Math.round(time) % 10 == 0){
            movement++;
        }
    }
}
