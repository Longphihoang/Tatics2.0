package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/11/2017.
 */

public class Pathfinder {
    private ArrayList<Path> paths;
    Tile tiles[][];
    public Pathfinder(Map map)
    {
        paths = new ArrayList<Path>();
        this.tiles=map.getTiles();

    }

    public ArrayList<Path>  startFind(Unit u)
    {
        paths = new ArrayList<Path>();
        System.out.println();
        findPath(u.getX(),u.getY(),u.getMove(), new Path());
        return paths;
    }

    private void findPath(int x, int y, int move, Path p)
    {
        Path p2;
        Point pt;
        if(move>0)
        {
                if (x - 1 > 0|| (x-1!=p.getLastX()&&y!=p.getLastY())) {
                    if(move-tiles[x-1][y].movement>0) {
                        pt= new Point(x-1,y);//makes new point
                        p2= new Path(p);//makes copy of path.
                        p2.add(pt);//adds point to new path
                        paths.add(p2);//adds path to list of paths
                        System.out.println("AAAAA"+x+","+y);
                        findPath(x - 1, y, move - tiles[x-1][y].movement,p2);
                    }
                }

        }
    }



}
