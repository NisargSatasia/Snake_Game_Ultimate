import mayflower.Actor;
import java.util.*;
import mayflower.Mayflower;

public class SinglePlayerModeButton extends Actor
{
    private Map<String, String> skin;

    public SinglePlayerModeButton(Map<String, String> color)
    {
        skin = color;
        setImage("img/singlePlayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("local multiplayer player mode");
            SnakeWorld world = new SnakeWorld();
            GameModeManager man = new StandardGameMode(1,world, skin);
            InputManager input = new InputManager(man);
            world.setInput(input);
            Mayflower.setWorld(world);

        }
    }
}
