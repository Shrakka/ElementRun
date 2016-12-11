package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SmartGame implements ApplicationListener, InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Game game;
	private Menu menu;
	private LevelSelector lvlsct;
	private int selector;
	private NotAnimated rect;

	private final int MENU = 0;
	private final int LVLSCT = 1;
	private final int GAME = 2;
	
	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		batch = new SpriteBatch();
		this.createMenu();
		Gdx.input.setInputProcessor(this);
		this.selector = MENU;
	}

	public void createMenu(){
		this.menu = new Menu("menu/menu.jpg");
	}

	public void createGame(int level){
		this.game = new Game("menu/map.tmx",level);
	}

	public void createLevelSelector(){
		this.lvlsct = new LevelSelector("menu/levels.jpg");
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (this.selector == GAME) {
			this.game.update(camera);
		}
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		if (this.selector == MENU){
			this.menu.draw(batch);
			camera.update();
		}

		else if (this.selector == GAME) {
			this.game.draw(batch);
			camera.translate(0, 1);
			camera.update();
		}

		else if (this.selector == LVLSCT){
			this.lvlsct.draw(batch);
			camera.update();
		}

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
		if (this.selector == GAME) {
			this.game.click(screenX);
		}
		else if (this.selector == MENU && this.menu.getStartButton().click(screenX,screenY)) {
			this.selector = LVLSCT;
			this.createLevelSelector();
		}
		else if (this.selector == LVLSCT) {
			int lvl = this.lvlsct.getLevel(screenX, screenY);
			if (lvl > 0) {
				this.selector = GAME;
				this.createGame(lvl);
			}
		}
		return true;
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
