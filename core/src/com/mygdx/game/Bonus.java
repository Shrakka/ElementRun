package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class Bonus extends NotAlive {
    private int value;

    public Bonus(String string, int x, int y, int width, int height, int value) {
        super(string, x, y, width, height);
        this.value = value;
    }
}
