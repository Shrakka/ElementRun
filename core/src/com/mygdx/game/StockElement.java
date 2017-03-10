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
    private int y;
    private Button airbutton;
    private Button firebutton;
    private Button waterbutton;
    private NotAnimated background;

    public StockElement(int air,int fire,int water){
        this.y = Dimensions.Height(95);
        this.font = Dimensions.Font();
        this.background = new NotAnimated(0,this.y-Dimensions.Height(1),Dimensions.Width(100),Dimensions.Height(6),"interface/tpanelbg.png");

        this.fire = fire;
        this.air = air;
        this.water = water;

        this.airbutton = new Button(Dimensions.Width(5),this.y,0.07,"elements/air.png");
        this.firebutton = new Button(Dimensions.Width(40),this.y,0.07,"elements/fire.png");
        this.waterbutton = new Button(Dimensions.Width(75),this.y,0.07,"elements/water.png");
    }

    public void update(int air, int fire, int water){
        this.air = air;
        this.fire = fire;
        this.water = water;
    }

    public void updateValues(ArrayList<Integer> values){
        this.air = values.get(0);
        this.fire = values.get(1);
        this.water = values.get(2);
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.font.draw(batch, ""+this.air, Dimensions.Width(15),this.y+Dimensions.Height(3));
        this.font.draw(batch, ""+this.fire, Dimensions.Width(50),this.y+Dimensions.Height(3));
        this.font.draw(batch, ""+this.water, Dimensions.Width(85),this.y+Dimensions.Height(3));
        this.airbutton.draw(batch);
        this.firebutton.draw(batch);
        this.waterbutton.draw(batch);
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Up(int speed){
        this.setY(this.getY()+(int)(speed*0.02*Dimensions.Height(1)));
        this.background.setY(this.y-Dimensions.Height(1));
        this.airbutton.setY(this.y);
        this.firebutton.setY(this.y);
        this.waterbutton.setY(this.y);
    }
    public void dispose(){
        this.font.dispose();
    }

}
