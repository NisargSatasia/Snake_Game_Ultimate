import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class back extends Actor
{
    public back()
    {
        setImage("img/back.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("back button clicked");
            TitleWorld w1 = new TitleWorld();
            Mayflower.setWorld(w1);
        }
    }
}
