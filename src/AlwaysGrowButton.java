import mayflower.Actor;
import java.util.*;
import mayflower.Mayflower;

public class alwaysGrowButton extends Actor
{
    private Map<String,String> skin;

    public alwaysGrowButton(Map<String,String> color)
    {
        skin = color;
        setImage("img/alwaysGrow.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            playerNum x = new playerNum();
            Mayflower.setWorld(x);
        }
    }
}
