import mayflower.Keyboard;
import mayflower.Label;
import mayflower.Mayflower;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by s581467 on 11/30/2017.
 */
public class Snake{

    private Deque<SnakeActor> segments;
    private SnakeActor snake;
    int[] keys;

    public Snake(int[] keyset){
        segments = new ArrayDeque<>();
        keys = keyset;
    }
    public void addHead(SnakeActor sa){
        segments.addFirst(sa);
    }
    public void addTail(SnakeActor st){
        segments.addLast(st);
    }

    public SnakeActor getHead(){
        return segments.getFirst();
    }

    public int size(){
        return segments.size();
    }

    public void setDirection(){
        snake = this.segments.getFirst();

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

        SnakeActor newHead = segments.removeLast();
        segments.addFirst(newHead);
        newHead.setLocation(snake.getX(), snake.getY());
        newHead.setDirection(snake.getDirection());

        newHead.move();

        if(newHead.isTouching(SnakeActor.class))
        {
            GameOver over = new GameOver();
            Mayflower.setWorld(over);
        }
    }

}
