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
            System.out.println("local multiplayer player mode");
            SnakeWorld world = new SnakeWorld();
            GameModeManager man = new StandardGameMode(2,world);
            InputManager input = new InputManager(man);
            world.setInput(input);
            Mayflower.setWorld(world);

        }
    }
}
