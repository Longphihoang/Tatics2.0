package tatics;

/**
 * Created by long on 2/5/2017.
 */

public class SandTile extends Tile {

    SandTile()
    {
        type = "sand";
        image = "sand.png";
        movement = 2;
    }
    SandTile(int x, int y)
    {
        super(x, y);

        type = "sand";
        image = "sand.png";
        movement = -1;
    }
}
