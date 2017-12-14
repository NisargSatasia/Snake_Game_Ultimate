import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Label;
import mayflower.Mayflower;
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
    boolean flag;
    private int[] keys2;
    private int[] keys3;
    private int[] keys4;
    private int multiplayer = 1;


    /*public Snake(int[] keyset){
        segments = new ArrayDeque<>();
        keys = keyset;
        flag = true;

    }*/
    int[][] allkeys = new int[4][4];

    int[] keyset = {Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT};
    int[] keyset2 = {Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D};
    int[] keyset3 = {Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J};
    int[] keysset4 = {Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE};

    allkeys[0] = keys1;
    allkeys[1] = keys2;
    allkeys[2] = keys3;
    allkeys[3] = keys4;

    public Snake(int numofplayers){
        if(numofplayers == 1){
            segments = new ArrayDeque<>();
            keys = keyset;

        }else if(numofplayers == 2){

        }else if(numofplayers == 3){

        }else if(numofplayers == 4){

        }
    }
    public Snake(int[] keyset1, int[] keyset2){

        segments = new ArrayDeque<>();
        keys = keyset1;
        keys2 = keyset2;
        multiplayer = 2;

    }
    public Snake(int[] keyset1, int[] keyset2, int[] keyset3){

        segments = new ArrayDeque<>();
        keys = keyset1;
        keys2 = keyset2;
        keys3 = keyset3;
        multiplayer = 3;
    }
    public Snake(int[] keyset1, int[] keyset2, int[] keyset3, int[] keyset4){

        segments = new ArrayDeque<>();
        keys = keyset1;
        keys2 = keyset2;
        keys3 = keyset3;
        keys4 = keyset4;
        multiplayer = 4;
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

    public Deque<SnakeActor> getSegments(){
        return segments;
    }

    public void setDirection(){
        snake = this.segments.getFirst();

        if(multiplayer == 1){
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
        }else if(multiplayer == 2){
            //up
            if(Mayflower.isKeyPressed(keys[0]) && Mayflower.isKeyPressed(keys2[0])){
                snake.setDirection(8);
            }
            //down
            else if(Mayflower.isKeyPressed(keys[1]) && Mayflower.isKeyPressed(keys2[1])){
                snake.setDirection(2);
            }
            //left
            else if(Mayflower.isKeyPressed(keys[2]) && Mayflower.isKeyPressed(keys2[2])){
                snake.setDirection(4);
            }
            //right
            else if(Mayflower.isKeyPressed(keys[3]) && Mayflower.isKeyPressed(keys2[3])){
                snake.setDirection(6);
            }
        }else if(multiplayer == 3){
            //up
            if(Mayflower.isKeyPressed(keys[0]) && Mayflower.isKeyPressed(keys2[0]) && Mayflower.isKeyPressed(keys3[0])){
                snake.setDirection(8);
            }
            //down
            else if(Mayflower.isKeyPressed(keys[1]) && Mayflower.isKeyPressed(keys2[1]) && Mayflower.isKeyPressed(keys3[1])){
                snake.setDirection(2);
            }
            //left
            else if(Mayflower.isKeyPressed(keys[2]) && Mayflower.isKeyPressed(keys2[2]) && Mayflower.isKeyPressed(keys3[2])){
                snake.setDirection(4);
            }
            //right
            else if(Mayflower.isKeyPressed(keys[3]) && Mayflower.isKeyPressed(keys2[3]) && Mayflower.isKeyPressed(keys3[3])){
                snake.setDirection(6);
            }
        }else if(multiplayer == 4){
            //up
            if(Mayflower.isKeyPressed(keys[0]) && Mayflower.isKeyPressed(keys2[0]) && Mayflower.isKeyPressed(keys3[0]) && Mayflower.isKeyPressed(keys4[0])){
                snake.setDirection(8);
            }
            //down
            else if(Mayflower.isKeyPressed(keys[1]) && Mayflower.isKeyPressed(keys2[1]) && Mayflower.isKeyPressed(keys3[1]) && Mayflower.isKeyPressed(keys4[1])){
                snake.setDirection(2);
            }
            //left
            else if(Mayflower.isKeyPressed(keys[2]) && Mayflower.isKeyPressed(keys2[2]) && Mayflower.isKeyPressed(keys3[2]) && Mayflower.isKeyPressed(keys4[2])){
                snake.setDirection(4);
            }
            //right
            else if(Mayflower.isKeyPressed(keys[3]) && Mayflower.isKeyPressed(keys2[3]) && Mayflower.isKeyPressed(keys3[3]) && Mayflower.isKeyPressed(keys4[3])){
                snake.setDirection(6);
            }
        }
    }

    public void move(){


        if(segments.getFirst().isTouching(Portal.class)&&flag){
            Portal portal = segments.getFirst().getOneIntersectingObject(Portal.class);
            Portal link = portal.getLink();

            SnakeActor newHead = segments.removeLast();
            segments.addFirst(newHead);

            newHead.setLocation(link.getX(), link.getY());
            newHead.setDirection(snake.getDirection());

            flag = false;
            return;
        }

        SnakeActor newHead = segments.removeLast();
        segments.addFirst(newHead);

        newHead.setLocation(snake.getX(), snake.getY());
        newHead.setDirection(snake.getDirection());

        newHead.move();

        flag = true;

    }


}
