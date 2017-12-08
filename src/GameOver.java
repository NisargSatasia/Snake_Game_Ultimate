import mayflower.*;

public class GameOver extends World
{
    public GameOver()
    {
        setBackground("img/gameover.png");
        this.addObject(b,400,500);
    }
    backToMainMenuButton b = new backToMainMenuButton();
    public void act()
    {

    }
}
