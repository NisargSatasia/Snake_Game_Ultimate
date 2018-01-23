import mayflower.*;
import org.lwjgl.Sys;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by s581467 on 11/30/2017.
 */
public class Snake{

    private Deque<SnakeActor> segments;
    private SnakeActor snake;
    private int[] keys;
    private SnakeWorld world;
    boolean flag;

    public Snake(){
        segments = new ArrayDeque<>();
        flag = true;
    }
    public void addHead(SnakeActor sa){
        segments.addFirst(sa);
    }
    public void addTail(SnakeActor st){
        segments.addLast(st);
    }

    public void setWorld(SnakeWorld world){
        this.world = world;
    }

    public SnakeActor getHead(){
        return segments.getFirst();
    }

    public int size(){
        return segments.size();
    }

    public Deque<SnakeActor> getSegments(){
        return segments;
    }

    public void turnUp() {
        snake = this.segments.getFirst();
        snake.setDirection(8);
    }
    public void turnDown() {
        snake = this.segments.getFirst();
        snake.setDirection(2);
    }
    public void turnLeft() {
        snake = this.segments.getFirst();
        snake.setDirection(4);
    }
    public void turnRight() {
        snake = this.segments.getFirst();
        snake.setDirection(6);
    }

    public void grow(int color){

        SnakeActor toAdd = new SnakeActor(color);
        addTail(toAdd);

        world.addObject(toAdd, getHead().getX(), getHead().getY());
    }

    public void move(){

        snake = this.getHead();

        SnakeActor newHead = segments.removeLast();
        segments.addFirst(newHead);

        newHead.setLocation(snake.getX(), snake.getY());
        newHead.setDirection(snake.getDirection());

        newHead.move();

    }


}
