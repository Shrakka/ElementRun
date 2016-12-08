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
    private ArrayList<Blast> blast;
    private LifeBar lifebar;

    public Alive(String string, int line, int y, int width, int height, int life, int strength, int speed, String element){
        super(string,line,y,width,height);
        this.life = life;
        this.strength = strength;
        this.speed = speed;
        this.element = element;
        this.blast = new ArrayList<Blast>();
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
        this.life = life;
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

    public ArrayList<Blast> getBlast() {
        return this.blast;
    }
}
