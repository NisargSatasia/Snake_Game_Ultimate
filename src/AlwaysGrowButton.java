import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class alwaysGrowButton extends Actor
{
    public alwaysGrowButton()
    {
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
