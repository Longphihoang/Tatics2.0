package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/11/2017.
 */

public class Path {
    private int count = 0;
    private ArrayList<Point> points;

    public Path()
    {
        points = new ArrayList<Point>();
    }

    public Path(Path p)
    {
        points = new ArrayList<Point>(p.points);
        count = p.count;
        count++;
    }

    public void add(Point p)
    {
        points.add(p);
    }

    public int getLastX()
    {

        return (int)points.get(points.size()-1).getX();
    }

    public int getLastY()
    {

        return (int)points.get(points.size()-1).getY();
    }



    public void findPath(Path[][] paths, Point prev)
    {

    }
}
