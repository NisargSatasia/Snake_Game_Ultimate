import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import mayflower.*;
import mayflower.Color;
import mayflower.Label;

public class singlePlayerHighScore extends OnePlayerSnake
{
    public singlePlayerHighScore()
    {

        //int finalScore = 0;
        super ();
        this.setBackground("img/bwBackground.png");
        int finalScore = this.getHS();

        System.out.println(finalScore);

    }

    @Override
    public void act()
    {

    }
}
