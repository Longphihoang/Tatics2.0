package tatics;

import tatics.TaticsUnits.Unit;

/**
 * Created by long on 2/14/2017.
 */

public class MountainTile extends Tile {

    MountainTile(int x, int y)
    {
        super(x, y);

        type = "mountain";
        image = "mountain.png";
        movement = 1;
    }
    @Override
    public boolean canMove(Unit u) {
        if(u.isFly())
        {
            return true;
        }
        return false;
    }


}
