package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import tatics.TaticsUnits.Unit;

/**
 * Created by long on 2/16/2017.
 */

public class Options {
    int selection=0;
    SpriteBatch batch;
    BitmapFont font100,font50,font20;

    public Options()
    {
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
    }

    public void render(Batch b, float x, float y, int selectDim, Unit u)
    {
        if(u.isMoved()) {
            font50.setColor(Color.GOLD);
        }

        font50.draw(b, "Move", x + selectDim / 2, y + 5 * selectDim);

        font50.setColor(Color.WHITE);
        if(u.isAttacked())
        {
            font50.setColor(Color.GOLD);
        }
        font50.draw(b,"Attack",x+selectDim/2,y+4*selectDim);
        font50.setColor(Color.WHITE);



        font50.draw(b,"Interact",x+selectDim/2,y+2*selectDim);
        font50.draw(b,"Stat",x+selectDim/2,y+3*selectDim);
        font50.draw(b,"cancel",x+selectDim/2,y+1*selectDim);
        font50.draw(b,""+selection,x+selectDim/2,y+6*selectDim);

        switch(selection)
        {
            case 0:
                font50.draw(b,"->",x,y+5*selectDim);
                break;
            case 1:
                font50.draw(b,">",x,y+4*selectDim);
                break;
            case 2:
                font50.draw(b,">",x,y+3*selectDim);
                break;
            case 3:
                font50.draw(b,">",x,y+2*selectDim);
                break;
            case 4:
                font50.draw(b,">",0,y+1*selectDim);
                break;
        }
    }

    public void input(String s)
    {
       if(s.equals("up"))
        {
           selection= selection-1;
           if(selection<0)
           {
               selection =4;
           }
        }
        if(s.equals("down"))
        {
            selection++;
            selection = selection%5;
        }
        if(s.equals("select"))
        {

        }

    }

    public int getSelection()
    {
        return selection;
    }

}
