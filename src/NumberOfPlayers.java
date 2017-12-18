import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class NumberOfPlayers extends World
{
    public NumberOfPlayers()
    {
        setBackground("img/multiplayerSelect.png");
        this.addObject(two,200,200);
        this.addObject(three, 400,200);
        this.addObject(four, 600,200);
    }
    twoPlayers two = new twoPlayers();
    threePlayers three = new threePlayers();
    fourPlayers four = new fourPlayers();

    public void act()
    {


    }
}