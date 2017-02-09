package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

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
    static public BitmapFont Font(){
        if (Gdx.graphics.getWidth() <= 480){
            return new BitmapFont(Gdx.files.internal("font/cantarellSD.fnt"));
        }
        else if (Gdx.graphics.getWidth() <= 720){
            return new BitmapFont(Gdx.files.internal("font/cantarellHD.fnt"));
        }
        else {
            return new BitmapFont(Gdx.files.internal("font/cantarellFHD.fnt"));
        }
    }
}
