package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexis on 17/01/17.
 */

public class BottomLevelPanel {
    private Button skillsbutton;
    private Button cristalsbutton;
    private int x;
    private int y;
    private int cristals;
    private BitmapFont font;

    public BottomLevelPanel(int cristals){
        this.x = 0;
        this.y = 0;
        this.font = new BitmapFont(Gdx.files.internal("font/cantarell.fnt"));
        this.skillsbutton = new Button(Dimensions.Width(5),Dimensions.Height(2),1,"levelscreen/skillsbutton.png");
        this.cristalsbutton = new Button(Dimensions.Width(75),Dimensions.Height(2),0.4,"levelscreen/cristalsbutton.png");
        this.cristals = cristals;

    }

    public void draw(SpriteBatch batch){
        this.skillsbutton.draw(batch);
        this.cristalsbutton.draw(batch);
        this.font.draw(batch, ""+this.cristals, Dimensions.Width(85),Dimensions.Height(5));
    }

    public Button getSkillsbutton() {
        return this.skillsbutton;
    }
}
