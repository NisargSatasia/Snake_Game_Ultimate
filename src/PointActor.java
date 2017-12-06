import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;

public class PointActor extends Actor
{
    private int row;
    private int column;
    World curWorld;
    public PointActor()
    {
        setImage("img/point.png");
        row = (int) Math.floor(Math.random() * 38)+1;
        column = (int) Math.floor(Math.random() * 28)+1;
    }
    public boolean isTouchingAnthing() {
        return this.isTouching(Actor.class);
    }
    public void act()
    {


    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return column;
    }
}
