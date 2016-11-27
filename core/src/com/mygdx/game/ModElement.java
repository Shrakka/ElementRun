package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class ModElement extends Unanimated {
    private String element;

    public ModElement(String string, int x, int y, int width, int height, String element) {
        super(string, x, y, width, height);
        this.element = element;
    }
}
