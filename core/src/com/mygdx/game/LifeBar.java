package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 08/12/16.
 */

public class LifeBar{
    private NotAnimated background;
    private NotAnimated life;

    public LifeBar(int x, int y, int life){
        this.background = new NotAnimated(this.computeX(x),y,(int)(0.8* Gdx.graphics.getWidth()/3),(int)(0.1* Gdx.graphics.getWidth()/3),"lifebar/background.png");
        this.life = new NotAnimated(this.computeX(x),y,(int)(0.8* Gdx.graphics.getWidth()/3)*life/100,(int)(0.1* Gdx.graphics.getWidth()/3),"lifebar/life.png");
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.life.draw(batch);
    }

    public int computeX(int x){
        return x;
    }

    public void update(int life, int x, int y){
        this.life.setWidth((int)(0.8* Gdx.graphics.getWidth()/3)*life/100);
        this.background.setY(y);
        this.life.setY(y);
        this.background.setX(this.computeX(x));
        this.life.setX(this.computeX(x));
    }

}
