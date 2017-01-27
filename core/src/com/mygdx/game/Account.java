package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 18/12/16.
 */

public class Account {
    private String user;
    private ArrayList<ArrayList<Integer>> elements;
    private ArrayList<Integer> stock;
    private int nblvl;
    private int cristals;
    private ArrayList<Integer> skills;

    public Account(String user, int nblvl){
        this.user = user;
        this.nblvl = nblvl;
        this.update();
    }

    public void update() {
        ArrayList<ArrayList<Integer>> data = UserConstructor.getUser(user, this.nblvl);
        this.cristals = data.remove(0).get(0);
        this.skills = data.remove(0);
        this.stock = data.remove(0);
        this.elements = data;
    }

    public void getCharacterElements(Character C, int lvl){
        this.elements.get(lvl-1).set(0,C.getStockAir());
        this.elements.get(lvl-1).set(1,C.getStockFire());
        this.elements.get(lvl-1).set(2,C.getStockWater());
    }

    public void addElementsStock(int lvl){
        this.stock.set(0,this.stock.get(0)+this.elements.get(lvl-1).get(0));
        this.stock.set(1,this.stock.get(1)+this.elements.get(lvl-1).get(1));
        this.stock.set(2,this.stock.get(2)+this.elements.get(lvl-1).get(2));
    }

    public ArrayList<ArrayList<Integer>> getElements(){
        return this.elements;
    }

    public String getUser() {
        return this.user;
    }

    public ArrayList<Integer> getStock() {
        return this.stock;

    }

    public ArrayList<Integer> getSkills(){
        return this.skills;
    }

    public int getCristals() {
        return this.cristals;
    }

    public void setElements(ArrayList<ArrayList<Integer>> elements) {
        this.elements = elements;
    }

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < this.elements.size(); i++){
            s += "Niveau "+ (i+1) + " : ";
            for (int j = 0; j < this.elements.get(i).size(); j++){
                s += this.elements.get(i).get(j);
            }
            s += " / ";
        }
        return s;
    }

    public void downAir(){
        this.stock.set(0,this.stock.get(0)-1);
    }
    public void downFire(){
        this.stock.set(1,this.stock.get(1)-1);
    }
    public void downWater(){
        this.stock.set(2,this.stock.get(2)-1);
    }

    public void upLife() {
        this.skills.set(0,this.skills.get(0)+1);
    }
    public void upStrength() {
        this.skills.set(1,this.skills.get(1)+1);
    }
    public void upSpeed() {
        this.skills.set(2,this.skills.get(2)+1);
    }
}
