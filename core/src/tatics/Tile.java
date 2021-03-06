package tatics;

import tatics.TaticsUnits.Unit;

/**
 * Created by long on 2/3/2017.
 */

public abstract class Tile {
    int x;
    int y;
    String image="";
    String type="";
    Unit unit=null;
    int movement = 1;
    public Tile()
    {

    }

    public Tile(int x, int y)
    {
        this.x = x;
        this.y=y;
    }
    public Tile(String type)
    {
        this.type=type;

    }

    abstract public boolean canMove(Unit u);

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
