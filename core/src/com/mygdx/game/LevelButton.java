package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 07/12/16.
 */

public class LevelButton extends NotAnimated {
    private int lvl;
    private BitmapFont font;

    public LevelButton(int lvl){
        super(0,0,244*Gdx.graphics.getWidth()/720,244*Gdx.graphics.getHeight()/1280,"levelscreen/level"+lvl+"button.jpg");
        this.lvl = lvl;
        this.setX(this.computeX());
        this.setY(this.computeY());
        this.font = new BitmapFont(Gdx.files.internal("font/theboldfont.fnt"));
        this.font.getData().setScale(Gdx.graphics.getHeight()*0.06f*0.02f);
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }

    public int computeX(){
        if (this.lvl % 2 != 0) {
            return Gdx.graphics.getWidth() / 4 - 244 * Gdx.graphics.getWidth() / 720 / 2;
        }
        else {
            return 3 * Gdx.graphics.getWidth() / 4 - 244 * Gdx.graphics.getWidth() / 720 / 2;
        }
    }

    public int computeY(){
        return (4*Gdx.graphics.getHeight()/5-244*Gdx.graphics.getHeight()/1280/2) - (int)((this.lvl-1)/2) * (244*Gdx.graphics.getHeight()/1280+80);
    }

    public void draw(SpriteBatch batch, Account account){
        super.draw(batch);
        font.setColor(1,0.9f,0.8f,1);
        font.draw(batch, ""+account.getElements().get(this.lvl-1).get(0), this.computeX(), this.computeY());
        font.setColor(Color.RED);
        font.draw(batch, ""+account.getElements().get(this.lvl-1).get(1), this.computeX()+this.getWidth()/3, this.computeY());
        font.setColor(0,0.8f,0.8f,1);
        font.draw(batch, ""+account.getElements().get(this.lvl-1).get(2), this.computeX()+2*this.getWidth()/3, this.computeY());
    }
}
