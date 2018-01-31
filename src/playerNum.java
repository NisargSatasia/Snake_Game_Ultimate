import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class playerNum extends World
{
    int ret = 0;
    public playerNum()
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
    public int playerCount(){
        ret = 0;
        if(Mayflower.mouseClicked(two)){
            ret = 2;
        }else if(Mayflower.mouseClicked(three)){
            ret = 3;
        }else if(Mayflower.mouseClicked(four)){
            ret = 4;
        }
        return ret;
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
        int num = playerCount();
        if(num > 0)
        {
            System.out.println("local multiplayer player mode");
            SnakeWorld world = new SnakeWorld();
            GameModeManager man = new AlwaysGrowMode(num,world);
            InputManager input = new InputManager(man);
            world.setInput(input);
            Mayflower.setWorld(world);
        }
    }
}