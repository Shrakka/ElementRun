package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Animated extends Displayed {
    private int life;
    private int strength;
    private int speed;
    private String element;
    private ArrayList<Blast> blast;

    public Animated(String string, int x, int y, int width, int height, int life, int strength, int speed, String element){
        super(string,x,y,width,height);
        this.life = life;
        this.strength = strength;
        this.speed = speed;
        this.element = element;
        this.blast = new ArrayList<Blast>();
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

    public void shootBlast () {
        this.getBlast().add(new Blast("attack/blast/"+this.getElement()+"/"+this.getElement()+".atlas",(int)(this.getX()),(int)(this.getY()+this.getHeight()),24,24,this.getElement()));
    }
}
