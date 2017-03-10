package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by alexis on 06/12/16.
 */

public class LevelMenu {
    private BitmapFont font;
    private String string;
    private Sprite sprite;
    private ArrayList<LevelButton> levelbuttons;
    private int lvl;
    private Account account;
    private StockElement stockelement;
    private BottomLevelPanel bottompanel;
    private Button runbutton;
    private Button[] elementsbuttons;

    public LevelMenu(String string, Account account, int lvl){
        this.font = Dimensions.Font();
        this.font.setColor(Color.DARK_GRAY);
        this.string = string;
        this.lvl = lvl;
        this.account = account;
        this.stockelement = new StockElement(this.getAccount().getStock().get(0),this.getAccount().getStock().get(1),this.getAccount().getStock().get(2));
        this.bottompanel = new BottomLevelPanel(this.account.getCristals());
        this.runbutton = new Button("center", Dimensions.Height(20),0.3,"levelmenuscreen/runbutton.png");
        this.init();
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
        this.elementsbuttons[0] = new Button(Dimensions.Width(28),Dimensions.Height(40),0.08,"elements/air.png");
        this.elementsbuttons[1] = new Button(Dimensions.Width(46),Dimensions.Height(40),0.08,"elements/fire.png");
        this.elementsbuttons[2] = new Button(Dimensions.Width(64),Dimensions.Height(40),0.08,"elements/water.png");
    }

    public Account getAccount() {
        return this.account;
    }

    public void draw(SpriteBatch batch){
        this.sprite.draw(batch);
        this.stockelement.draw(batch);
        this.bottompanel.draw(batch);
        this.runbutton.draw(batch);

        this.font.draw(batch, "LEVEL ................... "+this.lvl, Dimensions.Width(31), Dimensions.Height(50));
        for (int i = 0; i < this.elementsbuttons.length; i++){
            this.elementsbuttons[i].draw(batch);
        }

        this.font.draw(batch, ""+this.account.getElements().get(this.lvl-1).get(0), Dimensions.Width(30), Dimensions.Height(38));
        this.font.draw(batch, ""+this.account.getElements().get(this.lvl-1).get(1), Dimensions.Width(48), Dimensions.Height(38));
        this.font.draw(batch, ""+this.account.getElements().get(this.lvl-1).get(2), Dimensions.Width(66), Dimensions.Height(38));
    }

    public Button getRunButton(){
        return this.runbutton;
    }

    public int getLvl() {
        return this.lvl;
    }

    public BottomLevelPanel getPanel(){
        return this.bottompanel;
    }

}
