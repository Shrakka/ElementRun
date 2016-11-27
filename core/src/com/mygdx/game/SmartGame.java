package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SmartGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Character C = new Character("data/spritesheet.atlas",1,20,50,50,100,20,10,"water");
		Ennemy E = new Ennemy("data/spritesheet.atlas",1,20,50,50,100,20,10,"fire");
		System.out.println("Caracteristiques de C : "+C.getLife()+","+C.getStrength()+","+C.getSpeed()+","+C.getElement());
		System.out.println("Caracteristiques de E : "+E.getLife()+","+E.getStrength()+","+E.getSpeed()+","+E.getElement());
		C.Attack(E);
		System.out.println("Attaque");
		System.out.println("Caracteristiques de E : "+E.getLife()+","+E.getStrength()+","+E.getSpeed()+","+E.getElement());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
