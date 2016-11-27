package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 27/11/16.
 */

public class Ground {
    private String string;
    private Sprite sprite;

    public Ground(String string){
        this.string = string;
        this.init();
    }

    public String getString(){
        return this.string;
    }

    public void init(){
        Texture texture = new Texture(Gdx.files.internal(this.getString()));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.sprite = new Sprite(texture);
        this.sprite.setOrigin(0,0);
        this.sprite.setPosition(-this.sprite.getWidth()/2,-this.sprite.getHeight()/2);
    }

    public void draw(SpriteBatch batch){
        this.sprite.draw(batch);
    }
}
