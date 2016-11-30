package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alexis on 27/11/16.
 */

public class Character extends Animated {
    private int stockWater;
    private int stockFire;
    private int stockAir;

    public Character(String string, int x, int y, int width, int height, int life, int strength, int speed, String element){
        super(string, x, y, width, height, life, strength, speed, element);
        this.stockWater = 0;
        this.stockFire = 0;
        this.stockAir = 0;
    }

    public int getStockWater() {
        return this.stockWater;
    }

    public void setStockWater(int stockWater) {
        this.stockWater = stockWater;
    }

    public int getStockFire() {
        return this.stockFire;
    }

    public void setStockFire(int stockFire) {
        this.stockFire = stockFire;
    }

    public int getStockAir() {
        return this.stockAir;
    }

    public void setStockAir(int stockAir) {
        this.stockAir = stockAir;
    }

    public void Left(){
        this.setX(this.getX() - 1);
    }

    public void Right(){
        this.setX(this.getX() + 1);
    }

    public void Up(){
        this.setY(this.getY() + 1);
    }

    public void addElement(String element){
        if (element == "water") {
            this.setStockWater(this.getStockWater() + 1);
        }
        if (element == "fire") {
            this.setStockFire(this.getStockFire() + 1);
        }
        if (element == "air") {
            this.setStockAir(this.getStockAir() + 1);
        }
    }

    public void checkCollision(ArrayList<Displayed> otherThanCharacter){
        for (int i = 0; i < otherThanCharacter.size(); i++){
            if (this.getX() == otherThanCharacter.get(i).getX() && this.getY() + this.getHeight() > otherThanCharacter.get(i).getY() && this.getY() < otherThanCharacter.get(i).getY() + otherThanCharacter.get(i).getHeight()){
                System.out.println("collision");
            }
        }
    }

    public void changeElement(String element){
        this.setElement(element);
        this.addElement(element);
    }
}
