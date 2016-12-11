package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 11/12/16.
 */

public class Level {
    private ArrayList<Ennemy> ennemy;
    private ArrayList<Hole> hole;

    public Level(ArrayList<Ennemy> ennemy, ArrayList<Hole> hole){
        this.ennemy = ennemy;
        this.hole = hole;
    }

    public ArrayList<Hole> getHole() {
        return this.hole;
    }

    public ArrayList<Ennemy> getEnnemy() {
        return this.ennemy;
    }
}
