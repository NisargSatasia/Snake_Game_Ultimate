import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class TitleWorld extends World
{

    /*
    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    PortalButton portals = new PortalButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();
    AlwaysGrowButton ag = new AlwaysGrowButton();
       */

    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,200,200);
        this.addObject(portals,400,500);
        this.addObject(multi, 600,200);
        this.addObject(ag, 200,400);
        this.addObject(tw, 600,400);

    }

    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();
    AlwaysGrowButton ag = new AlwaysGrowButton();
    PortalButton portals = new PortalButton();
    TwitchPlaysSnakeModeButton tw = new TwitchPlaysSnakeModeButton();

    public void act()
    {


    }
}