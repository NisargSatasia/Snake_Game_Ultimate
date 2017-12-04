import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class LocalMultiplayer extends Actor
{
    public LocalMultiplayer()
    {
        setImage("img/localMultiplayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer");
            notImplemented ni = new notImplemented();
            Mayflower.setWorld(ni);
        }
    }
}
