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
    private ArrayList<Integer> costs;

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
        this.costs = new ArrayList<Integer>();
    }

    public void computeCosts(){
        if (this.costs.size() == 0){
            this.costs.add(0,this.skills.get(0)-99);
            this.costs.add(1,this.skills.get(1)-9);
            this.costs.add(2,this.skills.get(2)-9);
        }
        else {
            this.costs.set(0,this.skills.get(0)-99);
            this.costs.set(1,this.skills.get(1)-9);
            this.costs.set(2,this.skills.get(2)-9);
        }
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

    public ArrayList<Integer> getCosts(){
        return this.costs;
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
        if (this.stock.get(0) >= this.costs.get(0)){
            this.stock.set(0,this.stock.get(0)-this.costs.get(0));
            this.skills.set(0,this.skills.get(0)+5);
            this.computeCosts();
        }
    }
    public void downFire(){
        if (this.stock.get(1) >= this.costs.get(1)) {
            this.stock.set(1, this.stock.get(1) - this.costs.get(1));
            this.skills.set(1, this.skills.get(1) + 1);
            this.computeCosts();
        }
    }
    public void downWater(){
        if (this.stock.get(2) >= this.costs.get(2)) {
            this.stock.set(2, this.stock.get(2) - this.costs.get(2));
            this.skills.set(2, this.skills.get(2) + 1);
            this.computeCosts();
        }
    }
}
