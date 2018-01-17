import mayflower.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class TwitchPlaysSnakeMode extends World{

    private int[][] board = new int[40][30];
    private PointActor point;
    private Label scoreDisplay;
    private long startTime;
    private long targetTime;
    private long speed;
    private SnakeT snake;

    public TwitchPlaysSnakeMode(int playerCount){

        scoreDisplay = new Label("Score: ",20);

        snake = new SnakeT(playerCount);
        SnakeActor snakeActor = new SnakeActor(1);
        snake.addHead(snakeActor);

        int dir = snakeActor.getDirection();

        System.out.println(dir);

        startTime = System.nanoTime();
        speed = 75000000;
        targetTime = speed;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++){
                board[i][j] = 0;
            }
        }
        for(int i =0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(i == 0) {
                    board[i][j] = 2;
                }
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
        board[37][27] = 1;

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 1) {
                    addObject(snakeActor, i * 20, j * 20);
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
    public void act(){
        SnakeActor snakeHead = snake.getHead();
        if(snakeHead.isTouching(PointActor.class))
        {
            removeObject(point);
            point = new PointActor();

            SnakeActor toAdd = new SnakeActor(1);
            snake.addTail(toAdd);

            addObject(toAdd, snakeHead.getX(), snakeHead.getY());

            int i = 1;

            while(i!=0)
            {
                if(point.isTouchingAnthing())
                {
                    continue;
                }
                addObject(point, point.getRow()*20,point.getCol()*20);
                i=0;
                scoreDisplayer(scoreDisplay,snake.size());
            }
        }

        snake.setDirection();

        long timeElapsed;

        if((timeElapsed = System.nanoTime()-startTime)>targetTime) {
            System.out.println("Target Time: "+ targetTime+"      Time Elapsed: "+ timeElapsed);
            snake.move();
            targetTime = targetTime + speed - timeElapsed;
            startTime = System.nanoTime();
        }


    }

}

