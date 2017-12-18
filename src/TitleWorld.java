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
<<<<<<< HEAD
       */
=======
    SnakeVsMiceButton svm = new SnakeVsMiceButton();
>>>>>>> 2a48706ada7a0514c7f107297a1e0b9843b667a4

    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,200,200);
        this.addObject(portals,400,500);
        this.addObject(multi, 600,200);
        this.addObject(ag, 200,400);
        this.addObject(svm, 400, 100);

    }
<<<<<<< HEAD

    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();
    AlwaysGrowButton ag = new AlwaysGrowButton();
    PortalButton portals = new PortalButton();
    TwitchPlaysSnakeModeButton tw = new TwitchPlaysSnakeModeButton();
=======
>>>>>>> 2a48706ada7a0514c7f107297a1e0b9843b667a4

    public void act()
    {


    }
}