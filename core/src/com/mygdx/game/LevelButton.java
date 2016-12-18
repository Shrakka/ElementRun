package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 07/12/16.
 */

public class LevelButton extends NotAnimated {
    private int lvl;
    public LevelButton(int lvl){
        super(0,0,244*Gdx.graphics.getWidth()/720,244*Gdx.graphics.getHeight()/1280,"levelscreen/level"+lvl+"button.jpg");
        this.lvl = lvl;
        this.setX(this.computeX());
        this.setY(this.computeY());
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }

    public int computeX(){
        if (this.lvl % 2 != 0) {
            return Gdx.graphics.getWidth() / 4 - 244 * Gdx.graphics.getWidth() / 720 / 2;
        }
        else {
            return 3 * Gdx.graphics.getWidth() / 4 - 244 * Gdx.graphics.getWidth() / 720 / 2;
        }
    }

    public int computeY(){
        return (4*Gdx.graphics.getHeight()/5-244*Gdx.graphics.getHeight()/1280/2) - (int)((this.lvl-1)/2) * (244*Gdx.graphics.getHeight()/1280+80);
    }
}
