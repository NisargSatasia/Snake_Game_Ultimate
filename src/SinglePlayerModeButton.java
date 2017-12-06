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
            OnePlayerSnake w1 = new OnePlayerSnake();
            Mayflower.setWorld(w1);
        }
    }
}
