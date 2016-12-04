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

    public Character(int line, int y, int width, int height, int life, int strength, int speed, String element){
        super("character/"+element+"/"+element+".atlas", line, y, width, height, life, strength, speed, element);
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
        this.setLine(this.getLine() - 1);
        this.setX(this.computeX());
    }

    public void Right(){
        this.setLine(this.getLine() + 1);
        this.setX(this.computeX());
    }

    public void Up(){
        this.setY(this.getY() + 1);
        for (int i = 0; i < this.getBlast().size(); i++){
            this.getBlast().get(i).Up();
        }
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

    public void checkCollisionEnnemy(ArrayList<Ennemy> ennemy){
        if (ennemy.size() > 0) {
            for (int i = 0; i < ennemy.size(); i++) {
                if (this.getBounds().overlaps(ennemy.get(i).getBounds())) {
                }
            }
        }
    }

    public void checkCollisionModElement(ArrayList<ModElement> modelement){
        if (modelement.size() > 0) {
            for (int i = 0; i < modelement.size(); i++) {
                if (this.getBounds().overlaps(modelement.get(i).getBounds())) {
                    this.changeElement(modelement.get(i).getElement());
                    modelement.remove(i);
                }
            }
        }
    }


    public void checkCollisionBlastEnnemy(ArrayList<Ennemy> ennemy, ArrayList<ModElement> modelement){
        int i = 0;
        int j = 0;
        while(i < this.getBlast().size()) {
            j = this.getBlast().get(i).checkCollision(ennemy);
            if (j >= 0){
                this.getBlast().remove(i);
                ennemy.get(j).setLife(ennemy.get(j).getLife() - 10);
                if (ennemy.get(j).getLife() <= 0){
                    modelement.add(new ModElement(ennemy.get(j).getLine(), (int)ennemy.get(j).getY(), 64, 64, ennemy.get(j).getElement()));
                    ennemy.remove(j);
                }
            }
            i++;
        }
    }

    public void changeElement(String element){
        this.setElement(element);
        this.addElement(element);
        this.setAnimation("character/"+element+"/"+element+".atlas");
    }
}
