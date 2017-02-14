package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/11/2017.
 */

public class Pathfinder {
    private ArrayList<Path> paths;
    public int orgX, orgY;
    Tile tiles[][];
    public Pathfinder(Map map)
    {
        paths = new ArrayList<Path>();
        this.tiles=map.getTiles();

    }

    public ArrayList<Path>  startFind(Unit u)
    {
        paths = new ArrayList<Path>();
        orgX=u.getX();
        orgY=u.getY();
        findPath(u.getX(),u.getY(),u.getMove(), new Path(), u);
        return paths;
    }

    private void findPath(int x, int y, int move, Path p, Unit u)
    {
        Path p2;
        Point pt;


        if(move>0)
        {

            if (y - 1 > -1 ) {
                if(move-tiles[x][y-1].movement>0&& tiles[x][y-1].canMove(u)) {
                    pt= new Point(x,y-1);//makes new point
                    p2= new Path(p);//makes copy of path.
                    p2.add(pt);//adds point to new path
                    paths.add(p2);//adds path to list of paths
                    findPath(x, y-1, (move - tiles[x][y-1].movement),p2,u);
                }
            }
                if (x - 1 > -1 ) {
                    if(move-tiles[x-1][y].movement>0&& tiles[x-1][y].canMove(u)) {
                        pt= new Point(x-1,y);//makes new point
                        p2= new Path(p);//makes copy of path.
                        p2.add(pt);//adds point to new path
                        paths.add(p2);//adds path to list of paths
                        findPath(x - 1, y, (move - tiles[x-1][y].movement),p2,u);
                    }
                }
            if (x +1<tiles.length ) {
                if(move-tiles[x+1][y].movement>0&& tiles[x+1][y].canMove(u)) {
                    pt= new Point(x+1,y);//makes new point
                    p2= new Path(p);//makes copy of path.
                    p2.add(pt);//adds point to new path
                    paths.add(p2);//adds path to list of paths
                    findPath(x + 1, y, (move - tiles[x+1][y].movement),p2,u);
                }

                if (y+1<tiles[0].length ) {
                    if(move-tiles[x][y+1].movement>0&& tiles[x][y+1].canMove(u)) {
                        pt= new Point(x,y+1);//makes new point
                        p2= new Path(p);//makes copy of path.
                        p2.add(pt);//adds point to new path
                        paths.add(p2);//adds path to list of paths
                        findPath(x, y+1, (move - tiles[x][y+1].movement),p2,u);
                    }
                }
            }

        }
    }

    public String getPoints()
    {
        String s="";
        for(int i=0; i<paths.size();i++)
        {
            s=s+"X"+paths.get(i).getLastX()+"Y"+paths.get(i).getLastY()+"X";
        }
            return s;
    }
    public ArrayList<Path> getPaths(){
        return paths;
    }

}
