package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by alexis on 06/12/16.
 */

public class DeadMenu {
    private String string;
    private Sprite sprite;
    private Button retrybutton;
    private Button exitbutton;

    public DeadMenu(String string){
        this.string = string;
        this.retrybutton = new Button("center",Dimensions.Height(40), 0.178, "deadscreen/retrybutton.png");
        this.exitbutton = new Button("center",Dimensions.Height(60), 0.178, "deadscreen/exitbutton.png");
        this.init();
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
    }
}
