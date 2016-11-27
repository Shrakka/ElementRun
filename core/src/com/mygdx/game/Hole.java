package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class Hole extends MalusLife {
    private int longueur;

    public Hole(String string, int x, int y, int width, int height, int value, int longueur) {
        super(string, x, y, width, height, value);
        this.longueur = longueur;
    }
}
