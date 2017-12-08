import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class twoPlayers extends Actor
{
    public twoPlayers()
    {
        setImage("img/2.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer 2 ");
            LocalMultiplayer ni = new LocalMultiplayer(2);
            Mayflower.setWorld(ni);
        }
    }
}
