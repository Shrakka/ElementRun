package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 07/12/16.
 */

public class StartButton extends NotAnimated {
    public StartButton(){
        super((Gdx.graphics.getWidth()-400*Gdx.graphics.getWidth()/720)/2,(Gdx.graphics.getHeight()-100*Gdx.graphics.getHeight()/1280)/2,400*Gdx.graphics.getWidth()/720,100*Gdx.graphics.getHeight()/1280,"menu/startbutton.jpg");
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }
}
