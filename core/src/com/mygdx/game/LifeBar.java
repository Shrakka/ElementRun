package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 08/12/16.
 */

public class LifeBar{
    private NotAnimated background;
    private NotAnimated life;

    public LifeBar(int x, int y, int life){
        this.background = new NotAnimated(this.computeX(x),y,100,10,"lifebar/background.png");
        this.life = new NotAnimated(this.computeX(x),y,life,10,"lifebar/life.png");
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.life.draw(batch);
    }

    public int computeX(int x){
        return x-(100-128)/2;
    }

    public void update(int life, int x, int y){
        if (life >= 0) {
            this.life.setWidth(life);
        }
        this.background.setY(y);
        this.life.setY(y);
        this.background.setX(this.computeX(x));
        this.life.setX(this.computeX(x));
    }

}
