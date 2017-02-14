package tatics;

/**
 * Created by long on 2/14/2017.
 */

public class LavaTile extends Tile {

    public LavaTile(int x, int y)
    {
        super(x, y);
        type = "lava";
        image = "lava.png";
        movement = 0;

    }
    @Override
    public boolean canMove(Unit u) {
        return false;
    }

}
