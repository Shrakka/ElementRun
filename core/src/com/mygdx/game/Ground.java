package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Ground {
    private String string;
    private Sprite sprite;
    private ArrayList<Displayed> displayed;

    public Ground(String string){
        this.string = string;
        this.displayed = new ArrayList<Displayed>();
        this.displayed.add(new Character("data/spritesheet.atlas",0,0,100,100,100,100,100,"fire"));
        this.displayed.add(new Ennemy("data/spritesheet.atlas",1,700,100,100,100,100,100,"fire"));
        this.init();
    }

    public ArrayList<Displayed> getDisplayed(){
        return this.displayed;
    }

    public String getString(){
        return this.string;
    }

    public void init(){
        Texture texture = new Texture(Gdx.files.internal(this.getString()));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.sprite = new Sprite(texture);
        this.sprite.setOrigin(0,0);
        this.sprite.setPosition(0,0);
    }

    public void draw(SpriteBatch batch){
        this.sprite.draw(batch);
        for (int i = 0; i < this.getDisplayed().size(); i++){
            this.getDisplayed().get(i).draw(batch);
        }
    }

    public void update(){
        ((Character)this.getDisplayed().get(0)).Up();
    }

    public void click(int screenX){
        if (screenX < 720/3*((Character)this.getDisplayed().get(0)).getX()){
            ((Character)this.getDisplayed().get(0)).Left();
        }
        if (screenX > 720/3*(((Character)this.getDisplayed().get(0)).getX()+1)){
            ((Character)this.getDisplayed().get(0)).Right();
        }
    }
}
