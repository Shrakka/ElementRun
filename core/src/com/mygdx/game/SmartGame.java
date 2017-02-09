package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SmartGame implements ApplicationListener, InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Game game;
	private StartMenu menu;
	private DeadMenu dmenu;
	private WinMenu wmenu;
	private SkillsMenu smenu;
	private LevelSelector lvlsct;
	private int selector;
	private Account account;
	private int nblvl;

	private final int MENU = 0;
	private final int LVLSCT = 1;
	private final int GAME = 2;
	private final int DEAD = 3;
	private final int WIN = 4;
	private final int SKILLS = 5;
	
	@Override
	public void create () {
		this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
		this.batch = new SpriteBatch();
		this.nblvl = Gdx.files.internal("smartgame/levels/").list().length;
		this.account = new Account("Android", this.nblvl);
		this.createMenu();
		Gdx.input.setInputProcessor(this);
		this.selector = MENU;
	}

	public void createMenu(){
		this.menu = new StartMenu("startscreen/menu.jpg");
	}

	public void createGame(int level){
		this.game = new Game("ground/map.tmx",level,this.account);
	}

	public void createLevelSelector(){
		this.lvlsct = new LevelSelector("levelscreen/levels.jpg", this.account, this.nblvl);
	}

	public void createDeadMenu(){
		this.dmenu = new DeadMenu("deadscreen/screen.jpg");
	}

	public void createWinMenu() {
		this.wmenu = new WinMenu("winscreen/screen.jpg",this.game.getCharacter().getStockAir(),this.game.getCharacter().getStockFire(),this.game.getCharacter().getStockWater());
	}

	public void createSkillMenu(){
		this.smenu = new SkillsMenu("skillscreen/screen.jpg",this.account);
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
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();

		if (this.selector == MENU){
			this.menu.draw(this.batch);
			this.camera.update();
		}

		else if (this.selector == GAME) {
			this.game.draw(this.batch);
			this.camera.translate(0, (int)(this.game.getCharacter().getSpeed()*0.02*Dimensions.Height(1)));
			this.camera.update();
			if (this.game.checkDeath()){
				this.selector = DEAD;
			}
			if (this.camera.position.y > this.game.getMapheight()-Gdx.graphics.getHeight()/2){
				this.selector = WIN;
			}
		}

		else if (this.selector == LVLSCT){
			this.lvlsct.getLevel();
			this.lvlsct.draw(this.batch);
			this.camera.update();
		}

		else if (this.selector == DEAD){
			this.createDeadMenu();
			this.dmenu.draw(this.batch);
			this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
			this.camera.update();
		}

		else if (this.selector == WIN){
			this.createWinMenu();
			this.wmenu.draw(this.batch);
			this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
			this.camera.update();
		}

		else if (this.selector == SKILLS){
			this.createSkillMenu();
			this.smenu.getAccount().computeCosts();
			this.smenu.draw(this.batch);
			this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
			this.camera.update();
		}

		this.batch.end();
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
			else if (this.lvlsct.getPanel().getSkillsbutton().click(screenX,screenY)){
				this.selector = SKILLS;
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
			if (this.wmenu.getRetryButton().click(screenX,screenY) || this.wmenu.getExitButton().click(screenX,screenY)){
				this.account.getCharacterElements(this.game.getCharacter(), this.lvlsct.getLevel());
				this.account.addElementsStock(this.lvlsct.getLevel());
				UserConstructor.setUser(this.account.getUser(), this.account.getCristals(), this.account.getSkills(), this.account.getElements(), this.account.getStock());
				this.lvlsct.updateStock();
			}
			if (this.wmenu.getRetryButton().click(screenX,screenY)){
				this.selector = GAME;
				this.createGame(this.lvlsct.getLevel());
			}
			if (this.wmenu.getExitButton().click(screenX,screenY)){
				this.selector = LVLSCT;
			}
			if (this.wmenu.getRetryButton().click(screenX,screenY) || this.wmenu.getExitButton().click(screenX,screenY)){
				this.game.dispose();
				this.game = null;
			}
		}

		else if (this.selector == SKILLS){
			if (this.smenu.getPanel().getMenubutton().click(screenX,screenY)){
				UserConstructor.setUser(this.account.getUser(), this.account.getCristals(), this.account.getSkills(), this.account.getElements(), this.account.getStock());
				this.selector = LVLSCT;
			}
			else if (this.smenu.checkPlus(screenX, screenY) == 0){
				this.account.downAir();
				this.lvlsct.updateStock();
			}
			else if (this.smenu.checkPlus(screenX, screenY) == 1){
				this.account.downFire();
				this.lvlsct.updateStock();
			}
			else if (this.smenu.checkPlus(screenX, screenY) == 2){
				this.account.downWater();
				this.lvlsct.updateStock();
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
