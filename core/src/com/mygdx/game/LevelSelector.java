package com.mygdx.game;

import com.badlogic.gdx.Gdx;
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
    private StockElement stockelement;
    private BottomLevelPanel bottompanel;

    public LevelSelector(String string, Account account, int nblvl){
        this.string = string;
        this.lvl = 0;
        this.nblvl = nblvl;
        this.account = account;
        this.stockelement = new StockElement(this.getAccount().getStock().get(0),this.getAccount().getStock().get(1),this.getAccount().getStock().get(2));
        this.levelbuttons = new ArrayList<LevelButton>();
        this.bottompanel = new BottomLevelPanel(this.account.getCristals());
        this.levelbuttons.add(new LevelButton(1,Dimensions.Width(38),Dimensions.Height(75)));
        this.levelbuttons.add(new LevelButton(2,Dimensions.Width(35),Dimensions.Height(58)));
        this.levelbuttons.add(new LevelButton(3,Dimensions.Width(46),Dimensions.Height(41)));
        this.levelbuttons.add(new LevelButton(4,Dimensions.Width(40),Dimensions.Height(24)));
        this.init();
    }

    public BottomLevelPanel getPanel(){
        return this.bottompanel;
    }

    public void updateStock(){
        this.stockelement.updateValues(this.getAccount().getStock());
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
            this.getLevelButtons().get(i).draw(batch);
        }
        this.stockelement.draw(batch);
        this.bottompanel.draw(batch);
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
