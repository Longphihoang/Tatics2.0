package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/3/2017.
 */

public class Map {

    private Tile[][] tiles;
    private String name;
    private ArrayList<Unit> units;

    Map(int x, int y, String s)
    {
        tiles = new Tile[x][y];
        name = s;
        units = new ArrayList<Unit>();
    }
    public Tile[][] getTiles()
    {
        return tiles;
    }
    public void add(Tile tile,int i,int j)
    {
        tiles[i][j]=tile;
    }

    public void addUnit(Unit u,int x, int y)
    {
        u.move(getTile(x,y));
        u.setX(x);
        u.setY(y);
        units.add(u);



    }

    public ArrayList<Unit> getUnits()
    {
        return units;
    }

    public int getWidth()
    {
        return tiles.length;
    }

    public int getLen()
    {
        return tiles[0].length;
    }

    public Tile getTile(int x, int y)
    {
        return tiles[x][y];
    }

    


}
