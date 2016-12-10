package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Alive extends Animated {
    private int life;
    private int strength;
    private int speed;
    private String element;
    private ArrayList<Attack> attack;
    private LifeBar lifebar;

    public Alive(String string, int line, int y, int width, int height, int life, int strength, int speed, String element){
        super(string,line,y,width,height);
        this.life = life;
        this.strength = strength;
        this.speed = speed;
        this.element = element;
        this.attack = new ArrayList<Attack>();
        this.lifebar = new LifeBar(this.computeX(), (int)this.getY(), this.getLife());
    }

    public LifeBar getLifeBar(){
        return this.lifebar;
    }

    public int getLife() {
        return this.life;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getElement() {
        return this.element;
    }

    public void setLife(int life) {
        if (life >= 0){
            this.life = life;
        }
        else{
            this.life = 0;
        }
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public ArrayList<Attack> getAttack() {
        return this.attack;
    }
}
