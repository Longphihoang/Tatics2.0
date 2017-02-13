package tatics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by long on 2/2/2017.
 */

public class PointsMap extends HashMap {

     public HashMap<String,Point> map;

    public PointsMap( int a)
    {
        map = new HashMap<String, Point>(a);
    }
    public void add(Point point)
    {
        String s= ""+point.x+""+point.y;
        map.put(s,new Point(point.x,point.y));
    }
    public void add(int x, int y)
    {
        String s= ""+x+""+y;
        map.put(s,new Point(x,y));
    }
    public ArrayList<Point> list()
    {
        ArrayList<Point> a = new ArrayList<Point>(map.values());
        return a;
    }

    void translateAll(int x,int y)
    {
        ArrayList<Point> a = list();
        for(int i = 0;i<a.size();i++)
        {
            a.get(i).translate(x,y);
        }
    }

    public void remove(int x, int y)
    {
        String s= ""+x+""+y;
        map.remove(s);
    }

    public Point get(int x, int y)
    {
        String s= ""+x+""+y;
        return map.get(s);
    }
    public HashMap<String, Point> getMap()
    {
        return map;
    }
}
