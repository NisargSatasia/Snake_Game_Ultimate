/**
 * Created by s581467 on 11/7/2017.
 */
import java.awt.*;
import java.util.*;
import java.util.List;

import mayflower.*;
import mayflower.Color;
import mayflower.Label;
import mayflower.Timer;

public class SnakeWorld extends World {

    int[][] board = new int[40][30];
    private Timer time;
    private PointActor point;
    private int toAddX, toAddY;
    private Deque<SnakeActor> segments;
    private Label scoreDisplay;

    public SnakeWorld(){
        scoreDisplay = new Label("Score: ",20);
        SnakeActor snake = new SnakeActor();
        time = new Timer(110);
        segments = new ArrayDeque<SnakeActor>();
        segments.addFirst(snake);
        setBackground("img/snakeBackground.png");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++){
                board[i][j] = 0;
            }
        }
        for(int i =0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                    if(i == 0)
                    board[i][j] = 2;
                        /* if(i == 39)
                        {
                        board[i][j] = 2;
                        }*/
                    if(i==39)
                    {
                        board[i][j] =2;
                    }

            }
        }
        for(int i = 0;i<board.length;i++)
        {
            board[i][0]=2;
            board[i][29]=2;
        }
        board[1][1] = 1;
        board[1][2] = 1;

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 1) {
                    addObject(snake, i * 20, j * 20);
                }
                if (board[i][j] == 2) {
                    addObject(new WallActor(), i * 20, j * 20);
                }
            }

        }

        List<Actor> obj = getObjects();
        point = new PointActor();

       if(!(obj.contains(point)))
        {
            board[point.getRow()][point.getCol()] = 3;
        }

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 3)
                {
                    addObject(point, i * 20, j * 20);
                }
            }

        }
    }

    public void scoreDisplayer(Label label, int score)
    {
        //label.setLocation(0,0);
        label.setText("Score: "+score);
        label.setColor(Color.WHITE);
        addObject(label,50,575);
        System.out.println("Score Field Updated");
    }

    public void act() {
        SnakeActor snake = this.segments.getFirst();

        if(snake.isTouching(PointActor.class))
        {
            removeObject(point);
            point = new PointActor();

            SnakeActor toAdd = new SnakeActor();
            segments.addLast(toAdd);

            addObject(toAdd, snake.getX(), snake.getY());

//            xcoord.add(lastX);
//            ycoord.add(lastY);

           /* if(p.isAtEdge())
            {
                removeTouching(PointActor.class);
                getWorld().addObject(p, p.getRow(),p.getCol());
                System.out.println("fuc");
            }*/
            int i = 1;

            while(i!=0)
            {
                if(point.isTouchingAnthing())
                {
                    continue;
                }
                addObject(point, point.getRow()*20,point.getCol()*20);
                i=0;
//                System.out.println("Current Score: "+curScore);
               scoreDisplayer(scoreDisplay,segments.size());
//                //get direction
//                //

            }

        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_UP) || Mayflower.isKeyPressed(Keyboard.KEY_W)){
            snake.setDirection(8);
        }else if(Mayflower.isKeyPressed(Keyboard.KEY_DOWN) || Mayflower.isKeyPressed(Keyboard.KEY_S)){
            snake.setDirection(2);
        }else if(Mayflower.isKeyPressed(Keyboard.KEY_LEFT) || Mayflower.isKeyPressed(Keyboard.KEY_A)){
            snake.setDirection(4);
        }else if(Mayflower.isKeyPressed(Keyboard.KEY_RIGHT) || Mayflower.isKeyPressed(Keyboard.KEY_D)){
            snake.setDirection(6);
        }

        if(time.isDone()) {
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
            time.reset();
        }



    }
}
