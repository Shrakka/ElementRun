package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 27/11/16.
 */

public class Hole extends MalusLife {
    private int longueur;

    public Hole(int longueur, int x, int y, int value) {
        super("malus/hole.atlas", x, y, (int)(0.8* Gdx.graphics.getWidth()/3), (int)(0.8* Gdx.graphics.getWidth()/3), value);
        this.longueur = longueur;
    }
}
