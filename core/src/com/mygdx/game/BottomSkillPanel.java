package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 17/01/17.
 */

public class BottomSkillPanel {
    private Button menubutton;
    private Button storebutton;
    private Button cristalsbutton;
    private int x;
    private int y;
    private BitmapFont font;
    private NotAnimated background;

    public BottomSkillPanel(){
        this.x = 0;
        this.y = 0;
        this.menubutton = new Button(Dimensions.Width(5),Dimensions.Height(1),0.25,"skillscreen/menubutton2.png");
        this.storebutton = new Button("center",Dimensions.Height(1),0.25,"levelscreen/storebutton2.png");
        this.background = new NotAnimated(this.x,this.y,Dimensions.Width(100),Dimensions.Height(7),"interface/bpanelbg.png");
    }

    public Button getMenubutton(){
        return this.menubutton;
    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.menubutton.draw(batch);
        this.storebutton.draw(batch);
    }
}
