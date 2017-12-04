
import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class TitleWorld extends World
{
    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
    }
    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    public void act()
    {
        this.addObject(onePlayer,200,200);

    }
}
