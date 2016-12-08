package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Blast extends Animated {
    private String element;

    public Blast(int line, int y, int width, int height, String element){
        super("attack/blast/"+element+"/"+element+".atlas", line, y, width, height);
        this.element = element;
    }

    public void Up(){
        this.setY(this.getY() + 8);
    }

    public void Down(){
        this.setY(this.getY() - 8);
    }

    public int checkCollision(ArrayList<Ennemy> ennemy){
        for (int i = 0; i < ennemy.size(); i++){
            if (this.getBounds().overlaps(ennemy.get(i).getBounds())){
                return i;
            }
        }
        return -1;
    }

    public boolean checkCollision(Character character){
        if (this.getBounds().overlaps(character.getBounds())){
            return true;
        }
        return false;
    }

    public int checkCollisionBlast(Ennemy ennemy){
        for (int i = 0; i < ennemy.getBlast().size(); i++){
            if (this.getBounds().overlaps(ennemy.getBlast().get(i).getBounds())){
                return i;
            }
        }
        return -1;
    }
}
