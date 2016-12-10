package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Ray extends Attack {

    public Ray(int line, int y, int width, int height, String element){
        super("attack/ray/"+element+"/"+element+".atlas", line, y, width, height, element);
    }
}
