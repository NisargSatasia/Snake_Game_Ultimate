import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class TitleWorld extends World
{

    SinglePlayerModeButton onePlayer = new SinglePlayerModeButton();
    //PortalButton portals = new PortalButton();
    LocalMultiplayerButton multi = new LocalMultiplayerButton();
    AlwaysGrowButton ag = new AlwaysGrowButton();
   // SnakeVsMiceButton svm = new SnakeVsMiceButton();
    TwitchPlaysSnakeModeButton twi = new TwitchPlaysSnakeModeButton();

    public TitleWorld()
    {
        setBackground("img/TitleScreen.png");
        this.addObject(onePlayer,300,105);
        //this.addObject(portals,300,165);
        this.addObject(multi, 300,165);
        this.addObject(ag, 300,225);
        //this.addObject(svm, 300, 345);
        this.addObject(twi, 300, 285);

    }

    public void act()
    {


    }
}