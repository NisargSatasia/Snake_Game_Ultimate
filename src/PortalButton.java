import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class PortalButton extends Actor
{
    public PortalButton()
    {
        setImage("img/singlePlayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            OnePlayerSnake w1 = new OnePlayerSnake(true);
            Mayflower.setWorld(w1);
        }
    }
}
