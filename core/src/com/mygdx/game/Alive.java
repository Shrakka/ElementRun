package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Alive extends Animated {
    private int maxlife;
    private int life;
    private int strength;
    private String element;
    private ArrayList<Attack> attack;
    private LifeBar lifebar;

    public Alive(String string, int line, int y, int life, int strength, String element){
        super(string,line,y,(int)(0.8* Gdx.graphics.getWidth()/3),(int)(0.8*Gdx.graphics.getWidth()/3));
        this.life = life;
        this.maxlife = life;
        this.strength = strength;
        this.element = element;
        this.attack = new ArrayList<Attack>();
        this.lifebar = new LifeBar((int)this.getX(), (int)this.getY());
    }
    public int getMaxlife() {
        return this.maxlife;
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


    public void setElement(String element) {
        this.element = element;
    }

    public ArrayList<Attack> getAttack() {
        return this.attack;
    }
}
