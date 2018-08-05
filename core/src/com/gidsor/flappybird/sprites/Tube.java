package com.gidsor.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    public static final int TUBE_WIDTH = 52;

    private Texture topTube;
    private Texture bottomTube;

    private Rectangle boundsTop;
    private Rectangle boundsBot;
    private Rectangle boundsMid;

    private Vector2 posTopTube;
    private Vector2 posBotTube;

    private Random random;

    public Tube(float x) {
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        random = new Random();

        posTopTube = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());

        boundsMid = new Rectangle(posTopTube.x + boundsTop.width, posTopTube.y - TUBE_GAP, 0, TUBE_GAP);
    }

    public void reposition(float x) {
        posTopTube = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
        boundsMid.setPosition(posTopTube.x + boundsTop.width, posTopTube.y - TUBE_GAP);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public boolean collidesScore(Rectangle player) {
        return player.overlaps(boundsMid);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();
    }
}
