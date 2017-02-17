package tatics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by long on 2/5/2017.
 */

public class LevelManager {

    private FileHandle file;
    Account account;
    Map tiles;
   public LevelManager(String fileName)
    {
        account = Account.getAccount();

        String line;
        file = Gdx.files.internal(fileName);
        line=file.readString();
        String wordArray[] = line.split("\\r?\\n");

        tiles=new Map(Integer.parseInt(wordArray[0]),Integer.parseInt(wordArray[1]),fileName);

        for(int i=2;i<wordArray.length;i++)
        {
           line=wordArray[i];

            for(int j=0;j<line.length();j++)
            {
                switch(line.charAt(j))
                {
                    case 'p': tiles.add(new PlainTile(j,i-2),j,i-2);
                        break;
                    case 'w': tiles.add(new LakeTile(j,i-2),j,i-2);
                        break;
                    case 's': tiles.add(new SandTile(j,i-2),j,i-2); //-2 because file map starts at 2;
                        break;
                    case 'l': tiles.add (new LavaTile(j,i-2),j,i-2);
                        break;//lava tile -2 because filemap.txt starts at line 2
                }
            }
        }
        printMap();
    }
    public void addUnit(String fileName)
    {
        if(fileName.equals("levels\\l1.txt"))
        {
            tiles.addUnit(new Leo(),8,4);
            tiles.setLevel(1);

        }


    }

    public void printMap()
    {
        for(int i=0;i<getLen();i++)
        {
            for(int j=0;j<getWidth();j++)
            {
                System.out.print(getMap().getTile(j,i).type+" "+ j + " "+ i+ "|" );
            }
            System.out.println();
        }

    }
    public int getWidth()
    {
        return tiles.getWidth();
    }

    public int getLen()
    {
        return tiles.getLen();
    }
    public Map getMap()
    {
        return tiles;
    }
}
