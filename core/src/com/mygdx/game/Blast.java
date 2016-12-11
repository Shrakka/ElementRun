package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Blast extends Attack {

    public Blast(int line, int y, String element){
        super("attack/blast/"+element+"/"+element+".atlas", line, y, (int)(0.2* Gdx.graphics.getWidth()/3), (int)(0.2* Gdx.graphics.getWidth()/3), element);
    }
}
