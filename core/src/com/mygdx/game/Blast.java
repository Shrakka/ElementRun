package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Blast extends Attack {

    public Blast(int line, int persoy, String element){
        super("attack/blast/"+element+"/"+element+".atlas", line, 0, 0.08, element);
        this.setY(persoy - this.getHeight());
    }
}
