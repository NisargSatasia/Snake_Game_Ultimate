import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class NumberOfPlayers extends World
{
    public NumberOfPlayers()
    {
        setBackground("img/multiplayerSelect.png");
        this.addObject(two,300,190);
        //Label x = new Label("Two Players",25);
        //this.addObject(x,130,250);
        this.addObject(three, 300,250);
       // Label y = new Label("Three Players",25);
        //this.addObject(y,330,250);
        this.addObject(four, 300,310);
       // Label z = new Label("Four Players",25);
       // this.addObject(z,530,250);
        this.addObject(a,133,450);
        this.addObject(b,313,450);
        this.addObject(c,493,450);
        this.addObject(d,320,380);
    }
    twoPlayers two = new twoPlayers();
    threePlayers three = new threePlayers();
    fourPlayers four = new fourPlayers();
    wasd a = new wasd();
    yghj b = new yghj();
    pl c = new pl();
    backToMainMenuButton d = new backToMainMenuButton();
    public void act()
    {


    }
}