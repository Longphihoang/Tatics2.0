package tatics;

/**
 * Created by long on 2/14/2017.
 */

public class LakeTile extends Tile {

    LakeTile(int x, int y)
    {
        super(x, y);

        type = "lake";
        image = "lake.png";
        movement = 1;
    }
    @Override
    public boolean canMove(Unit u) {
        if(u.isFly())
        {
            movement=1;
            return true;
        }
        if(u.isHorse())
        {
            movement=u.getMove()-1;
            return true;
        }
        return false;
    }
}
