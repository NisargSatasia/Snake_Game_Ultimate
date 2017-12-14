import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class SnakeVsMiceButton extends Actor
{
    public SnakeVsMiceButton()
    {
        setImage("img/localMultiplayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer select screen");
            SnakeVsMice w1 = new SnakeVsMice(4, 1);
            Mayflower.setWorld(w1);
        }
    }
}