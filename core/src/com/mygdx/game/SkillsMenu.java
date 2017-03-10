package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private Button[] plusbuttons;
    private Button[] elementsbuttons;
    private BitmapFont font;

    public SkillsMenu(String string, Account account){
        this.font = Dimensions.Font();
        this.account = account;
        this.stockelement = new StockElement(this.getAccount().getStock().get(0),this.getAccount().getStock().get(1),this.getAccount().getStock().get(2));
        this.string = string;
        this.panel = new BottomSkillPanel();
        this.plusbuttons = new Button[3];
        for (int i = 0; i < this.plusbuttons.length; i++){
            this.plusbuttons[i] = new Button(Dimensions.Width(74),Dimensions.Height(70)-i*Dimensions.Height(15),0.1,"skillscreen/plusbutton.png");
        }
        this.elementsbuttons = new Button[3];
        this.elementsbuttons[0] = new Button(Dimensions.Width(30),Dimensions.Height(71),0.08,"elements/air.png");
        this.elementsbuttons[1] = new Button(Dimensions.Width(30),Dimensions.Height(56),0.08,"elements/fire.png");
        this.elementsbuttons[2] = new Button(Dimensions.Width(30),Dimensions.Height(41),0.08,"elements/water.png");
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
        this.drawText(batch);
        for (int i = 0; i < this.plusbuttons.length; i++){
            this.plusbuttons[i].draw(batch);
        }
        for (int i = 0; i < this.plusbuttons.length; i++){
            this.elementsbuttons[i].draw(batch);
        }
    }

    public void drawText(SpriteBatch batch){
        this.font.setColor(Color.WHITE);
        this.font.draw(batch,this.getAccount().getUser().toUpperCase(), Dimensions.Width(40), Dimensions.Height(90));

        this.font.setColor(Color.DARK_GRAY);
        this.font.draw(batch, "LIFE", Dimensions.Width(30), Dimensions.Height(79));
        this.font.draw(batch, ""+this.getAccount().getSkills().get(0), Dimensions.Width(75), Dimensions.Height(79));
        this.font.draw(batch, "STRENGTH", Dimensions.Width(30), Dimensions.Height(64));
        this.font.draw(batch, ""+this.getAccount().getSkills().get(1), Dimensions.Width(76), Dimensions.Height(64));
        this.font.draw(batch, "SPEED", Dimensions.Width(30), Dimensions.Height(49));
        this.font.draw(batch, ""+this.getAccount().getSkills().get(2), Dimensions.Width(76), Dimensions.Height(49));

        this.font.draw(batch, ""+this.getAccount().getCosts().get(0), Dimensions.Width(40), Dimensions.Height(74));
        this.font.draw(batch, ""+this.getAccount().getCosts().get(1), Dimensions.Width(40), Dimensions.Height(59));
        this.font.draw(batch, ""+this.getAccount().getCosts().get(2), Dimensions.Width(40), Dimensions.Height(44));
    }

    public int checkPlus(int x, int y){
        for (int i = 0; i < this.plusbuttons.length; i++){
            if (this.plusbuttons[i].click(x,y)){
                return i;
            }
        }
        return -1;
    }
    public void dispose(){
        this.font.dispose();
    }

    public void updateStock(){
        this.stockelement.updateValues(this.getAccount().getStock());
    }

}
