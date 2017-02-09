package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class Malus extends NotAlive {
    private int value;

    public Malus(String string, int x, int y, double s, int value) {
        super(string, x, y, s);
        this.value = value;
    }
}
