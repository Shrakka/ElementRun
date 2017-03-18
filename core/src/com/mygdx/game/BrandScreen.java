package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 11/03/17.
 */

public class BrandScreen {
    private Sprite sprite;

    public BrandScreen(){
        Texture texture = new Texture(Gdx.files.internal("brandscreen/screen.jpg"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.sprite = new Sprite(texture);
        this.sprite.setSize(Gdx.graphics.getWidth(), this.sprite.getHeight()*Gdx.graphics.getWidth()/this.sprite.getWidth());
        this.sprite.setOrigin(0,0);
        this.sprite.setPosition(0,0);
    }

    public void setAlpha(float x){
        this.sprite.setAlpha(x);
    }

    public void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }
}
