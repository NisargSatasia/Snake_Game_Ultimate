import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class LocalMultiplayerButton extends Actor
{
    public LocalMultiplayerButton()
    {
        setImage("img/localMultiplayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer");
            LocalMultiplayer ni = new LocalMultiplayer(2);
            Mayflower.setWorld(ni);
        }
    }
}
