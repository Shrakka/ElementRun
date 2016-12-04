package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexis on 01/12/16.
 */

public class LevelConstructor {

    public static ArrayList<Ennemy> getEnnemyLevel(int level) {
        String sep;
        ArrayList<Ennemy> ennemy = new ArrayList<Ennemy>();
        try {
            BufferedReader lvl = new BufferedReader(new FileReader("levels/level"+level+"/ennemy.txt"));
            do {
                sep = lvl.readLine();
                if (sep != null) {
                    ennemy.add(new Ennemy(Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), lvl.readLine()));
                }
            } while (sep != null);
            lvl.close();
        }
        catch (IOException e){
            System.out.println("levels/level"+level+"/ennemy.txt");
        }
        return ennemy;
    }
}
