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
    private ArrayList<Displayed> otherThanCharacter;
    private Character character;

    public Ground(String string){
        this.string = string;
        this.character = new Character("character/air/air.atlas",0,0,128,128,100,100,100,"air");
        this.otherThanCharacter = new ArrayList<Displayed>();
        this.otherThanCharacter.add(new Ennemy("ennemy/fire/fire.atlas",1,700,100,100,100,100,100,"fire"));
        this.init();
    }

    public ArrayList<Displayed> getOtherThanCharacter(){
        return this.otherThanCharacter;
    }

    public Character getCharacter(){
        return this.character;
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
        this.getCharacter().draw(batch);
        for (int i = 0; i < this.getOtherThanCharacter().size(); i++){
            this.getOtherThanCharacter().get(i).draw(batch);
        }
    }

    public void update(){
        this.getCharacter().Up();
        this.getCharacter().checkCollision(this.getOtherThanCharacter());
    }

    public void click(int screenX){
        if (screenX < Gdx.graphics.getWidth()/3*(this.getCharacter().getX())){
            this.getCharacter().Left();
        }
        if (screenX > Gdx.graphics.getWidth()/3*(this.getCharacter().getX()+1)){
            this.getCharacter().Right();
        }
    }
}
