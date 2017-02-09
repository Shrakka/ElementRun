package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 17/01/17.
 */

public class BottomSkillPanel {
    private Button menubutton;
    private int x;
    private int y;

    public BottomSkillPanel(){
        this.x = 0;
        this.y = 0;
        this.menubutton = new Button(Dimensions.Width(5),Dimensions.Height(2),0.178,"skillscreen/menubutton.png");
    }

    public Button getMenubutton(){
        return this.menubutton;
    }

    public void draw(SpriteBatch batch){
        this.menubutton.draw(batch);
    }
}
