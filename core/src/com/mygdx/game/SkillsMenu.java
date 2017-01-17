package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 17/01/17.
 */

public class SkillsMenu {
    private String string;
    private Sprite sprite;
    private BottomSkillPanel panel;
    private StockElement stockelement;
    private Account account;

    public SkillsMenu(String string, Account account){
        this.account = account;
        this.stockelement = new StockElement(this.getAccount().getStock().get(0),this.getAccount().getStock().get(1),this.getAccount().getStock().get(2),this.getAccount().getCriskill().get(0));
        this.string = string;
        this.panel = new BottomSkillPanel();
        this.init();
    }

    public Account getAccount(){
        return this.account;
    }

    public String getString() {
        return this.string;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public BottomSkillPanel getPanel(){
        return this.panel;
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
        this.stockelement.draw(batch);
        this.getPanel().draw(batch);
    }
}
