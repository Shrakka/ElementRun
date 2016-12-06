package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class Hole extends MalusLife {
    private int longueur;

    public Hole(int longueur, int x, int y, int width, int height, int value) {
        super("malus/hole.atlas", x, y, width, height, value);
        this.longueur = longueur;
    }
}
