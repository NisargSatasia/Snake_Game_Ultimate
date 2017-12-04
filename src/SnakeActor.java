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
    private Timer time;
    private int curScore;
    private Label scoreDisplay;
    private ArrayList<Integer> xcoord, ycoord;
    private int lastX, lastY;

    public SnakeActor() {
        setImage("img/snake.png");
        time = new Timer(110);
        curScore = 0;
        scoreDisplay = new Label("Score: ",20);
        xcoord = new ArrayList<>();
        ycoord = new ArrayList<>();

        xcoord.add(getX());
        ycoord.add(getY());
    }

    public boolean isTouching(Class<? extends Actor> cls) {

        return this.getIntersectingObjects(cls).size() > 0;
    }
    public void scoreDisplayer(Label label, int score)
    {
        //label.setLocation(0,0);
        label.setText("Score: "+score);
        label.setColor(Color.WHITE);
        getWorld().addObject(label,50,575);
        System.out.println("Score Field Updated");
    }
    public void addSnakeLength(int x, int y)
    {

    }
    public void move(){

//        lastX = xcoord.get(xcoord.size()-1);
//        lastY = ycoord.get(ycoord.size()-1);
//
//        for(int i = xcoord.size()-1; i>0; i++){
//            xcoord.set(i, xcoord.get(i-1));
//            ycoord.set(i, ycoord.get(i-1));
//        }

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
    public void act()
    {
//        if(this.isTouching(PointActor.class))
//        {
//            this.removeTouching(PointActor.class);
//            PointActor p = new PointActor();
//
////            xcoord.add(lastX);
////            ycoord.add(lastY);
//
//           /* if(p.isAtEdge())
//            {
//                removeTouching(PointActor.class);
//                getWorld().addObject(p, p.getRow(),p.getCol());
//                System.out.println("fuc");
//            }*/
//            int i = 1;
//
//            while(i!=0)
//            {
//                if(p.isTouchingAnthing())
//                {
//                    continue;
//                }
//                // curWorld.addObject(p,(int) Math.floor(Math.random() *800),(int) Math.floor(Math.random() * 600));
//                getWorld().addObject(p, p.getRow()*20,p.getCol()*20);
//                curScore++;
//                i=0;
//                System.out.println("Current Score: "+curScore);
//                System.out.println("Current Score: "+curScore);
//                scoreDisplayer(scoreDisplay,curScore);
//                //get direction
//                //
//
//            }
//
//        }

    }
    public int score()
    {
        return curScore;
    }



    public boolean dead()
    {
        if(this.isTouching(SnakeActor.class))
        {
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
