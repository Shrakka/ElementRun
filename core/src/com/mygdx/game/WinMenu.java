package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 06/12/16.
 */

public class WinMenu {
    private String string;
    private Sprite sprite;
    private Button retrybutton;
    private Button exitbutton;
    private int air;
    private int fire;
    private int water;

    public WinMenu(String string, int air, int fire, int water){
        this.string = string;
        this.retrybutton = new Button("center", Dimensions.Height(40), 0.178, "deadscreen/retrybutton.png");
        this.exitbutton = new Button("center", Dimensions.Height(60), 0.178, "deadscreen/exitbutton.png");
        this.air = air;
        this.fire = fire;
        this.water = water;
        this.init();
    }

    public int getAir() {
        return this.air;
    }

    public int getFire() {
        return this.fire;
    }

    public int getWater() {
        return this.water;
    }

    public Button getRetryButton() {
        return this.retrybutton;
    }

    public Button getExitButton() {
        return this.exitbutton;
    }

    public String getString(){
        return this.string;
    }

    public void init(){
        Texture texture = new Texture(Gdx.files.internal(this.getString()));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.sprite = new Sprite(texture);
        this.sprite.setSize(Gdx.graphics.getWidth(), this.sprite.getHeight()*Gdx.graphics.getWidth()/this.sprite.getWidth());
        this.sprite.setOrigin(0,0);
        this.sprite.setPosition(0,0);
    }

    public void draw(SpriteBatch batch){
        this.sprite.draw(batch);
        this.getRetryButton().draw(batch);
        this.getExitButton().draw(batch);
        BitmapFont font = new BitmapFont(Gdx.files.internal("font/theboldfont.fnt"));
        font.getData().setScale(Gdx.graphics.getHeight()*0.06f*0.02f);
        font.setColor(1,0.9f,0.8f,1);
        font.draw(batch, ""+this.air, 0.23f*Gdx.graphics.getWidth(), 0.66f*Gdx.graphics.getHeight());
        font.setColor(Color.RED);
        font.draw(batch, ""+this.fire, 0.48f*Gdx.graphics.getWidth(), 0.66f*Gdx.graphics.getHeight());
        font.setColor(0,0.8f,0.8f,1);
        font.draw(batch, ""+this.water, 0.73f*Gdx.graphics.getWidth(), 0.66f*Gdx.graphics.getHeight());
    }
}
