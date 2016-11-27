package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SmartGame implements ApplicationListener, InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture img;
	private Ground ground;
	private Ennemy E;
	private String mvt = "";
	
	@Override
	public void create () {
		camera = new OrthographicCamera(720, 1280);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		Character C = new Character("data/spritesheet.atlas",1,20,50,50,100,20,10,"water");
		E = new Ennemy("data/spritesheet.atlas",1,20,50,50,100,20,10,"fire");
		System.out.println("Caracteristiques de C : "+C.getLife()+","+C.getStrength()+","+C.getSpeed()+","+C.getElement());
		System.out.println("Caracteristiques de E : "+E.getLife()+","+E.getStrength()+","+E.getSpeed()+","+E.getElement());
		C.Attack(E);
		System.out.println("Attaque");
		System.out.println("Caracteristiques de E : "+E.getLife()+","+E.getStrength()+","+E.getSpeed()+","+E.getElement());

		this.ground = new Ground("photo.jpg");
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		this.ground.draw(batch);
		E.draw(batch);
		camera.translate(0,1);
		camera.update();
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
