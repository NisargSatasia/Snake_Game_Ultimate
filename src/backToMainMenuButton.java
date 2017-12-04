import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class backToMainMenuButton extends Actor
{
    public backToMainMenuButton()
    {
        setImage("img/backMain.png");

    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("Back to Main Menu");
            TitleWorld w1 = new TitleWorld();
            Mayflower.setWorld(w1);
        }
    }
}


