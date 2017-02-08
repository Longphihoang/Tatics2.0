package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;

import tatics.Account;
import tatics.Interface;
import tatics.LevelManager;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	TextureManager textures;
	Interface inter;
	tatics.Map map;

	static TextureManager textureManager=new TextureManager();
	private LevelManager manage;

	public void create () {
		inter = new Interface();
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		textures = new TextureManager();
		 manage = new LevelManager("testLevel.txt");

	}

	@Override
	public void render () {
		map = manage.getMap();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int len=0;

		batch.begin();
		for(int i=0;i<map.getLen();i++)
		{
			for(int j=0;j<map.getWidth();j++)
			{
				batch.draw(new Texture(map.getTile(j,i).getImage()),j*10,i*10);
			}
		}
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
			inter.move("left");
		}
		if(keycode== Input.Keys.DOWN)
		{
			inter.move("down");
		}
		if(keycode== Input.Keys.UP)
		{
			inter.move("up");
		}
		if(keycode== Input.Keys.RIGHT)
		{
			inter.move("right");
		}
		return false;
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
