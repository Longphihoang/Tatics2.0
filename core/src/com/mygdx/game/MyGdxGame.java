package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import tatics.Interface;
import tatics.LevelManager;
import tatics.Path;
import tatics.Unit;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	TextureManager textures;
	Interface inter;
	Interface i;
	tatics.Map map;

	private final int selectionDim =50;
	private static final float MIN_FRAME_LENGTH = 1f/60f;
	private float timeSinceLastRender;
	private OrthographicCamera camera;
	 float screenWid=0;
	float screenLen=0;
	float minLen;
	float minWid;
	BitmapFont font;
	final float transition=10;
	static TextureManager textureManager=new TextureManager();
	private Texture text, text2;
	public void create () {
		font = new BitmapFont();
		screenWid=Gdx.graphics.getWidth();
		screenLen=Gdx.graphics.getHeight();
		inter = new Interface();
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		textures = new TextureManager();
		Gdx.input.setInputProcessor(this);
		inter.loadLevel("testLevel.txt");
		 text = new Texture(("image.png"));
		text2 = new Texture("selection.png");
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.translate(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
	}

	@Override
	public void render () {

			//camera.position.set(Gdx.graphics.getWidth()/2+inter.selectionX,Gdx.graphics.getHeight()/2+inter.selectionY,0);
			map = inter.getMap();
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			int len = 0;
			batch.enableBlending();
			batch.begin();
			inter.update();
			updateCam();

			batch.draw(text, 0, 0);//background
			batch.draw(text2, inter.selectionX, inter.selectionY);
			renderUnits();
			switch(inter.getState()){
				case 2:
					renderPaths();
					break;
			}
			font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), inter.selectionX, inter.selectionY);
			font.draw(batch, "State: "+inter.getState(), inter.selectionX, inter.selectionY - selectionDim);


			batch.setProjectionMatrix(camera.combined);
			//batch.draw(img, 0, 0);

			batch.end();

	}
	public void renderPaths()
	{
		ArrayList<Path> paths = inter.getPathfinder().getPaths();
		System.out.println(paths.size()+" THE SIZE IS");
		for(int i=0;i<paths.size();i++)
		{
			batch.draw(text2,paths.get(i).getLastX()*selectionDim,paths.get(i).getLastY()*selectionDim);
		}
	}
	public void renderUnits()
	{
		ArrayList<Unit> units = map.getUnits();
		for(int i=0;i<units.size();i++)
		{
			batch.draw(text2,units.get(i).getX()*selectionDim,units.get(i).getY()*selectionDim);
		}

	}
	public void updateCam()
	{
		//camera translate logic
		if(inter.selectionX>screenWid-selectionDim)
		{
			minWid+=transition;
			screenWid=screenWid+transition;
			camera.translate(transition,0);

		}
		if(inter.selectionX<minWid)
		{
			minWid-=transition;
			screenWid=screenWid-transition;
			camera.translate(-transition,0);
		}
		if(inter.selectionY>screenLen-selectionDim)
		{
			screenLen=screenLen+transition;
			minLen+=transition;
			camera.translate(0,transition);
		}
		if(inter.selectionY<minLen)
		{
			minLen-=transition;
			screenLen=screenLen-transition;
			camera.translate(0,-transition);
		}
		camera.update();
		//camera translate logic
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
		if(keycode== Input.Keys.A)
		{

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
		if(keycode ==Input.Keys.A)
		{
			inter.input("select");
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
	public boolean mouseMoved(int screenX, int screenY)
	{
		inter.selectionX=screenX;
		inter.selectionY=screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
