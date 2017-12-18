import mayflower.*;

public class GameOver extends World
{
    backToMainMenuButton b = new backToMainMenuButton();

    public GameOver()
    {
        setBackground("img/gameover.png");
        this.addObject(b,400,500);
    }

    public GameOver(int color){
        String winner;
        switch(color){
            case 1: winner = "Yellow"; break;
            case 2: winner = "Green"; break;
            case 3: winner = "Blue"; break;
            case 4: winner = "White"; break;
            default: winner = "nobody";
        }

        this.addObject(new Label(winner+" wins!"), this.getWidth()/2, this.getHeight()/2);
        this.addObject(b,400,500);

    }
    public void act()
    {

    }
}
