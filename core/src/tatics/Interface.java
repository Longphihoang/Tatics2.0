package tatics;

/**
 * Created by long on 2/8/2017.
 */

public class Interface {
    int selectionX=0;
    int selectionY=0;
    Account account;
    Tile tile;
    Map map;
    LevelManager manager;
    public Interface()
    {
        Account.getAccount();
    }

    public void loadLevel(String s)
    {
        manager = new LevelManager((s));
        map = manager.getMap();

        if(s.equals("level1"))
        {
            account.addUnit(new Leo());
        }
        else if(s.equals("level2"))
        {

        }
        else if(s.equals("level3"))
        {

        }
        else if(s.equals("level4"))
        {

        }
    }


    public void move(String s) {

        if (s.equals("down")){
            selectionY=selectionY-1;
        }

        if (s.equals("up")){
            selectionY=selectionY+1;
        }

    }




}
