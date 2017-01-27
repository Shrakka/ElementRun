package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Ray extends Attack {

    public Ray(int line, int y, String element){
        super("attack/ray/"+element+"/"+element+".atlas", line, y, (int)(0.2* Gdx.graphics.getWidth()/3), Dimensions.Height(100), element);
    }
}
