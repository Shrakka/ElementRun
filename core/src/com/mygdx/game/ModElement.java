package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 27/11/16.
 */

public class ModElement extends NotAlive {
    private String element;

    public ModElement(int line, int ye, int we, String element) {
        super("character/"+element+"/"+element+".atlas", line, ye+(we-(int)(0.4* Gdx.graphics.getWidth()/3))/2,(int)(0.4* Gdx.graphics.getWidth()/3), (int)(0.4* Gdx.graphics.getWidth()/3));
        this.element = element;
    }

    public String getElement(){
        return this.element;
    }
}
