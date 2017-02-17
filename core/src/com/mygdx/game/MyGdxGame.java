package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import tatics.Interface;
import tatics.Leo;
import tatics.LevelManager;
import tatics.Path;
import tatics.Unit;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {

	SpriteBatch batch;
	TextureManager textures;
	Interface inter;
	tatics.Map map;
	private final int selectionDim =100;
	private OrthographicCamera camera;
	 float screenWid=0;
	float screenLen=0;
	float minLen;
	float minWid;
	BitmapFont font;
	final float transition=10;
	StartScreen start;
	static TextureManager textureManager=new TextureManager();
	public Options options;
	private Texture text, text2;
	public void create () {
		font = new BitmapFont();

		screenWid=Gdx.graphics.getWidth();
		screenLen=Gdx.graphics.getHeight();
		inter = new Interface();
		batch = new SpriteBatch();
		start = new StartScreen(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),batch,inter);
		options = new Options();
		//img = new Texture("badlogic.jpg");
		textures = new TextureManager();
		Gdx.input.setInputProcessor(this);
		//inter.loadLevel("testLevel.txt");
		 text = new Texture(("levels\\l1.jpg"));
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




			switch(inter.getState()){
				case 0:
					renderMenu();
					break;
				case 1:
					batch.draw(text, 0, 0);//background
					renderUnits();
					batch.draw(text2, inter.selectionX, inter.selectionY);
					updateCam();
					break;
				case 2://paths drawing
					batch.setColor(Color.DARK_GRAY);
					batch.draw(text, 0, 0);//background
					batch.setColor(Color.WHITE);
					renderPaths();
					renderUnits();
					batch.draw(text2, inter.selectionX, inter.selectionY);
					updateCam();
					break;
				case 3:
					batch.draw(text,0,0);//background
					renderUnits();
					renderOptions();
					options.render(batch,minWid,minLen,selectionDim,inter.getTile().getUnit());
					break;
			}



			font.draw(batch, "FPS:" + Gdx.graphics.getFramesPerSecond(), minWid, screenLen);
			font.draw(batch, "State: "+inter.getState(), minWid, screenLen - 25);
			font.draw(batch, "Selection:: "+inter.selectionX+","+inter.selectionY, minWid, screenLen - 50);


            if(inter.getState()!=0) {
                batch.setProjectionMatrix(camera.combined);
            }
			//batch.draw(img, 0, 0);

			batch.end();

	}

	public void renderMenu()
	{
		start.render();
	}
	public void renderPaths()
	{
		ArrayList<Path> paths = inter.getPathfinder().getPaths();
		for(int i=0;i<paths.size();i++)
		{
			//batch.setColor(Color.FOREST);
			batch.draw(text2,paths.get(i).getLastX()*selectionDim,paths.get(i).getLastY()*selectionDim);
			batch.setColor(Color.WHITE);
			System.out.println(paths.get(i).getLastX());


		}
	}

	public void renderOptions()
	{


	}


	public void renderUnits()
	{
		ArrayList<Unit> units = map.getUnits();
		for(int i=0;i<units.size();i++)
		{
			units.get(i).render(batch,units.get(i).getX()*selectionDim,units.get(i).getY()*selectionDim);
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
        switch(inter.getState())  {
            case 1:
            if (keycode == Input.Keys.LEFT) {
                inter.input("left");
            }
            if (keycode == Input.Keys.DOWN) {
                inter.input("down");
            }
            if (keycode == Input.Keys.UP) {
                inter.input("up");
            }
            if (keycode == Input.Keys.RIGHT) {
                inter.input("right");
            }
            if (keycode == Input.Keys.A) {

            }
                break;
            case 0:
                if(keycode == Input.Keys.DOWN)
                {
                    start.input("down");
                }
                if(keycode == Input.Keys.UP)
                {
                    start.input("up");
                }
                if(keycode == Input.Keys.ENTER)
                {
                    start.input("select");
                }
				break;
			case 2:
				if (keycode == Input.Keys.LEFT) {
					inter.input("left");
				}
				if (keycode == Input.Keys.DOWN) {
					inter.input("down");
				}
				if (keycode == Input.Keys.UP) {
					inter.input("up");
				}
				if (keycode == Input.Keys.RIGHT) {
					inter.input("right");
				}
				if (keycode == Input.Keys.A) {

				}
			case 3:
				if(keycode == Input.Keys.DOWN){
					options.input("down");
					break;
				}
				if(keycode == Input.Keys.UP)
				{
					options.input("up");
					break;
				}
				if(keycode==Input.Keys.A)
				{
					options.input("select");
					if(options.getSelection()==0)
					{
						inter.setState(2);
					}
				}
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
