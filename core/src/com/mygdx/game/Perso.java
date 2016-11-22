package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.ArrayList;

/**
 * Created by alexis on 06/10/16.
 */

public class Perso extends Actor {
    private Animation animation;
    private TextureAtlas textureAtlas;
    private float elapsedTime;
    private String animationDefault;
    private int width;
    private int height;

    public Perso(String animationDefault, int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        this.setBounds(x,y,this.width,this.height);
        this.animationDefault = animationDefault;
        this.setAnimationDefault();
        this.setTouchable(Touchable.enabled);
    }

    public void setAnimation(String animation, int width, int height){
        this.setSize(width,height);
        this.textureAtlas = new TextureAtlas(Gdx.files.internal(animation));
        this.animation = new Animation(1/8f, textureAtlas.getRegions());
        this.elapsedTime = 0;
    }

    public void setAnimationDefault(){
        this.setSize(this.width,this.height);
        this.textureAtlas = new TextureAtlas(Gdx.files.internal(this.animationDefault));
        this.animation = new Animation(1/8f, textureAtlas.getRegions());
        this.elapsedTime = 0;
    }

    public void draw(Batch batch, float alpha){
        this.elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(this.animation.getKeyFrame(this.elapsedTime, true),this.getX(),this.getY(),this.getWidth(),this.getHeight());
        if (this.animation.isAnimationFinished(this.elapsedTime)){
            this.setAnimationDefault();
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }

    public boolean overlaps(Perso p){
        return this.getBounds().overlaps(p.getBounds());
    }

    public void attaque(ArrayList<Perso> array){
        this.setAnimation("zoro/zoro_attaque/zoro_attaque.atlas", 243, 243);
        for (int i = 0; i < array.size(); i++) {
            if (this.overlaps(array.get(i))) {
                array.get(i).setVisible(false);
                array.remove(i);
            }
        }
    }
}
