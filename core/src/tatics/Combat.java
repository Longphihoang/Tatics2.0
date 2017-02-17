package tatics;

import tatics.TaticsUnits.Unit;

/**
 * Created by Long on 2/16/2017.
 */

public class Combat {
    Combat(Unit a, Unit b)
    {
        int damage,range;


        damage(a,b);



        //unit a attacks b


    }
    int getDamage(int def, int attack)
    {
        int damage;

        damage = def -attack;
        if(damage<0)
        {
            damage = 0;
        }
        return damage;
    }

    void damage(Unit a, Unit b)
    {
        int range =  Math.abs(a.getX()-b.getX())+ Math.abs(a.getY()-b.getY());
        int damage;
        if(a.isAlive()&&b.isAlive()&& a.weapon.getRange()-range >=0)
        {
            damage = getDamage(b.attack,a.defense);
            a.setHp(a.getHp()-damage);
        }

    }
}
