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
    SnakeVsMiceButton svm = new SnakeVsMiceButton();
    TwitchPlaysSnakeModeButton twi = new TwitchPlaysSnakeModeButton();

    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,200,200);
        this.addObject(portals,600,400);
        this.addObject(multi, 600,200);
        this.addObject(ag, 200,400);
        this.addObject(svm, 400, 100);
        this.addObject(twi, 400, 200);

    }

    public void act()
    {


    }
}