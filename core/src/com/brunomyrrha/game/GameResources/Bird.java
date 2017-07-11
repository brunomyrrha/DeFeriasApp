package com.brunomyrrha.game.GameResources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.brunomyrrha.game.Resources.ImageLoader;

/**
 * Created by brunomyrrha on 10/07/2017.
 */

public class Bird {
    public static  float BIRD_HEIGHT;
    private static float SCALE;
    private static final int GRAVITY = -20;
    private int MOVEMENT = 80;
    private float timer = 0;
    private int i = 1;

    private Rectangle playerBound;

    public Vector3 position, velocity;
    public ImageLoader bird;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird.texture();
    }

    public Bird (float x, float y){
        SCALE = Gdx.graphics.getWidth()*.001f;
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bird = new ImageLoader("arara",.5f);
        playerBound = new Rectangle(x, y, bird.width()*.7f,bird.height()*.7f);
        BIRD_HEIGHT = bird.height();
    }

    public void update(float deltatime){
        timer+=Gdx.graphics.getRawDeltaTime();
        if (timer > 15){
            addSpeed();
            timer = 0;
        }
        if ((position.y > 0)||(position.y < (Gdx.graphics.getHeight()*.5f)-bird.height())) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(deltatime);
        position.add(MOVEMENT*deltatime,velocity.y,0);
        position.add(0,velocity.y,0);
        velocity.scl(1/deltatime);
        if (position.y < 0){
            position.y = 0;
        }
        if (position.y > (Gdx.graphics.getHeight()*.5f)-(bird.height())){
            position.y = (Gdx.graphics.getHeight()*.5f)-(bird.height());
        }
        playerBound.setPosition(position.x,position.y);
    }

    public void addSpeed(){
        MOVEMENT = 80*i;
        i++;
    }
    public void jump(){
        velocity.y = 200;
        Gdx.app.log("SPEED:",MOVEMENT+"");
        Gdx.app.log("HEIGHT:",position.y+"");

    }
    public Rectangle getBounds(){
        return playerBound;
    }
}

