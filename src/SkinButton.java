import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class SkinButton extends Actor
{
    public SkinButton()
    {
        setImage("img/skinbutton.png");
    }

    public void act()
    {
        if(Mayflower.mouseClicked(this))
        {
            System.out.println("Skin button pressed");
            //Skin w1 = new Skin(4, 1);
            //Mayflower.setWorld(w1);
        }
    }
}