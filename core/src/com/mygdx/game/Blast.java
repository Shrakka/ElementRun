package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Blast extends Attack {

    public Blast(int line, int y, int width, int height, String element){
        super("attack/blast/"+element+"/"+element+".atlas", line, y, width, height, element);
    }
}
