package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 08/12/16.
 */

public class StockElement {
    private BitmapFont font;
    private int air;
    private int fire;
    private int water;
    private int x;
    private int y;
    private NotAnimated background;

    public StockElement(int x, int y, int air,int fire,int water){
        this.font = new BitmapFont(Gdx.files.internal("font/theboldfont.fnt"));
        this.background = new NotAnimated(x,y,Gdx.graphics.getWidth(),50,"font/black.png");
        this.x = x;
        this.y = y;
        this.fire = fire;
        this.air = air;
        this.water = water;
    }

    public void update(int air, int fire, int water){
        this.air = air;
        this.fire = fire;
        this.water = water;
        this.Up();
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.font.setColor(1,0.9f,0.8f,1);
        this.font.draw(batch, "Air : "+this.air, this.getX()+20, this.getY()+this.font.getXHeight()+10);
        this.font.setColor(Color.RED);
        this.font.draw(batch, "Fire : "+this.fire, this.getX()+170, this.getY()+this.font.getXHeight()+10);
        this.font.setColor(0,0.8f,0.8f,1);
        this.font.draw(batch, "Water : "+this.water, this.getX()+320, this.getY()+this.font.getXHeight()+10);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Up(){
        this.setY(this.getY()+1);
        this.background.setY(this.background.getY()+1);

    }
}
