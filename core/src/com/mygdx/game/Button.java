package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 22/01/17.
 */

public class Button extends NotAnimated {
    public Button(int x, int y, double scale, String string){
        super(x,y,scale*Gdx.graphics.getHeight()/1280,string);
    }

    public Button(String type, int y, String string){
        super(type,y,string);
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }
}
