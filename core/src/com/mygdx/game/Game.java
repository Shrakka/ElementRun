package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by alexis on 27/11/16.
 */

public class Game {
    private String string;
    private Sprite sprite;
    private ArrayList<Ennemy> ennemy;
    private ArrayList<ModElement> modelement;
    private ArrayList<Hole> hole;
    private Character character;
    private int c = 0;

    public Game(String string, int level){
        this.string = string;
        this.character = new Character(0,0,128,128,100,100,100,"water");
        this.ennemy = LevelConstructor.getEnnemyLevel(level);
        this.hole = LevelConstructor.getHoleLevel(level);
        this.modelement = new ArrayList<ModElement>();

        this.init();
    }

    public ArrayList<Ennemy> getEnnemy(){
        return this.ennemy;
    }

    public ArrayList<Hole> getHole(){
        return this.hole;
    }

    public ArrayList<ModElement> getModElement() {
        return this.modelement;
    }

    public Character getCharacter(){
        return this.character;
    }

    public String getString(){
        return this.string;
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
        this.getCharacter().draw(batch);
        for (int i = 0; i < this.getEnnemy().size(); i++){
            this.getEnnemy().get(i).draw(batch);
        }
        for (int i = 0; i < this.getCharacter().getBlast().size(); i++){
            this.getCharacter().getBlast().get(i).draw(batch);
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            for (int j = 0; j < this.getEnnemy().get(i).getBlast().size(); j++){
                this.getEnnemy().get(i).getBlast().get(j).draw(batch);
            }
        }
        for (int i = 0; i < this.getModElement().size(); i++){
            this.getModElement().get(i).draw(batch);
        }
        for (int i = 0; i < this.getHole().size(); i++){
            this.getHole().get(i).draw(batch);
        }
        if (this.c == 50) {
            for (int i = 0; i < this.getEnnemy().size(); i++) {
                if (this.getEnnemy().get(i).getVisible()) {
                    this.getEnnemy().get(i).shootBlast();
                }
            }
            c = 0;
        }
        c++;
    }

    public void update(OrthographicCamera camera){
        this.getCharacter().Up();
        for (int i = 0; i < this.getCharacter().getBlast().size(); i++){
            this.getCharacter().getBlast().get(i).Up();
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            for (int j = 0; j < this.getEnnemy().get(i).getBlast().size(); j++){
                this.getEnnemy().get(i).getBlast().get(j).Down();
            }
        }
        this.getCharacter().checkCollisionEnnemy(this.getEnnemy());
        this.getCharacter().checkCollisionModElement(this.getModElement());
        this.getCharacter().checkCollisionBlastEnnemy(this.getEnnemy(),this.getModElement());
        this.getCharacter().checkCollisionBlastEnnemyBlast(this.getEnnemy());
        for (int i = 0; i < this.getEnnemy().size(); i++){
            this.getEnnemy().get(i).checkCollisionBlastEnnemy(this.getCharacter());
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            this.getEnnemy().get(i).updateVisible((int)camera.position.y+Gdx.graphics.getHeight()/2);
        }
        this.checkOutScreen(camera);
    }

    public void click(int screenX){
        if (screenX < Gdx.graphics.getWidth()/3*(this.getCharacter().getLine())){
            this.getCharacter().Left();
        }
        else if (screenX > Gdx.graphics.getWidth()/3*(this.getCharacter().getLine()+1)){
            this.getCharacter().Right();
        }
        else {
            this.getCharacter().shootBlast();
        }
    }

    public void checkOutScreen(OrthographicCamera camera){
        if (this.getEnnemy().size() > 0) {
            for (int i = 0; i < this.getEnnemy().size(); i++) {
                if (this.getEnnemy().get(i).getY() + this.getEnnemy().get(i).getHeight() < camera.position.y - camera.viewportHeight / 2f) {
                    this.getEnnemy().remove(i);
                }
            }
        }
        if (this.getCharacter().getBlast().size() > 0) {
            for (int i = 0; i < this.getCharacter().getBlast().size(); i++) {
                if (this.getCharacter().getBlast().get(i).getY() - 24 > camera.position.y + camera.viewportHeight / 2f) {
                    this.getCharacter().getBlast().remove(i);
                }
            }
        }
        for (int j = 0; j < this.getEnnemy().size(); j++) {
            if (this.getEnnemy().get(j).getBlast().size() > 0) {
                for (int i = 0; i < this.getEnnemy().get(j).getBlast().size(); i++) {
                    if (this.getEnnemy().get(j).getBlast().get(i).getY() + 24 < camera.position.y - camera.viewportHeight / 2f) {
                        this.getEnnemy().get(j).getBlast().remove(i);
                    }
                }
            }
        }
    }
}
