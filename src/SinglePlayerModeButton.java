import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class SinglePlayerModeButton extends Actor
{
    public SinglePlayerModeButton()
    {
        setImage("img/singlePlayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer player mode");
            SnakeWorld w1 = new SnakeWorld();
            Mayflower.setWorld(w1);
        }
    }
}
