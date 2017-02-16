package Tester;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by long on 2/12/2017.
 */

public class MapMaker {
    public MapMaker(int x, int y, String s)
    {
        try{
            PrintWriter writer = new PrintWriter(s, "UTF-8");
                writer.println(x);
            writer.println(y);
            for(int i =0; i<y;i++)
            {
                for(int j=0;j<x;j++)
                {

                    if(j<5||j>10||i>10)
                    {
                        writer.print("w");
                    }
                    else {
                        writer.print("p");
                    }
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
