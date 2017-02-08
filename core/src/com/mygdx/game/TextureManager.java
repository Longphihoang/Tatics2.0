package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.HashMap;

import tatics.Tile;

/**
 * Created by long on 2/2/2017.
 */

public class TextureManager {
    HashMap<String,Texture> textures;

    public TextureManager()
    {
        textures = new HashMap<String, Texture>();
    }

    public void dispose()
    {
        ArrayList<Texture> t = new ArrayList<Texture>(textures.values());

        for(int i=0;i<t.size();i++)
        {
            t.get(i).dispose();
        }
    }

    public void load(String s)
    {
        if(s.equals("game"))
        {

        }
    }

    public void put(String s, Texture texture)
    {
       textures.put(s,texture);
    }
    public void put(String s)
    {
        Texture texture = new Texture(s);
        textures.put(s,texture);
    }
    public  Texture get(String s)
    {
        return textures.get(s);
    }

    ArrayList<Texture> list()
    {
         ArrayList<Texture> t = new ArrayList<Texture>(textures.values());
        return t;
    }
}



