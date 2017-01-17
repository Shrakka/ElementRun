package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserConstructor {

    public static ArrayList<ArrayList<Integer>> getUser(String user, int nblvl) {
        ArrayList<ArrayList<Integer>> elements = new ArrayList<ArrayList<Integer>>();
        try {
            FileHandle file = Gdx.files.local("smartgame/users/"+user+".txt");
            BufferedReader userreader = new BufferedReader(file.reader());
            ArrayList<Integer> criskill = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++){
                criskill.add(Integer.parseInt(userreader.readLine()));
            }
            elements.add(criskill);
            ArrayList<Integer> stock = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++){
                stock.add(Integer.parseInt(userreader.readLine()));
            }
            elements.add(stock);
            userreader.readLine();
            do {
                ArrayList<Integer> lvl = new ArrayList<Integer>();
                for (int i = 0; i < 3; i++){
                    lvl.add(Integer.parseInt(userreader.readLine()));
                }
                elements.add(lvl);
            } while (userreader.readLine() != null);
            userreader.close();
        }
        catch (Exception e){
            ArrayList<Integer> criskill = new ArrayList<Integer>();
            criskill.add(0);
            criskill.add(100);
            criskill.add(10);
            criskill.add(1);
            elements.add(criskill);
            ArrayList<Integer> stock = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++){
                stock.add(0);
            }
            elements.add(stock);
            FileHandle file = Gdx.files.local("smartgame/users/"+user+".txt");
            file.writeString("0\n"+"100\n"+"1\n"+"10\n"+"0\n"+"0\n"+"0\n", true);
            for (int i = 1; i <= nblvl; i++){
                file.writeString(i+"\n", true);
                file.writeString("0\n"+"0\n"+"0\n", true);
                ArrayList<Integer> lvl = new ArrayList<Integer>();
                for (int j = 0; j < 3; j++){
                    lvl.add(0);
                }
                elements.add(lvl);
            }
        }
        return elements;
    }

    public static void setUser(String user, ArrayList<Integer> criskill, ArrayList<ArrayList<Integer>> elements, ArrayList<Integer> stock) {
        try {
            FileHandle file = Gdx.files.local("smartgame/users/"+user+".txt");
            FileHandle filetmp = Gdx.files.local("smartgame/users/"+user+"tmp.txt");
            filetmp.writeString(criskill.get(0)+"\n"+criskill.get(1)+"\n"+criskill.get(2)+"\n"+criskill.get(3)+"\n",true);
            filetmp.writeString(stock.get(0)+"\n"+stock.get(1)+"\n"+stock.get(2)+"\n",true);
            for (int i = 0; i < elements.size(); i++){
                filetmp.writeString(i+1+"\n",true);
                for (int j = 0; j < elements.get(i).size(); j++){
                    filetmp.writeString(elements.get(i).get(j)+"\n",true);
                }
            }
            Gdx.files.local("smartgame/users/"+user+".txt").delete();
            filetmp.copyTo(Gdx.files.local("smartgame/users/"+user+".txt"));
            Gdx.files.local("smartgame/users/"+user+"tmp.txt").delete();
        }
        catch (Exception e){
            System.out.println("Problème d'écriture");
        }
    }
}
