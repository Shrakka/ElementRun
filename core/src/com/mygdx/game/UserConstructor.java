package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import jdk.nashorn.internal.parser.JSONParser;

public class UserConstructor {

    public static ArrayList<ArrayList<Integer>> getUser(String user, int nblvl) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
        try {
            FileHandle file = Gdx.files.local("smartgame/users/"+user+".txt");
            BufferedReader userreader = new BufferedReader(file.reader());
            ArrayList<Integer> cristals = new ArrayList<Integer>();
            cristals.add(Integer.parseInt(userreader.readLine().split(" ")[1]));
            data.add(cristals);
            ArrayList<Integer> skills = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++){
                skills.add(Integer.parseInt(userreader.readLine().split(" ")[1]));
            }
            data.add(skills);
            ArrayList<Integer> stock = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++){
                stock.add(Integer.parseInt(userreader.readLine().split(" ")[1]));
            }
            data.add(stock);
            userreader.readLine();
            do {
                ArrayList<Integer> lvl = new ArrayList<Integer>();
                for (int i = 0; i < 3; i++){
                    lvl.add(Integer.parseInt(userreader.readLine()));
                }
                data.add(lvl);
            } while (userreader.readLine() != null);
            userreader.close();
        }
        catch (Exception e){
            ArrayList<Integer> cristals = new ArrayList<Integer>();
            cristals.add(0);
            data.add(cristals);
            ArrayList<Integer> skills = new ArrayList<Integer>();
            skills.add(100);
            skills.add(10);
            skills.add(10);
            data.add(skills);
            ArrayList<Integer> stock = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++){
                stock.add(0);
            }
            data.add(stock);
            FileHandle file = Gdx.files.local("smartgame/users/"+user+".txt");
            file.writeString("cristals: 0\n"+"life: 100\n"+"strength: 10\n"+"speed: 10\n"+"water: 0\n"+"fire: 0\n"+"air: 0\n", true);
            for (int i = 1; i <= nblvl; i++){
                file.writeString(i+"\n", true);
                file.writeString("0\n"+"0\n"+"0\n", true);
                ArrayList<Integer> lvl = new ArrayList<Integer>();
                for (int j = 0; j < 3; j++){
                    lvl.add(0);
                }
                data.add(lvl);
            }
        }
        return data;
    }

    public static void setUser(String user, int cristals, ArrayList<Integer> skills, ArrayList<ArrayList<Integer>> elements, ArrayList<Integer> stock) {
        try {
            FileHandle filetmp = Gdx.files.local("smartgame/users/"+user+"tmp.txt");
            filetmp.writeString("cristals: "+cristals+"\n"+"life: "+skills.get(0)+"\n"+"strength: "+skills.get(1)+"\n"+"speed: "+skills.get(2)+"\n",true);
            filetmp.writeString("water: "+stock.get(0)+"\n"+"fire: "+stock.get(1)+"\n"+"air: "+stock.get(2)+"\n",true);
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
