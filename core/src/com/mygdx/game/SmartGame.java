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
	private DeadMenu dmenu;
	private WinMenu wmenu;
	private LevelSelector lvlsct;
	private int selector;
	private NotAnimated rect;

	private final int MENU = 0;
	private final int LVLSCT = 1;
	private final int GAME = 2;
	private final int DEAD = 3;
	private final int WIN = 4;
	
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
		this.menu = new Menu("startscreen/menu.jpg");
	}

	public void createGame(int level){
		this.game = new Game("ground/map.tmx",level);
	}

	public void createLevelSelector(){
		this.lvlsct = new LevelSelector("levelscreen/levels.jpg");
	}

	public void createDeadMenu(){
		this.dmenu = new DeadMenu("deadscreen/screen.jpg");
	}

	public void createWinMenu() {
		this.wmenu = new WinMenu("winscreen/screen.jpg",this.game.getCharacter().getStockAir(),this.game.getCharacter().getStockFire(),this.game.getCharacter().getStockWater());
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
			camera.translate(0, Gdx.graphics.getHeight()/480);
			camera.update();
			if (this.game.checkDeath()){
				this.selector = DEAD;
			}
			if (this.camera.position.y > this.game.getMapheight()-Gdx.graphics.getHeight()/2){
				this.selector = WIN;
			}
		}

		else if (this.selector == LVLSCT){
			this.lvlsct.draw(batch);
			camera.update();
		}

		else if (this.selector == DEAD){
			this.createDeadMenu();
			this.dmenu.draw(batch);
			camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
			camera.update();
		}

		else if (this.selector == WIN){
			this.createWinMenu();
			this.wmenu.draw(batch);
			camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
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
			this.lvlsct.clickLevel(screenX, screenY);
			int lvl = this.lvlsct.getLevel();
			if (lvl > 0) {
				this.selector = GAME;
				this.createGame(lvl);
			}
		}
		else if (this.selector == DEAD){
			if (this.dmenu.getRetryButton().click(screenX,screenY)){
				this.selector = GAME;
				this.createGame(this.lvlsct.getLevel());
			}
			if (this.dmenu.getExitButton().click(screenX,screenY)){
				this.selector = LVLSCT;
			}
		}
		else if (this.selector == WIN){
			if (this.wmenu.getRetryButton().click(screenX,screenY)){
				this.selector = GAME;
				this.createGame(this.lvlsct.getLevel());
			}
			if (this.wmenu.getExitButton().click(screenX,screenY)){
				this.selector = LVLSCT;
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
