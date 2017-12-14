import mayflower.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by s581467 on 12/4/2017.
 */



public class LocalMultiplayer extends World {

    private int[][] board = new int[40][30];
    private PointActor point;
    private long startTime;
    private long targetTime;
    private long speed;
    private ArrayList<Snake> snakes;
    private Map<Snake, Boolean> isDead;

    private boolean grew;

    public LocalMultiplayer(int playerCount){
        grew = false;
        int[][] allkeys = new int[4][4];

        int[] keys1 = {Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT};
        int[] keys2 = {Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D};
        int[] keys3 = {Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J};
        int[] keys4 = {Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE};

        allkeys[0] = keys1;
        allkeys[1] = keys2;
        allkeys[2] = keys3;
        allkeys[3] = keys4;


        snakes = new ArrayList<>();
        isDead = new HashMap<>();



        for (int i = 0; i<playerCount; i++) {
            snakes.add(new Snake(allkeys[i]));
            snakes.get(i).addHead(new SnakeActor(i+1));
            isDead.put(snakes.get(i), false);
        }



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
                    board[i][j] = 5;
                }
                if(i==39)
                {
                    board[i][j] = 5;
                }

            }
        }
        for(int i = 0;i<board.length;i++)
        {
            board[i][0]=5;
            board[i][29]=5;
        }

        if(playerCount == 2) {
            board[2][2] = 1;
            board[37][27] = 2;
        }
        else if(playerCount == 3) {
            board[2][2] = 1;
            board[37][27] = 2;
            board[37][2] = 3;
        }
        else if(playerCount == 4) {
            board[2][2] = 1;
            board[37][27] = 2;
            board[37][2] = 3;
            board[2][27] = 4;
        }

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 1) {
                    addObject(snakes.get(0).getHead(), i * 20, j * 20);
                }
                else if (board[i][j] == 2) {
                    addObject(snakes.get(1).getHead(), i * 20, j * 20);
                }
                else if (board[i][j] == 3) {
                    addObject(snakes.get(2).getHead(), i * 20, j * 20);
                }
                else if (board[i][j] == 4) {
                    addObject(snakes.get(3).getHead(), i * 20, j * 20);
                }
                else if (board[i][j] == 5) {
                    addObject(new WallActor(), i * 20, j * 20);
                }
            }

        }

        List<Actor> obj = getObjects();
        point = new PointActor();

        if(!(obj.contains(point)))
        {
            board[point.getRow()][point.getCol()] = 6;
        }

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 6)
                {
                    addObject(point, i * 20, j * 20);
                }
            }

        }
    }

    public void act(){

        boolean allMoving = true;

        for (int i = 0; i<snakes.size(); i++) {
            SnakeActor snakeHead = snakes.get(i).getHead();
            if(snakeHead.isTouching(PointActor.class))
            {
                removeObject(point);
                point = new PointActor();

                SnakeActor toAdd = new SnakeActor(snakeHead.getColor());
                snakes.get(i).addTail(toAdd);

                addObject(toAdd, snakeHead.getX(), snakeHead.getY());

                int j = 1;

                while(j!=0)
                {
                    if(point.isTouchingAnthing())
                    {
                        continue;
                    }
                    addObject(point, point.getRow()*20,point.getCol()*20);
                    j=0;
                }
                grew =true;
            }
            if (snakes.get(i).getHead().getDirection() == 0){
                allMoving = false;
            }

        }

        List<Snake> toRemove = new ArrayList<>();


        //Removing Dead Snakes
        for(Snake player: snakes){
            if(isDead.get(player).booleanValue()) {
                for (SnakeActor s : player.getSegments()) {
                    removeObject(s);
                    toRemove.add(player);
                }
            }
        }

        snakes.removeAll(toRemove);

        for (Snake player: snakes) {
            player.setDirection();
        }

        if(allMoving == false){
            startTime = System.nanoTime();
            return;
        }

        long timeElapsed;

        if((timeElapsed = System.nanoTime()-startTime)>targetTime) {
            for (Snake player: snakes) {
                if(player.getHead().dead() && !grew){
                    isDead.put(player, new Boolean(true));
                }
                player.move();
                if(player.getHead().dead() && !grew){
                    isDead.put(player, new Boolean(true));
                }
            }

            targetTime = targetTime + speed - timeElapsed;
            startTime = System.nanoTime();

            grew = false;
        }


        if(snakes.size() == 0){
            GameOver gameOverWorld = new GameOver(100);
            Mayflower.setWorld(gameOverWorld);
        }
        //keep track of winner somehow
        if(snakes.size() == 1){
            GameOver gameOverWorld = new GameOver(snakes.get(0).getHead().getColor());
            Mayflower.setWorld(gameOverWorld);
        }

    }
}
