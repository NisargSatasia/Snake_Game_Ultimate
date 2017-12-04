import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class SinglePlayerModeButton extends Actor
{
    public SinglePlayerModeButton()
    {
        setImage("img/singlePlayer.png");
    }
    SnakeWorld w1 = new SnakeWorld();
    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("single player mode");
            Mayflower.setWorld(w1);
        }
    }
}
