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
            System.out.println("local multiplayer player mode");
            SnakeWorld world = new SnakeWorld();
            GameModeManager man = new StandardGameMode(4,world);
            InputManager input = new InputManager(man);
            world.setInput(input);
            Mayflower.setWorld(world);

        }
    }
}
