import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class threePlayers extends Actor
{
    public threePlayers()
    {
        setImage("img/3.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer 3 ");
            LocalMultiplayer ni = new LocalMultiplayer(3);
            Mayflower.setWorld(ni);
        }
    }
}
