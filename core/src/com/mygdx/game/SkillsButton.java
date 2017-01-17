package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by alexis on 17/01/17.
 */

public class SkillsButton extends NotAnimated {
    public SkillsButton(){
        super(6,6,200*Gdx.graphics.getWidth()/720,50*Gdx.graphics.getHeight()/1280,"levelscreen/skillsbutton.png");
    }

    public boolean click(int x, int y){
        return this.getBounds().contains(x,Gdx.graphics.getHeight()-y);
    }
}
