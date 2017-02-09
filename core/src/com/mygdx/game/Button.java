package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 22/01/17.
 */

public class Button extends NotAnimated {
    public Button(int x, int y, double s, String string){
        super(x,y,s,string);
    }

    public Button(String type, int y, double s, String string){
        super(type,y,s,string);
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }
}
