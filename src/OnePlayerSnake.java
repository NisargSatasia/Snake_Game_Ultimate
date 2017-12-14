import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import mayflower.*;
import mayflower.Color;
import mayflower.Label;


public class OnePlayerSnake extends World {

    private int[][] board = new int[40][30];
    private PointActor point;
    private Label scoreDisplay;
    private long startTime;
    private long targetTime;
    private long speed;
    private Snake snake;
    private Stack<Portal> portalStack;
    private Map<Portal, int[]> portalMap;

    public OnePlayerSnake(boolean portals){

        portalStack = new Stack<>();
        portalMap = new HashMap<>();

        scoreDisplay = new Label("Score: ",20);
        int[] keyset = {Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT};
        snake = new Snake(keyset);
        SnakeActor snakeActor = new SnakeActor(1);
        snake.addHead(snakeActor);

        startTime = System.nanoTime();
        speed = 75000000;
        targetTime = speed;

        if(portals) {
            board = Maps.getPortal1();
        }
        else{
            board = Maps.getRegular();
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
                if (board[i][j] == 10) {
                    Portal portal = new Portal();
                    int[] temp = {i,j};
                    portalMap.put(portal, temp);
                    portalStack.push(portal);

                    if(portalStack.size()>=2){
                        Portal p1 = portalStack.pop();
                        Portal p2 = portalStack.pop();

                        p1.setLink(p2);
                        p2.setLink(p1);

                        addObject(p1, portalMap.get(p1)[0]*20, portalMap.get(p1)[1]*20);
                        addObject(p2, portalMap.get(p2)[0]*20, portalMap.get(p2)[1]*20);
                    }
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
            snake.move();
            targetTime = targetTime + speed - timeElapsed;
            startTime = System.nanoTime();
        }

        if(snakeHead.dead()){
            GameOver gameOverWorld = new GameOver();
            Mayflower.setWorld(gameOverWorld);
        }
    }
}
