package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/8/2017.
 */
/*
States: 1= map state 0= menu

 */
public class Interface {
    private final int selectionDim =100;
    final float transition=10;
    public float selectionX=0;
    public float selectionY=0;
    Account account;
    Tile tile,tileMove;
    Unit selection1, selection2;
    Map map;
    LevelManager manager;
    int state;
    String move="";

    public Pathfinder getPathfinder() {
        return pathfinder;
    }

    Pathfinder pathfinder;


    public Interface()
    {
        Account.getAccount();
        state = 0;
    }


    public void loadLevel(String s)
    {

        manager = new LevelManager((s));
        map = manager.getMap();
        pathfinder = new Pathfinder(manager.getMap());

        if(s.equals("levels\\l1.txt"))
        {
            //account.addUnit(new Leo());
            map.addUnit(new Leo(),7,0);
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
         stateOneUpdate();
        }
        if(state==2)
        {
            stateTwoUpdate();
        }
    }
    private void stateOneUpdate()
    {
        if (move.equals("down")) {
            if (selectionY/selectionDim > 0) {
                selectionY = selectionY - transition;
            }
        }

        if (move.equals("up")) {
            if (selectionY/selectionDim < map.getLen() - 1) {
                selectionY = selectionY + transition;
            }
        }
        if (move.equals("right")) {
            if(selectionX/selectionDim<map.getWidth()-1) {
                selectionX += transition;
            }

        }
        if (move.equals("left")) {
            if(selectionX/selectionDim>0) {
                selectionX += -transition;
            }
        }
    }
    private void stateTwoUpdate()
    {
        if (move.equals("down")) {
            if (selectionY/selectionDim > 0) {
                selectionY = selectionY - transition;
            }
        }

        if (move.equals("up")) {
            if (selectionY/selectionDim < map.getLen() - 1) {
                selectionY = selectionY + transition;
            }
        }
        if (move.equals("right")) {
            if(selectionX/selectionDim<map.getWidth()-1) {
                selectionX += transition;
            }

        }
        if (move.equals("left")) {
            if(selectionX/selectionDim>0) {
                selectionX += -transition;
            }
        }
    }
    public void input(String s) {
        if(state==1) {
            stateOneInput(s);
        }
        if(state ==2)
        {
            stateTwoInput(s);
        }
    }
    public void stateOneInput(String s)
    {
        if(s.equals(""))
        {
            move="";
            snapSelection();
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
         if(s.equals("left")) {
            move="left";
        }
        if(s.equals("select"))
        {
                if(map.getTiles()[convertPixtoIndex(selectionX)][convertPixtoIndex(selectionY)].getUnit()!=null)
             {
                state = 3;
                tile = map.getTiles()[convertPixtoIndex(selectionX)][convertPixtoIndex(selectionY)];
            }
        }
    }

    public void stateTwoInput(String s)
    {
        int movement;
        selection1=tile.getUnit();
        movement = selection1.getMove();
        if(s.equals(""))
        {
            move="";
            snapSelection();
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
        if(s.equals("select")) {
            ArrayList<Path> paths = pathfinder.startFind(tile.getUnit());
            if (convertPixtoIndex(selectionX) == pathfinder.orgX && convertPixtoIndex(selectionY) == pathfinder.orgY) {

            }
            else {
                for (int i = 0; i < paths.size(); i++) {
                    if (convertPixtoIndex(selectionX) == paths.get(i).getLastX() && convertPixtoIndex(selectionY) == paths.get(i).getLastY()) {
                        selection1.move(map.getTile(convertPixtoIndex(selectionX), convertPixtoIndex(selectionY)));
                        state = 1;
                    }
                }
            }
        }
    }

public int convertPixtoIndex(float input)
{
    int index;

    index = (int)input;
    index=index/selectionDim;
    return index;
}
    public void snapSelection(){

        selectionX=convertPixtoIndex(selectionX)*selectionDim;
        selectionY=convertPixtoIndex(selectionY)*selectionDim;
/*
        if(selectionX%50<25)
        {
            selectionX= selectionX+25-((selectionX+25)%50);
        }
        else
        {
            selectionX= selectionX-25-((selectionX-25)%50);
        }
*/
    }
 public int getState()
 {
     return state;
 }

    public void moveUnit(int x, int y)
    {
        selectionX=convertPixtoIndex(selectionX)*selectionDim;
        selectionY=convertPixtoIndex(selectionY)*selectionDim;

        //solve this snap selection to the nearest +50 position
        /*
        Unit unit= map.getTiles()[x][y].getUnit();
        state = 2; //move state;
        if(unit!=null)
        {

        }
        */

    }
    public Map getMap()
    {
        return map;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Tile getTile() {
        return tile;
    }
}

