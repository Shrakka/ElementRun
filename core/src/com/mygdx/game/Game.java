package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

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
    private OrthogonalTiledMapRenderer map;
    private int mapheight;
    private int mapwidth;
    private int c = 0;

    public Game(String string, int level){
        this.string = string;
        this.init();
        this.character = new Character(0,0,100,10,100,"water");
        Level lvl = LevelConstructor.getLevel(level,this.mapwidth,this.mapheight);
        this.ennemy = lvl.getEnnemy();
        this.hole = lvl.getHole();
        this.modelement = new ArrayList<ModElement>();
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
        this.mapwidth = Gdx.graphics.getWidth();
        this.mapheight = (10*Gdx.graphics.getWidth());
        this.map = new OrthogonalTiledMapRenderer(new TmxMapLoader().load(this.getString()),(float)(this.mapwidth)/768);
    }

    public void draw(SpriteBatch batch){
        this.drawOther(batch);
        this.drawEnnemy(batch);
        this.drawCharacter(batch);
    }

    public void update(OrthographicCamera camera){
        this.map.setView(camera);
        this.map.render();
        this.updateCharacter();
        this.updateEnnemy(camera);
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
            this.getCharacter().shoot();
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
        if (this.getCharacter().getAttack().size() > 0) {
            for (int i = 0; i < this.getCharacter().getAttack().size(); i++) {
                if (this.getCharacter().getAttack().get(i).getY() - 24 > camera.position.y + camera.viewportHeight / 2f) {
                    this.getCharacter().getAttack().remove(i);
                }
            }
        }
        for (int j = 0; j < this.getEnnemy().size(); j++) {
            if (this.getEnnemy().get(j).getAttack().size() > 0) {
                for (int i = 0; i < this.getEnnemy().get(j).getAttack().size(); i++) {
                    if (this.getEnnemy().get(j).getAttack().get(i).getY() + 24 < camera.position.y - camera.viewportHeight / 2f) {
                        this.getEnnemy().get(j).getAttack().remove(i);
                    }
                }
            }
        }
    }

    public void drawCharacter(SpriteBatch batch){
        this.getCharacter().draw(batch);
        this.getCharacter().getLifeBar().draw(batch);
        for (int i = 0; i < this.getCharacter().getAttack().size(); i++){
            this.getCharacter().getAttack().get(i).draw(batch);
        }
        this.getCharacter().getStockElement().draw(batch);
    }

    public void drawEnnemy(SpriteBatch batch){
        for (int i = 0; i < this.getEnnemy().size(); i++){
            this.getEnnemy().get(i).draw(batch);
            this.getEnnemy().get(i).getLifeBar().draw(batch);
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            for (int j = 0; j < this.getEnnemy().get(i).getAttack().size(); j++){
                this.getEnnemy().get(i).getAttack().get(j).draw(batch);
            }
        }
        if (this.c == 25) {
            for (int i = 0; i < this.getEnnemy().size(); i++) {
                if (this.getEnnemy().get(i).getVisible()) {
                    this.getEnnemy().get(i).shoot();
                }
            }
            this.c = 0;
        }
        this.c++;
    }

    public void drawOther(SpriteBatch batch){
        for (int i = 0; i < this.getModElement().size(); i++){
            this.getModElement().get(i).draw(batch);
        }
        for (int i = 0; i < this.getHole().size(); i++){
            this.getHole().get(i).draw(batch);
        }
    }

    public void updateCharacter(){
        this.getCharacter().Up();
        this.getCharacter().getLifeBar().update(this.getCharacter().getLife(),(int)this.getCharacter().getX(),(int)this.getCharacter().getY());
        for (int i = 0; i < this.getCharacter().getAttack().size(); i++){
            this.getCharacter().getAttack().get(i).Up();
        }
        this.getCharacter().checkCollisionHole(this.getHole());
        this.getCharacter().checkCollisionEnnemy(this.getEnnemy());
        this.getCharacter().checkCollisionModElement(this.getModElement());
        this.getCharacter().checkCollisionAttackEnnemy(this.getEnnemy(),this.getModElement());
        this.getCharacter().checkCollisionAttackEnnemyAttack(this.getEnnemy());
        this.getCharacter().getStockElement().update(this.getCharacter().getStockAir(),this.getCharacter().getStockFire(),this.getCharacter().getStockWater());
        this.getCharacter().checkDeath();
    }

    public void updateEnnemy(OrthographicCamera camera){
        for (int i = 0; i < this.getEnnemy().size(); i++){
            for (int j = 0; j < this.getEnnemy().get(i).getAttack().size(); j++){
                if (this.getEnnemy().get(i).getType().equals("blast")){
                    this.getEnnemy().get(i).getAttack().get(j).Down();
                }
            }
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            this.getEnnemy().get(i).checkCollisionBlastEnnemy(this.getCharacter());
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            this.getEnnemy().get(i).updateVisible((int)camera.position.y+Gdx.graphics.getHeight()/2);
            this.getEnnemy().get(i).getLifeBar().update(this.getEnnemy().get(i).getLife(),(int)this.getEnnemy().get(i).getX(),(int)this.getEnnemy().get(i).getY());
        }
        for (int i = 0; i < this.getEnnemy().size(); i++){
            if (this.getEnnemy().get(i).checkDeath()){
                this.getModElement().add(new ModElement(this.getEnnemy().get(i).getLine(), (int)this.getEnnemy().get(i).getY(), (int)this.getEnnemy().get(i).getWidth(), this.getEnnemy().get(i).getElement()));
                this.getEnnemy().remove(i);
            }
        }
    }
}
