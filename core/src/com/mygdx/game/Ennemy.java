package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Ennemy extends Alive {
    private String type;
    private boolean visible;
    private boolean on;

    public Ennemy(int line, int y, int width, int height, int life, int strength, int speed, String type, String element/*, String type*/){
        super("ennemy/"+element+"/"+element+".atlas", line, y, width, height, life, strength, speed, element);
        this.type = type;
        this.visible = false;
        this.on = false;
    }

    public void toggleOn(){
        this.on = !this.on;
    }

    public boolean getOn(){
        return this.on;
    }

    public String getType(){
        return this.type;
    }

    public void checkCollisionBlastEnnemy(Character character){
        int i = 0;
        while(i < this.getAttack().size()){
            if (this.getAttack().get(i).checkCollision(character)){
                this.getAttack().remove(i);
                character.setLife(character.getLife() - this.getStrength());
            }
            i++;
        }
    }

    public boolean checkDeath(){
        if (this.getLife() <= 0){
            return true;
        }
        return false;
    }

    public void shoot() {
        this.toggleOn();
        if (this.getOn()) {
            if (this.getType().equals("blast")) {
                this.getAttack().add(new Blast(this.getLine(), (int) (this.getY()) - 24, 24, 24, this.getElement()));
            }
            if (this.getType().equals("ray")) {
                this.getAttack().add(new Ray(this.getLine(), (int) (this.getY()) - 5 * 24, 24, 5 * 24, this.getElement()));
            }
        } else {
            if (this.getAttack().size() > 0 && this.getType().equals("ray")) {
                this.getAttack().remove(0);
            }
        }
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
