package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Character extends Alive {
    private int stockWater;
    private int stockFire;
    private int stockAir;
    private StockElement stockelement;

    public Character(int line, int y, int life, int strength, int speed, String element){
        super("character/"+element+"/"+element+".atlas", line, y, life, strength, speed, element);
        this.stockWater = 0;
        this.stockFire = 0;
        this.stockAir = 0;
        this.stockelement = new StockElement(this.getStockAir(),this.getStockFire(),this.getStockWater());
    }

    public StockElement getStockElement(){
        return this.stockelement;
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
        this.setY(this.getY() + Gdx.graphics.getHeight()/480);
    }

    public void addElement(String element){
        if (element.equals("water")) {
            this.setStockWater(this.getStockWater() + 1);
        }
        if (element.equals("fire")) {
            this.setStockFire(this.getStockFire() + 1);
        }
        if (element.equals("air")) {
            this.setStockAir(this.getStockAir() + 1);
        }
    }

    public void checkCollisionEnnemy(ArrayList<Ennemy> ennemy){
        if (ennemy.size() > 0) {
            for (int i = 0; i < ennemy.size(); i++) {
                if (this.getBounds().overlaps(ennemy.get(i).getBounds())) {
                    this.setLife(this.getLife() - 50);
                    ennemy.get(i).setLife(0);
                }
            }
        }
    }

    public void checkCollisionHole(ArrayList<Hole> hole){
        if (hole.size() > 0) {
            for (int i = 0; i < hole.size(); i++) {
                if (this.getBounds().overlaps(hole.get(i).getBounds())) {
                    this.setLife(this.getLife() - 50);
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


    public void checkCollisionAttackEnnemy(ArrayList<Ennemy> ennemy, ArrayList<ModElement> modelement){
        int i = 0;
        int j = 0;
        while(i < this.getAttack().size()) {
            j = this.getAttack().get(i).checkCollision(ennemy);
            if (j >= 0){
                this.getAttack().remove(i);
                ennemy.get(j).setLife(ennemy.get(j).getLife() - this.getStrength());
            }
            i++;
        }
    }

    public void checkCollisionAttackEnnemyAttack(ArrayList<Ennemy> ennemy){
        int i = 0;
        int k;
        while (i < this.getAttack().size()) {
            for (int j = 0; j < ennemy.size(); j++) {
                ennemy.get(j).getAttack();
                k = this.getAttack().get(i).checkCollisionAttack(ennemy.get(j));
                if (k >= 0) {
                    this.getAttack().remove(i);
                    ennemy.get(j).getAttack().remove(k);
                    j += ennemy.size();
                }
            }
            i++;
        }
    }

    public void checkDeath(){
        if (this.getLife() == 0) {
            System.out.println("You're dead");
        }
    }

    public void changeElement(String element){
        this.setElement(element);
        this.addElement(element);
        this.setAnimation("character/"+element+"/"+element+".atlas");
    }
    public void shoot() {
        this.getAttack().add(new Blast(this.getLine(),(int)(this.getY()+this.getHeight()),this.getElement()));
    }

}
