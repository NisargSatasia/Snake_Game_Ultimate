import mayflower.*;
import mayflower.Actor;
import mayflower.Color;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.Label;
import mayflower.Timer;

import java.awt.*;
import java.util.ArrayList;
//import java.awt.Label;

/**
 * Created by s581467 on 11/7/2017.
 */
public class SnakeActor extends Actor {

    private int dir; // 8 is up, 2 is down , 4 is left, 6 is right
    private int curScore;
    private ArrayList<Integer> xcoord, ycoord;
    private int color;

    public SnakeActor(int color) {
        this.color = color;
        switch(color){
            case 1: setImage("img/snakeYellow.png");break;
            case 2: setImage("img/snakeGreen.png");break;
            case 3: setImage("img/snakeBlue.png");break;
            case 4: setImage("img/snakeWhite.png");break;
        }
        curScore = 0;
        xcoord = new ArrayList<>();
        ycoord = new ArrayList<>();
        xcoord.add(getX());
        ycoord.add(getY());
    }

    public boolean isTouching(Class<? extends Actor> cls) {

        return this.getIntersectingObjects(cls).size() > 0;
    }
    public int getColor(){
        return color;
    }

    public void move(){
        if (dir == 8) {
            setLocation(getX(), getY()-20);
        } else if (dir == 2) {
            setLocation(getX(), getY()+20);
        } else if (dir == 4) {
            setLocation(getX()-20, getY());
        } else if (dir == 6) {
            setLocation(getX()+20, getY());
        }

    }

    public int getDirection(){
        return dir;
    }
    public void act() {}
    public int score()
    {
        return curScore;
    }



    public boolean dead()
    {
        if(this.isTouching(SnakeActor.class)) {
            return true;
        }
        if(this.isTouching(WallActor.class)){
            return true;
        }
        return false;
    }



    public void setDirection(int direction) {
        dir = direction;
    }
    public ArrayList<Integer> getXcoord(){
        return xcoord;
    }
    public ArrayList<Integer> getYcoord(){
        return ycoord;
    }
}
