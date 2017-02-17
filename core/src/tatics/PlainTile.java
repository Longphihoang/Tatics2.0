package tatics;

import tatics.TaticsUnits.Unit;

/**
 * Created by long on 2/14/2017.
 */

public class PlainTile extends Tile {

    PlainTile(int x, int y)
    {
        super(x, y);

        type = "plain";
        image = "plain.png";
        movement = 1;
    }

    @Override
    public boolean canMove(Unit u) {
        return true;
    }
}
