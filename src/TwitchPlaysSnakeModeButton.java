import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class TwitchPlaysSnakeModeButton extends Actor{

    public TwitchPlaysSnakeModeButton()
    {
        setImage("img/twitchplayer.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("twitch plays snake mode button is pressed");
            NumberOfPlayers ni = new NumberOfPlayers();
            Mayflower.setWorld(ni);
        }
    }

}