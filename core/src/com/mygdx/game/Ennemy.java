package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Ennemy extends Alive {
    //private String type;
    private boolean visible;

    public Ennemy(int line, int y, int width, int height, int life, int strength, int speed, String element/*, String type*/){
        super("ennemy/"+element+"/"+element+".atlas", line, y, width, height, life, strength, speed, element);
        //this.type = type;
        this.visible = false;
    }

    public void checkCollisionBlastEnnemy(Character character){
        int i = 0;
        while(i < this.getBlast().size()){
            if (this.getBlast().get(i).checkCollision(character)){
                this.getBlast().remove(i);
                character.setLife(character.getLife() - 10);
                if (character.getLife() <= 0){
                    System.out.println("You're dead !");
                }
            }
            i++;
        }
    }

    public void shootBlast () {
        this.getBlast().add(new Blast(this.getLine(),(int)(this.getY()),24,24,this.getElement()));
    }

    public void updateVisible(int y){
        if (this.getY() < y){
            this.visible = true;
        }
        else {
            this.visible = false;
        }
    }

    public boolean getVisible(){
        return this.visible;
    }
}
