package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.Input.Keys.UP;

public class SmartGame implements ApplicationListener, InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Game game;
	private StartMenu menu;
	private DeadMenu dmenu;
	private WinMenu wmenu;
	private SkillsMenu smenu;
	private LevelSelector lvlsct;
	private LevelMenu lmenu;
	private int selector;
	private Account account;
	private int nblvl;

	private final int MENU = 0;
	private final int LVLSCT = 1;
	private final int GAME = 2;
	private final int DEAD = 3;
	private final int WIN = 4;
	private final int SKILLS = 5;
	private final int LVL = 6;
	
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
		this.createSkillMenu();
	}

	public void createLevelMenu(int lvl){
		this.lmenu = new LevelMenu("levelmenuscreen/screen.jpg", this.account, lvl);
	}

	public void createDeadMenu(){
		this.dmenu = new DeadMenu("deadscreen/screen.jpg",this.account);
	}

	public void createWinMenu() {
		this.wmenu = new WinMenu("winscreen/screen.jpg",this.game.getCharacter().getStockAir(),this.game.getCharacter().getStockFire(),this.game.getCharacter().getStockWater(),this.account);
		//this.wmenu = new WinMenu("winscreen/screen.jpg",1,2,3,this.account);
	}

	public void createSkillMenu(){
		this.smenu = new SkillsMenu("skillscreen/screen.jpg",this.account);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (this.selector == GAME) {
			this.game.update(camera);
		}
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();

		if (this.selector == LVL){
			this.lmenu.draw(this.batch);
			this.camera.update();
		}

		if (this.selector == MENU){
			this.menu.draw(this.batch);
			this.camera.update();
		}

		else if (this.selector == GAME) {
			this.game.draw(this.batch);
			this.camera.translate(0, (int)(this.game.getCharacter().getSpeed()*0.02*Dimensions.Height(1)));
			this.camera.update();
			if (this.game.checkDeath()){
				this.createDeadMenu();
				this.selector = DEAD;
			}
			if (this.camera.position.y > this.game.getMapheight()-Gdx.graphics.getHeight()/2){
				this.createWinMenu();
				this.selector = WIN;
			}
		}

		else if (this.selector == LVLSCT){
			this.lvlsct.getLevel();
			this.lvlsct.draw(this.batch);
			this.camera.update();
		}

		else if (this.selector == DEAD){
			this.dmenu.draw(this.batch);
			this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
			this.camera.update();
		}

		else if (this.selector == WIN){
			this.wmenu.draw(this.batch);
			this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
			this.camera.update();
		}

		else if (this.selector == SKILLS){
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
		if (this.selector == GAME){
			if (keycode == LEFT){
				this.game.getCharacter().Left();
			}
			if (keycode == RIGHT){
				this.game.getCharacter().Right();
			}
			if (keycode == SPACE || keycode == UP){
				this.game.getCharacter().shoot();
			}
		}
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

		else if (this.selector == LVL){
			if (this.lmenu.getRunButton().click(screenX,screenY)) {
				this.selector = GAME;
				this.createGame(this.lmenu.getLvl());
			}

			else if (this.lmenu.getPanel().getSkillsbutton().click(screenX,screenY)){
				this.selector = SKILLS;
			}

			else {
				this.selector = LVLSCT;
			}
		}

		else if (this.selector == LVLSCT) {
			this.lvlsct.clickLevel(screenX, screenY);
			int lvl = this.lvlsct.getLevel();
			if (lvl > 0) {

				this.selector = LVL;
				this.createLevelMenu(lvl);
			}
			else if (this.lvlsct.getPanel().getSkillsbutton().click(screenX,screenY)){
				this.selector = SKILLS;
			}
		}
		else if (this.selector == DEAD){
			this.game.dispose();
			if (this.dmenu.getRetryButton().click(screenX,screenY)){
				this.selector = GAME;
				this.createGame(this.lvlsct.getLevel());
			}
			if (this.dmenu.getExitButton().click(screenX,screenY)){
				this.selector = LVLSCT;
			}
			if (this.dmenu.getPanel().getSkillsbutton().click(screenX,screenY)){
				this.selector = SKILLS;
			}
		}
		else if (this.selector == WIN){
			if (this.wmenu.getRetryButton().click(screenX,screenY) || this.wmenu.getExitButton().click(screenX,screenY) || this.wmenu.getPanel().getSkillsbutton().click(screenX,screenY)){
				this.account.getCharacterElements(this.game.getCharacter(), this.lvlsct.getLevel());
				this.account.addElementsStock(this.lvlsct.getLevel());
				UserConstructor.setUser(this.account.getUser(), this.account.getCristals(), this.account.getSkills(), this.account.getElements(), this.account.getStock());
				this.lvlsct.updateStock();
				this.smenu.updateStock();
				this.game.dispose();
			}
			if (this.wmenu.getRetryButton().click(screenX,screenY)){
				this.selector = GAME;
				this.createGame(this.lvlsct.getLevel());
			}
			if (this.wmenu.getExitButton().click(screenX,screenY)){
				this.selector = LVLSCT;
			}
			if (this.wmenu.getPanel().getSkillsbutton().click(screenX,screenY)){
				this.selector = SKILLS;
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
