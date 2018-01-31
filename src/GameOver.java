import mayflower.*;

public class GameOver extends World
{
    public GameOver()
    {
        setBackground("img/GOscreen.png");
    }
    backToMainMenuButton d = new backToMainMenuButton();

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

    }
    public void act()
    {
        this.addObject(d,320,380);
    }
}
