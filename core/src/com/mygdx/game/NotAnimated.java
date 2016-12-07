package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class NotAnimated extends Actor {
    private String string;
    private Sprite sprite;

    public NotAnimated(int x, int y, int width, int height, String string){
        this.setBounds(x,y,width,height);
        this.string = string;
        this.init();
    }

    public void init(){
        Texture texture = new Texture(Gdx.files.internal(this.string));
        this.sprite = new Sprite(texture);
    }

    public void draw(SpriteBatch batch){
        batch.draw(this.sprite,this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
