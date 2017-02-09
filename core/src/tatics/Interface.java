package tatics;

/**
 * Created by long on 2/8/2017.
 */
/*
States: 1= map state 0= menu

 */
public class Interface {
    public float selectionX=0;
    public float selectionY=0;
    Account account;
    Tile tile;
    Map map;
    LevelManager manager;
    int state=1;
    String move="";

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


    public void update(){
        if(state==1) {
            if (move.equals("down")) {
                if (selectionY != 0) {
                    selectionY = selectionY - 5;
                }
            }

            if (move.equals("up")) {
                if (selectionY != map.getLen() - 1) {
                    selectionY = selectionY + 5;
                }
            }
            if (move.equals("right")) {
                if(selectionX!=map.getWidth()-1) {
                    selectionX += 5;
                }

            }
            if (move.equals("left")) {
                if(selectionX!=0) {
                    selectionX += -5;
                }
            }
        }
    }

    public void input(String s) {
        if(state==1) {
            if(s.equals(""))
            {
                move="";
            }
            if (s.equals("down")) {
                move="down";
            }

            if (s.equals("up")) {
               move="up";
            }
            if (s.equals("right")) {
                move="right";

            }
            if (s.equals("left")) {
              move="left";
            }
        }
    }


 public int getState()
 {
     return state;
 }


}
