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
    private ArrayList<Integer> criskill;

    public Account(String user, int nblvl){
        this.user = user;
        this.nblvl = nblvl;
        this.update();
    }

    public void update() {
        ArrayList<ArrayList<Integer>> values = UserConstructor.getUser(user, this.nblvl);
        this.criskill = values.remove(0);
        this.stock = values.remove(0);
        this.elements = values;
        System.out.println(criskill.get(0));
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

    public ArrayList<Integer> getCriskill(){
        return this.criskill;
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
}
