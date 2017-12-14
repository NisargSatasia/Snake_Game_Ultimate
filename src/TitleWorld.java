import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class TitleWorld extends World
{

    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    PortalButton portals = new PortalButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();
    AlwaysGrowButton ag = new AlwaysGrowButton();

    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,200,200);
        this.addObject(portals,600,400);
        this.addObject(multi, 600,200);
        this.addObject(ag, 200,400);
        this.addObject(tw, 600,400);

    }
<<<<<<< HEAD
=======
    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();
    AlwaysGrowButton ag = new AlwaysGrowButton();
    TwitchPlaysSnakeModeButton tw = new TwitchPlaysSnakeModeButton();
>>>>>>> 68af76ac30d5191cc5ef1ac9f7e4da4bae1f8a94

    public void act()
    {


    }
}