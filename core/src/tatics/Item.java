package tatics;

import tatics.TaticsUnits.Unit;

/**
 * Created by long on 2/7/2017.
 */

public class Item {
    private  String name;
    private int range;
    void use(Unit unit)
    {

    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
