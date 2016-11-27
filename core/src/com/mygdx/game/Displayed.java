package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;


/**
 * Created by alexis on 24/11/16.
 */

public class Displayed extends Actor {
    private Animation animation;
    private TextureAtlas textureAtlas;
    private float elapsedTime;
    private String string;

    public Displayed(String string, int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.string = string;
        this.elapsedTime = 0;
        this.setAnimation(string);
        this.setTouchable(Touchable.enabled);
    }

    public void setAnimation(String string){
        this.setSize(this.getBounds().getWidth(),this.getBounds().getHeight());
        this.textureAtlas = new TextureAtlas(Gdx.files.internal(string));
        this.animation = new Animation(1f/this.textureAtlas.getRegions().size, this.textureAtlas.getRegions());
        this.elapsedTime = 0;
    }

    public int computeX(){
        return (int) (this.getX()*720/3+(720/3-this.getWidth())/2);
    }

    public void draw(Batch batch){
        this.elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(this.animation.getKeyFrame(this.elapsedTime, true),this.computeX(),this.getY(),this.getWidth(),this.getHeight());
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
