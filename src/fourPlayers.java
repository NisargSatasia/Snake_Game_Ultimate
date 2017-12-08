import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class fourPlayers extends Actor
{
    public fourPlayers()
    {
        setImage("img/4.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer 4 ");
            LocalMultiplayer ni = new LocalMultiplayer(4);
            Mayflower.setWorld(ni);
        }
    }
}
