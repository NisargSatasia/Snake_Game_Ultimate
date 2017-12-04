import mayflower.*;

public class HighScoreWorld extends World
{
    public HighScoreWorld()
    {
        setBackground("img/gameover.png");
    }

    public void act()
    {

        if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE))
        {
            System.out.println("Game Starting Over");
            Mayflower.setWorld(new SnakeWorld());
        }
    }
}