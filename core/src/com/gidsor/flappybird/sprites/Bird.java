package com.gidsor.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velosity;

    private Texture bird;
    private Animation birdAnimation;

    private Rectangle bounds;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0,0,0);
        bird = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(bird), 3, 0.5f);
        bounds = new Rectangle(x, y, bird.getWidth() / 3, bird.getHeight());
    }

    public void update(float dt) {
        birdAnimation.update(dt);
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

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        bird.dispose();
    }
}
