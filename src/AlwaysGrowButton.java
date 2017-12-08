import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class AlwaysGrowButton extends Actor
{
    public AlwaysGrowButton()
    {
        setImage("img/alwaysGrow.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("Always Grow Mode");
            AlwaysGrow a = new AlwaysGrow(2);
            Mayflower.setWorld(a);
        }
    }
}
