package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 06/12/16.
 */

public class CreditScreen {
    private String string;
    private Sprite sprite;
    private Button exitbutton;

    public CreditScreen(String string){
        this.string = string;
        this.exitbutton = new Button("center",Dimensions.Height(10), 0.3, "deadscreen/exitbutton2.png");
        this.init();
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
        this.getExitButton().draw(batch);
    }
}
