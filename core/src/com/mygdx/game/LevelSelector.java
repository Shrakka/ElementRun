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
    private int lvl;
    private Account account;
    private int nblvl;

    public LevelSelector(String string, Account account, int nblvl){
        this.string = string;
        this.lvl = 0;
        this.nblvl = nblvl;
        this.account = account;
        this.levelbuttons = new ArrayList<LevelButton>();
        for (int i = 1; i <= this.nblvl; i++) {
            this.levelbuttons.add(new LevelButton(i));
        }
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

    public Account getAccount() {
        return this.account;
    }

    public void draw(SpriteBatch batch){
        this.sprite.draw(batch);
        for (int i = 0; i < this.getLevelButtons().size(); i++){
            this.getLevelButtons().get(i).draw(batch, this.account);
        }
    }

    public void setLevel(int lvl){
        this.lvl = lvl;
    }

    public int getLevel(){
        return this.lvl;
    }

    public void clickLevel(int X, int Y){
        boolean b = false;
        for (int i = 0; i < this.getLevelButtons().size(); i++){
            if (this.getLevelButtons().get(i).click(X,Y)){
                this.setLevel(i+1);
                b = true;
            }
        }
        if (!b){
            this.setLevel(0);
        }
    }
}
