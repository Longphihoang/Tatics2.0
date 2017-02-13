package tatics;

/**
 * Created by long on 2/8/2017.
 */

public class Leo extends Unit
{

    public Leo()
    {
        setName("Leo");
        hp=15;
        defense = 5;
        move = 5;
        attack = 6;
    }

    public void interact(Unit unit,String level)
    {
        if(unit.getName().equals("Chrissy")&& level.equals("1"))
        {

        }
    }

}
