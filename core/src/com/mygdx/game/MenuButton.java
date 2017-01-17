package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 07/12/16.
 */

public class MenuButton extends NotAnimated {
    public MenuButton(){
        super(6,6,200*Gdx.graphics.getWidth()/720,50*Gdx.graphics.getHeight()/1280,"skillscreen/menubutton.png");
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }
}
