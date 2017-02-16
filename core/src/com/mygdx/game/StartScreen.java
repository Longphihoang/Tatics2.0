package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.*;

import tatics.Interface;

/**
 * Created by long on 2/13/2017.
 */

public class StartScreen extends Sprite {
    int x;
    int y;
    int selection=1;
    String newGame= "New Game";
    String loadLevel = "Load Save";
    SpriteBatch batch;
    BitmapFont font100,font50,font20;
    BitmapFont shadow;
    int state;
    Interface inter;

    public StartScreen(int x, int y, SpriteBatch batch, Interface inter)
    {
        this.inter = inter;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/neuropol x rg.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        font100 = generator.generateFont(parameter); // font size 12 pixels
        font100.setColor(Color.WHITE);
        parameter.size = 40;
        font50 = generator.generateFont(parameter);
        parameter.size=20;
        font20=generator.generateFont(parameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
          // font size 12 pixels
        //generator.dispose(); // don't forget to dispose to avoid memory leaks!
        this.x=x;
        this.y=y;
        this.batch=batch;
        state=1;
    }

    public void render()
    {
        //shadow.draw(batch,"Tatics",-x/5,y/3);
        if(state==1) {
            font50.setColor(Color.WHITE);
            font100.draw(batch, "Tatics", x / 4, y - y / 5);

            System.out.println(y);
            if(selection ==0)
            {
                font50.draw(batch, "->New Game<-", x / 3, y / 5);
                font50.draw(batch, "Continue", x / 3, 2 * y / 5);

            }
            else
            if(selection==1)
            {
                font50.draw(batch, "New Game", x / 3, y / 5);
                font50.draw(batch, "->Continue<-", x / 3, 2 * y / 5);

            }
        }
        else
            if(state ==2)
            {

            }
    }

    public void input(String s)
    {
        if(s.equals("down"))
        {
            selection++;
            selection = Math.abs(selection)%2;
        }

        if(s.equals("up"))
        {
            selection--;
            selection = Math.abs(selection)%2;
        }
        if(s.equals("select"))
        {
            if(selection==0)
            {
                inter.loadLevel("levels\\l1.txt");
                inter.setState(1);
            }
            if(selection==1)
            {

            }
        }

    }
    

}
