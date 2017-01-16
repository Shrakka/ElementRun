package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

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

    public StockElement(int air,int fire,int water){
        this.x = 0;
        int height = (int)(0.06*Gdx.graphics.getHeight());
        this.y = Gdx.graphics.getHeight()-height;
        this.font = new BitmapFont(Gdx.files.internal("font/theboldfont.fnt"));
        this.font.getData().setScale(height*0.02f);
        this.background = new NotAnimated(x,y,Gdx.graphics.getWidth(),height,"font/black.png");
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

    public void updateValues(ArrayList<Integer> values){
        this.air = values.get(0);
        this.fire = values.get(1);
        this.water = values.get(2);
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.font.setColor(1,0.9f,0.8f,1);
        this.font.draw(batch, "Air : "+this.air, this.getX()+Gdx.graphics.getHeight()/100, this.getY()+this.font.getXHeight()+this.background.getHeight()*0.25f);
        this.font.setColor(Color.RED);
        this.font.draw(batch, "Fire : "+this.fire, this.getX()+Gdx.graphics.getWidth()/3, this.getY()+this.font.getXHeight()+this.background.getHeight()*0.25f);
        this.font.setColor(0,0.8f,0.8f,1);
        this.font.draw(batch, "Water : "+this.water, this.getX()+2*Gdx.graphics.getWidth()/3, this.getY()+this.font.getXHeight()+this.background.getHeight()*0.25f);
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
        this.setY(this.getY()+Gdx.graphics.getHeight()/480);
        this.background.setY(this.background.getY()+Gdx.graphics.getHeight()/480);

    }
}
