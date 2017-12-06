import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class TitleWorld extends World
{
    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,200,200);
        this.addObject(multi, 600,200);
    }
    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();

    public void act()
    {


    }
}