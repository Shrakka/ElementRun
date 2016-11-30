package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 30/11/16.
 */

public class Blast extends Displayed {
    private String element;

    public Blast(String string, int x, int y, int width, int height, String element){
        super(string, x, y, width, height);
        this.element = element;
    }

    public void Up(){
        this.setY(this.getY() + 8);
    }

    public void checkCollision(ArrayList<Displayed> other){
        for (int i = 0; i < other.size(); i++){
            if (this.getX() == other.get(i).getX() && this.getY() + this.getHeight() > other.get(i).getY() && this.getY() < other.get(i).getY() + other.get(i).getHeight()){
                System.out.println("collisiontir");
            }
        }
    }
}
