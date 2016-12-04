package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexis on 01/12/16.
 */

public class LevelConstructor {

    public static ArrayList<Ennemy> getLevel(int level) {
        String type;
        ArrayList<Ennemy> ennemy = new ArrayList<Ennemy>();
        try {
            BufferedReader lvl = new BufferedReader(new FileReader("levels/level"+level+".txt"));
            do {
                type = lvl.readLine();
                if (type != null) {
                    if (type.equals("ennemy")) {
                        ennemy.add(new Ennemy(Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), Integer.parseInt(lvl.readLine()), lvl.readLine()));
                    }
                }
            } while (type != null);
            lvl.close();
        }
        catch (IOException e){
            System.out.println("levels/level"+level+".txt");
        }
        return ennemy;
    }
}
