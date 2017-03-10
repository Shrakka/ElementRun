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
    private Account account;
    private StockElement stockelement;
    private BottomLevelPanel bottompanel;

    public DeadMenu(String string, Account account){
        this.account = account;
        this.string = string;
        this.retrybutton = new Button("center",Dimensions.Height(50), 0.3, "deadscreen/retrybutton2.png");
        this.exitbutton = new Button("center",Dimensions.Height(40), 0.3, "deadscreen/exitbutton2.png");
        this.stockelement = new StockElement(this.getAccount().getStock().get(0),this.getAccount().getStock().get(1),this.getAccount().getStock().get(2));
        this.bottompanel = new BottomLevelPanel(this.account.getCristals());
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
        this.stockelement.draw(batch);
        this.bottompanel.draw(batch);
    }

    public Account getAccount(){
        return this.account;
    }

    public BottomLevelPanel getPanel(){
        return this.bottompanel;
    }
}
