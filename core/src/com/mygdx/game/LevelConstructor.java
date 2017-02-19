package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class LevelConstructor {

    public static Level getLevel(int level, int mapwidth, int mapheight) {
        String line;
        ArrayList<Ennemy> ennemy = new ArrayList<Ennemy>();
        ArrayList<Hole> hole = new ArrayList<Hole>();
        try {
            FileHandle file = Gdx.files.internal("smartgame/levels/level"+level+".txt");
            BufferedReader lvl = new BufferedReader(file.reader());
            int x = 0;
            do {
                line = lvl.readLine();
                if (line != null) {
                    for (int i = 0; i < line.length(); i++){
                        if (line.charAt(i) == 'W'){
                            ennemy.add(new Ennemy(i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), (int)(50*(1+level/2.0)), (int)(10*(1+level/10.0)), "blast", "water"));
                        }
                        if (line.charAt(i) == 'F'){
                            ennemy.add(new Ennemy(i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), (int)(50*(1+level/2.0)), (int)(10*(1+level/10.0)), "blast", "fire"));
                        }
                        if (line.charAt(i) == 'A'){
                            ennemy.add(new Ennemy(i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), (int)(50*(1+level/2.0)), (int)(10*(1+level/10.0)), "blast", "air"));
                        }
                        if (line.charAt(i) == 'w'){
                            ennemy.add(new Ennemy(i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), (int)(50*(1+level/2.0)), (int)(2*(1+level/10.0)), "ray", "water"));
                        }
                        if (line.charAt(i) == 'f'){
                            ennemy.add(new Ennemy(i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), (int)(50*(1+level/2.0)), (int)(2*(1+level/10.0)), "ray", "fire"));
                        }
                        if (line.charAt(i) == 'a'){
                            ennemy.add(new Ennemy(i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), (int)(50*(1+level/2.0)), (int)(2*(1+level/10.0)), "ray", "air"));
                        }
                        if (line.charAt(i) == 'H'){
                            hole.add(new Hole(1,i,mapheight-Dimensions.Width(20)*x-Dimensions.Height(100), 10));
                        }
                    }
                }
                x++;
            } while (line != null);
            lvl.close();
        }
        catch (IOException e){
            System.out.println("smartgame/levels/level"+level+"/ennemy.txt");
        }
        return new Level(ennemy,hole);
    }
}
