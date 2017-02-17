package tatics.TaticsUnits;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by long on 2/8/2017.
 */

public class Leo extends Unit
{
    Texture texture;
    int count=0;
    int spriteSize; //50x50 || 100x100|| 200x|200
    public Leo()
    {
        setName("Leo");
        hp=15;
        defense = 5;
        move = 4;
        attack = 6;
        texture=new Texture("sprites\\vikingsprite100.png");
        spriteSize=100;
    }

    public void interact(Unit unit,String level)
    {
        if(unit.getName().equals("Chrissy")&& level.equals("1"))
        {

        }
    }

    @Override
    public void render(Batch batch,float x, float y) {
        batch.enableBlending();

        count+=spriteSize;
        count = count %texture.getWidth();
     batch.draw(texture,x,y,count,0,spriteSize,spriteSize);
    }
}
