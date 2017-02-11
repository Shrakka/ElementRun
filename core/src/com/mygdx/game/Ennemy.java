package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Ennemy extends Alive {
    private String type;
    private boolean visible;
    private boolean on;

    public Ennemy(int line, int y, int life, int strength, String type, String element){
        super("ennemy/"+element+"/"+element+".atlas", line, y, life, strength, element);
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
        if (this.getType().equals("blast")) {
            while (i < this.getAttack().size()) {
                if (this.getAttack().get(i).checkCollision(character)) {
                    this.getAttack().remove(i);
                    int coeff = TriangleElement.get(this, character);
                    character.setLife((int) (character.getLife() - this.getStrength() * (1 + 0.5 * coeff)));
                }
                i++;
            }
        }
        else if (this.getType().equals("ray")) {
            while (i < this.getAttack().size()) {
                if (this.getAttack().get(i).checkCollision(character)) {
                    int coeff = TriangleElement.get(this, character);
                    character.setLife((int) (character.getLife() - this.getStrength() * (1 + 0.5 * coeff)));
                }
                i++;
            }
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
                this.getAttack().add(new Blast(this.getLine(), (int)this.getY(), this.getElement()));
            }
            if (this.getType().equals("ray")) {
                this.getAttack().add(new Ray(this.getLine(), (int)this.getY(), this.getElement()));
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
