package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserConstructor {

    public static ArrayList<ArrayList<Integer>> getUser(String user, int nblvl) {
        ArrayList<ArrayList<Integer>> elements = new ArrayList<ArrayList<Integer>>();
        String line;
        try {
            FileHandle file = Gdx.files.internal("users/"+user+".txt");
            BufferedReader userreader = new BufferedReader(file.reader());
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
            FileHandle file = Gdx.files.local("users/"+user+".txt");
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

    public static void setUser(String user, Character character, int lvl) {
        try {
            FileHandle file = Gdx.files.internal("users/"+user+".txt");
            BufferedReader userreader = new BufferedReader(file.reader());
            FileHandle filetmp = Gdx.files.local("users/"+user+"tmp.txt");
            String l = userreader.readLine();
            while (l != null) {
                filetmp.writeString(l+"\n",true);
                if (Integer.parseInt(l) == lvl){
                    filetmp.writeString(character.getStockAir()+"\n", true);
                    filetmp.writeString(character.getStockFire()+"\n", true);
                    filetmp.writeString(character.getStockWater()+"\n", true);
                    userreader.readLine();
                    userreader.readLine();
                    userreader.readLine();
                }
                else{
                    for (int i = 0; i < 3; i++){
                        filetmp.writeString(userreader.readLine()+"\n", true);
                    }
                }
                l = userreader.readLine();
            }
            userreader.close();
            Gdx.files.local("users/"+user+".txt").delete();
            filetmp.copyTo(Gdx.files.local("users/"+user+".txt"));
            Gdx.files.local("users/"+user+"tmp.txt").delete();
        }
        catch (Exception e){
            System.out.println("Problème d'écriture");
        }
    }
}
