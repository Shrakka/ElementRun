package com.mygdx.game;

/**
 * Created by alexis on 27/11/16.
 */

public class Ennemy extends Alive {
    public Ennemy(int line, int y, int width, int height, int life, int strength, int speed, String element){
        super("ennemy/"+element+"/"+element+".atlas", line, y, width, height, life, strength, speed, element);
    }
}
