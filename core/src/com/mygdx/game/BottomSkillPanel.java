package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 17/01/17.
 */

public class BottomSkillPanel {
    private NotAnimated background;
    private MenuButton menubutton;
    private int x;
    private int y;

    public BottomSkillPanel(){
        this.x = 0;
        int height = (int)(0.06*Gdx.graphics.getHeight());
        this.y = 0;
        this.background = new NotAnimated(x,y, Gdx.graphics.getWidth(),height,"font/black.png");
        this.menubutton = new MenuButton();
    }

    public MenuButton getMenubutton(){
        return this.menubutton;
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.menubutton.draw(batch);
    }
}
