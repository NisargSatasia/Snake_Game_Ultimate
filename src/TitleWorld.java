import mayflower.*;
import java.util.*;

public class TitleWorld extends World
{
    private Map<String, String> skin;

    SinglePlayerModeButton onePlayer;
    LocalMultiplayerButton multi;
    alwaysGrowButton ag;
    TwitchPlaysSnakeModeButton twi;

    public TitleWorld(String color)
    {
        skin = new HashMap<String, String>();
        skin.put();
        onePlayer = new SinglePlayerModeButton(skin);
        multi = new LocalMultiplayerButton(skin);
        ag = new alwaysGrowButton(skin);
        twi = new TwitchPlaysSnakeModeButton(skin);

        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,300,105);
        this.addObject(multi, 300,165);
        this.addObject(ag, 300,225);
        this.addObject(twi, 300, 285);

    }

    public void act()
    {


    }
}