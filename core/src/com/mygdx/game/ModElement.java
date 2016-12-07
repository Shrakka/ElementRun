package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class ModElement extends NotAlive {
    private String element;

    public ModElement(int x, int y, int width, int height, String element) {
        super("character/"+element+"/"+element+".atlas", x, y, width, height);
        this.element = element;
    }

    public String getElement(){
        return this.element;
    }
}
