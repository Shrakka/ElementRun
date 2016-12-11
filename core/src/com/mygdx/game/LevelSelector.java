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

public class LevelSelector {
    private String string;
    private Sprite sprite;
    private ArrayList<LevelButton> levelbuttons;

    public LevelSelector(String string){
        this.string = string;
        this.levelbuttons = new ArrayList<LevelButton>();
        this.levelbuttons.add(new LevelButton(1));
        this.levelbuttons.add(new LevelButton(2));
        this.levelbuttons.add(new LevelButton(3));
        this.levelbuttons.add(new LevelButton(4));
        this.init();
    }

    public String getString(){
        return this.string;
    }

    public ArrayList<LevelButton> getLevelButtons(){
        return this.levelbuttons;
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
        for (int i = 0; i < this.getLevelButtons().size(); i++){
            this.getLevelButtons().get(i).draw(batch);
        }
    }

    public int getLevel(int X, int Y){
        for (int i = 0; i < this.getLevelButtons().size(); i++){
            if (this.getLevelButtons().get(i).click(X,Y)){
                return i+1;
            }
        }
        return 0;
    }
}
