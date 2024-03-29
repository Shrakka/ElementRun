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
        Texture texture = new Texture(Gdx.files.internal(this.string),true);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.sprite = new Sprite(texture);
    }

    public NotAnimated(int x, int y, double s, String string){
        this.string = string;
        Texture texture = new Texture(Gdx.files.internal(this.string),true);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.sprite = new Sprite(texture);
        double scale = s * Gdx.graphics.getWidth() / this.sprite.getWidth();
        this.setBounds(x,y,(int)(this.sprite.getWidth()*scale),(int)(this.sprite.getHeight()*scale));
    }

    public NotAnimated(String type, int y, double s, String string){
        if (type.equals("center")){
            this.string = string;
            Texture texture = new Texture(Gdx.files.internal(this.string),true);
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            this.sprite = new Sprite(texture);
            double scale = s * Gdx.graphics.getWidth() / this.sprite.getWidth();
            this.setBounds((int)((Gdx.graphics.getWidth()-this.sprite.getWidth()*scale)/2),y,(int)(this.sprite.getWidth()*scale),(int)(this.sprite.getHeight()*scale));
        }
    }


    public void draw(SpriteBatch batch){
        batch.draw(this.sprite,this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
