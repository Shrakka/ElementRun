package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 06/12/16.
 */

public class WinMenu {
    private BitmapFont font;
    private String string;
    private Sprite sprite;
    private Button retrybutton;
    private Button exitbutton;
    private int air;
    private int fire;
    private int water;
    private StockElement stockelement;
    private Account account;
    private BottomLevelPanel bottompanel;
    private Button[] elementsbuttons;

    public WinMenu(String string, int air, int fire, int water, Account account){
        this.font = Dimensions.Font();
        this.font.setColor(Color.DARK_GRAY);
        this.account = account;
        this.string = string;
        this.retrybutton = new Button("center", Dimensions.Height(45), 0.3, "winscreen/retrybutton2.png");
        this.exitbutton = new Button("center", Dimensions.Height(35), 0.3, "winscreen/exitbutton2.png");
        this.air = air;
        this.fire = fire;
        this.water = water;
        this.stockelement = new StockElement(this.getAccount().getStock().get(0),this.getAccount().getStock().get(1),this.getAccount().getStock().get(2));
        this.bottompanel = new BottomLevelPanel(this.account.getCristals());
        this.init();
    }

    public int getAir() {
        return this.air;
    }

    public int getFire() {
        return this.fire;
    }

    public int getWater() {
        return this.water;
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

        this.elementsbuttons = new Button[3];
        this.elementsbuttons[0] = new Button(Dimensions.Width(28),Dimensions.Height(64),0.08,"elements/air.png");
        this.elementsbuttons[1] = new Button(Dimensions.Width(46),Dimensions.Height(64),0.08,"elements/fire.png");
        this.elementsbuttons[2] = new Button(Dimensions.Width(64),Dimensions.Height(64),0.08,"elements/water.png");
    }

    public void draw(SpriteBatch batch){
        this.sprite.draw(batch);
        this.getRetryButton().draw(batch);
        this.getExitButton().draw(batch);
        this.stockelement.draw(batch);
        this.bottompanel.draw(batch);

        for (int i = 0; i < this.elementsbuttons.length; i++){
            this.elementsbuttons[i].draw(batch);
        }

        this.font.draw(batch, ""+this.air, Dimensions.Width(30), Dimensions.Height(62));
        this.font.draw(batch, ""+this.fire, Dimensions.Width(48), Dimensions.Height(62));
        this.font.draw(batch, ""+this.water, Dimensions.Width(66), Dimensions.Height(62));
    }

    public Account getAccount(){
        return this.account;
    }

    public BottomLevelPanel getPanel(){
        return this.bottompanel;
    }
}
