package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/7/2017.
 */

public class Account {

    static Account account;
    static ArrayList<Unit> roaster;
    static ArrayList<Item> inventory;

    private Account()
    {
        roaster = new ArrayList<Unit>();
    }

    public static Account getAccount()
    {
        if(account ==null)
        {
            account = new Account();
        }
        return account;
    }

    public  void addUnit(Unit unit)
    {
        roaster.add(unit);
    }

    public void removeUnit()
    {

    }

    public void AddItem(Item item)
    {

    }

    public void removeItem(Item item)
    {

    }



}
