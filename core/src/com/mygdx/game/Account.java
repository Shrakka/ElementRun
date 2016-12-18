package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by alexis on 18/12/16.
 */

public class Account {
    private String user;
    private ArrayList<ArrayList<Integer>> elements;

    public Account(String user, int nblvl){
        this.user = user;
        this.elements = UserConstructor.getUser(user, nblvl);
    }

    public ArrayList<ArrayList<Integer>> getElements(){
        return this.elements;
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
