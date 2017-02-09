package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 27/11/16.
 */

public class ModElement extends NotAlive {
    private String element;

    public ModElement(int line, int y, String element) {
        super("gemmes/"+element+"/"+element+".atlas", line, y, 0.15);
        this.element = element;
    }

    public String getElement(){
        return this.element;
    }
}
