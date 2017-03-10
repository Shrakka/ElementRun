package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 17/01/17.
 */

public class BottomLevelPanel {
    private Button skillsbutton;
    private Button storebutton;
    private Button cristalsbutton;
    private int x;
    private int y;
    private int cristals;
    private BitmapFont font;
    private NotAnimated background;

    public BottomLevelPanel(int cristals){
        this.x = 0;
        this.y = 0;
        this.font = Dimensions.Font();
        this.skillsbutton = new Button(Dimensions.Width(5),Dimensions.Height(1),0.25,"levelscreen/skillsbutton2.png");
        this.storebutton = new Button("center",Dimensions.Height(1),0.25,"levelscreen/storebutton2.png");
        this.cristalsbutton = new Button(Dimensions.Width(75),Dimensions.Height(1),0.07,"levelscreen/cristalsbutton.png");
        this.cristals = cristals;
        this.background = new NotAnimated(this.x,this.y,Dimensions.Width(100),Dimensions.Height(7),"interface/bpanelbg.png");

    }

    public void draw(SpriteBatch batch){
        this.background.draw(batch);
        this.skillsbutton.draw(batch);
        this.storebutton.draw(batch);
        this.cristalsbutton.draw(batch);
        this.font.draw(batch, ""+this.cristals, Dimensions.Width(85),Dimensions.Height(4));
    }

    public Button getSkillsbutton() {
        return this.skillsbutton;
    }

    public void dispose(){
        this.font.dispose();
    }
}
