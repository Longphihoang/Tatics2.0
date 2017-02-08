package tatics;

/**
 * Created by long on 2/3/2017.
 */

public class Map {

    private Tile[][] tiles;
    private String name;
     Map(int x, int y, String s)
    {
        tiles = new Tile[x][y]; name = s;
    }

    public void add(Tile tile,int i,int j)
    {
        tiles[i][j]=tile;
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
