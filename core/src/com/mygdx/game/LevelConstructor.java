package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class LevelConstructor {

    public static ArrayList<Ennemy> getEnnemyLevel(int level) {
        String sep;
        ArrayList<Ennemy> ennemy = new ArrayList<Ennemy>();
        try {
            FileHandle file = Gdx.files.internal("levels/level"+level+"/ennemy.txt");
            BufferedReader lvl = new BufferedReader(file.reader());
            do {
                sep = lvl.readLine();
                if (sep != null) {
                    ennemy.add(new Ennemy(Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), lvl.readLine(), lvl.readLine()));
                }
            } while (sep != null);
            lvl.close();
        }
        catch (IOException e){
            System.out.println("levels/level"+level+"/ennemy.txt");
        }
        return ennemy;
    }

    public static ArrayList<Hole> getHoleLevel(int level) {
        String sep;
        int longueur;
        int x;
        int y;
        int width;
        int height;
        int value;
        ArrayList<Hole> hole = new ArrayList<Hole>();
        try {
            FileHandle file = Gdx.files.internal("levels/level"+level+"/hole.txt");
            BufferedReader lvl = new BufferedReader(file.reader());
            do {
                sep = lvl.readLine();
                if (sep != null) {
                    longueur = Integer.parseInt(lvl.readLine());
                    x = Integer.parseInt(lvl.readLine());
                    y = Integer.parseInt(lvl.readLine());
                    width = Integer.parseInt(lvl.readLine());
                    height = Integer.parseInt(lvl.readLine());
                    value = Integer.parseInt(lvl.readLine());
                    for (int i = 0; i < longueur; i++) {
                        hole.add(new Hole(longueur,x,y+i*height,height,width,value));
                    }
                }
            } while (sep != null);
            lvl.close();
        }
        catch (IOException e){
            System.out.println("levels/level"+level+"/hole.txt");
        }
        return hole;
    }
}
