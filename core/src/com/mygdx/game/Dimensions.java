package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 22/01/17.
 */

public class Dimensions {
    static public int Width(int pc){
        return (int)(Gdx.graphics.getWidth()*pc/100);
    }
    static public int Height(int pc){
        return (int)(Gdx.graphics.getHeight()*pc/100);
    }
    static public int CenterX(int width){
        return (int)((Gdx.graphics.getWidth()-width)/2);
    }
    static public int CenterY(int height){
        return (int)((Gdx.graphics.getHeight()-height)/2);
    }
}
