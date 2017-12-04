
import mayflower.*;

public class Runner extends Mayflower
{
    public Runner(){
        super("Snake Game", 800, 600);
    }

    public void init()
    {
        //Mayflower.setFullScreen(true);

        World startingWorld = new TitleWorld();
        Mayflower.setWorld(startingWorld);
    }

    public static void main(String[] args){
        new Runner();
    }
}