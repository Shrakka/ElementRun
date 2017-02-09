package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 07/12/16.
 */

public class LevelButton extends Button {
    private int lvl;

    public LevelButton(int lvl, int x, int y){
        super(x,y,0.178,"levelscreen/level"+lvl+"button.png");
        this.lvl = lvl;
    }
}
