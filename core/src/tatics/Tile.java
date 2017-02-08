package tatics;

/**
 * Created by long on 2/3/2017.
 */

public class Tile {
    String image="";
    String type="";
    Unit unit=null;
    int movement = 0;
    public Tile()
    {

    }


    public Tile(String type)
    {
        this.type=type;

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
