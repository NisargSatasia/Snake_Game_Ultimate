import mayflower.*;


public class NumofPlayer extends World
{
    private int ret;
    public NumofPlayer()
    {
        setBackground("img/multiplayerSelect.png");
        this.addObject(two,300,190);
        this.addObject(three, 300,250);
        this.addObject(four, 300,310);
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
        //System.out.println("twitch plays snake mode button is pressed");
        int num = playerCount();
        if(num > 0){
            TwitchPlaysSnakeMode tw = new TwitchPlaysSnakeMode(num);
            Mayflower.setWorld(tw);

        }

    }
}