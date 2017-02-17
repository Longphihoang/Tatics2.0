package tatics;

import tatics.TaticsUnits.Unit;

/**
 * Created by long on 2/5/2017.
 */

public class SandTile extends Tile {

    SandTile()
    {
        type = "sand";
        image = "sand.png";
        movement = 1;
    }
    SandTile(int x, int y)
    {
        super(x, y);

        type = "sand";
        image = "sand.png";
        movement = 1;
    }

    // types of units can cross sand tiles
    public boolean canMove(Unit u)
    {
        return true;
    }
}
