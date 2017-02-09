package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tatics.Interface;
import tatics.LevelManager;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	TextureManager textures;
	Interface inter;
	tatics.Map map;
	private OrthographicCamera camera;
	 float screenWid=0;
	float screenLen=0;
	float minLen;
	float minWid;
	BitmapFont font;
	static TextureManager textureManager=new TextureManager();
	private LevelManager manage;
	private Texture text, text2;
	public void create () {
		font = new BitmapFont();
		screenWid=Gdx.graphics.getWidth();
		screenLen=Gdx.graphics.getHeight();
		inter = new Interface();
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		textures = new TextureManager();
		 manage = new LevelManager("testLevel.txt");
		Gdx.input.setInputProcessor(this);
		inter.loadLevel("testLevel.txt");
		 text = new Texture(("image.png"));
		text2 = new Texture("selection.png");
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.translate(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
	}

	@Override
	public void render () {
		inter.update();
		//camera.position.set(Gdx.graphics.getWidth()/2+inter.selectionX,Gdx.graphics.getHeight()/2+inter.selectionY,0);
		camera.update();
		map = manage.getMap();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int len=0;

		batch.begin();
		batch.draw(text,0,0);
		//batch.draw(text2,inter.selectionX,inter.selectionY);
		font.draw(batch,""+inter.selectionX+","+inter.selectionY,inter.selectionX,inter.selectionY);
		font.draw(batch,""+screenWid+","+screenLen,inter.selectionX,inter.selectionY-50);

		if(inter.selectionX>screenWid)
		{
			screenWid=screenWid+5;
			camera.position.set(Gdx.graphics.getWidth()/2+5,Gdx.graphics.getHeight()/2,0);

		}
		if(inter.selectionY>screenLen)
		{
			screenLen=screenLen+5;
		}
		batch.setProjectionMatrix(camera.combined);
		//batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		textures.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode== Input.Keys.LEFT)
		{
			inter.input("left");
		}
		if(keycode== Input.Keys.DOWN)
		{
			inter.input("down");
		}
		if(keycode== Input.Keys.UP)
		{
			inter.input("up");
		}
		if(keycode== Input.Keys.RIGHT)
		{
			inter.input("right");
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		if(keycode== Input.Keys.LEFT)
		{
			inter.input("");
		}
		if(keycode== Input.Keys.DOWN)
		{
			inter.input("");
		}
		if(keycode== Input.Keys.UP)
		{
			inter.input("");
		}
		if(keycode== Input.Keys.RIGHT)
		{
			inter.input("");
		}
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
