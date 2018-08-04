package com.gidsor.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.gidsor.flappybird.FlappyBird;

public class Bird {
    public static final int GRAVITY = -15;
    public static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velosity;

    private Texture bird;

    private Rectangle bounds;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0,0,0);
        bird = new Texture("bird.png");
        bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt) {
        if (position.y > 0) {
            velosity.add(0, GRAVITY, 0);
        }
        velosity.scl(dt);
        position.add(MOVEMENT * dt, velosity.y, 0);

        if (position.y < 0) {
            position.y = 0;
        }

        velosity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        velosity.y = 250;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        bird.dispose();
    }
}
