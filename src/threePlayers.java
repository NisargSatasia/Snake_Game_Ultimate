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
            System.out.println("local multiplayer player mode");
            SnakeWorld world = new SnakeWorld();
            GameModeManager man = new StandardGameMode(3,world);
            InputManager input = new InputManager(man);
            world.setInput(input);
            Mayflower.setWorld(world);

        }
    }
}
