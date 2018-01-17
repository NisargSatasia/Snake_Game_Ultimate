import mayflower.*;


public class NumofPlayer extends World
{
    private int ret;
    public NumofPlayer()
    {
        setBackground("img/multiplayerSelect.png");
        this.addObject(two,200,200);
        this.addObject(three, 400,200);
        this.addObject(four, 600,200);
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


    public void act()
    {
        System.out.println("twitch plays snake mode button is pressed");
        int num = playerCount();
        if(num > 0){
            TwitchPlaysSnakeMode tw = new TwitchPlaysSnakeMode(num);
            Mayflower.setWorld(tw);

        }

    }
}