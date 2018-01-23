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
            SnakeWorld world = new SnakeWorld();
            GameModeManager man = new StandardGameMode(1,world);
            InputManager input = new InputManager(man);
            world.setInput(input);
            Mayflower.setWorld(world);

        }
    }
}
