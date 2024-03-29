package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 08/12/16.
 */

public class LifeBar{
    private NotAnimated background;
    private NotAnimated life;
    private int bwidth;

    public LifeBar(int x, int y){
        this.bwidth = Dimensions.Width(16);
        this.background = new NotAnimated(this.computeX(x),y,this.bwidth,Dimensions.Width(3),"lifebar/background.png");
        this.life = new NotAnimated(this.computeX(x),y,this.bwidth,Dimensions.Width(3),"lifebar/life.png");
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.life.draw(batch);
    }

    public int computeX(int x){
        return (x+(Dimensions.Width(20)-this.bwidth)/2);
    }

    public void update(int life, int maxlife, int x, int y){
        this.life.setWidth(this.bwidth*life/maxlife);
        this.background.setY(y);
        this.life.setY(y);
        this.background.setX(this.computeX(x));
        this.life.setX(this.computeX(x));
    }

    public int getHeight(){
        return (int)this.background.getHeight();
    }

}
