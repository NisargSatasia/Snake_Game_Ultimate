import mayflower.Actor;
import mayflower.Mayflower;
import org.lwjgl.openal.AL;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by s581467 on 12/6/2017.
 */
public class AlwaysGrowSnake{

    private SnakeActor snake;
    private int[] keys;
    private int color;

    public AlwaysGrowSnake(int[] keyset, SnakeActor sa, int color){
        keys = keyset;
        snake =sa;
        this.color = color;
    }

    public SnakeActor getSnake() {
        return snake;
    }

    public void setDirection(){

        //up
        if(Mayflower.isKeyPressed(keys[0])){
            snake.setDirection(8);
        }
        //down
        else if(Mayflower.isKeyPressed(keys[1])){
            snake.setDirection(2);
        }
        //left
        else if(Mayflower.isKeyPressed(keys[2])){
            snake.setDirection(4);
        }
        //right
        else if(Mayflower.isKeyPressed(keys[3])){
            snake.setDirection(6);
        }
    }

    public void move(){

        if(snake.dead()){
            return;
        }

        int lastX = snake.getX();
        int lastY = snake.getY();

        snake.move();
        snake.getWorld().addObject(new SnakeActor(color), lastX, lastY);
    }
}
