import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s581467 on 12/6/2017.
 */
public class AlwaysGrow extends World{
    private int[][] board = new int[40][30];
    private long startTime;
    private long targetTime;
    private long speed;
    private ArrayList<AlwaysGrowSnake> snakes;
    private int snakesLeft;



    public AlwaysGrow(int playerCount){
        int[][] allkeys = new int[4][4];

        snakesLeft = playerCount;

        int[] keys1 = {Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT};
        int[] keys2 = {Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D};
        int[] keys3 = {Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J};
        int[] keys4 = {Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE};

        allkeys[0] = keys1;
        allkeys[1] = keys2;
        allkeys[2] = keys3;
        allkeys[3] = keys4;


        snakes = new ArrayList<>();


        System.out.println("test");

        for (int i = 0; i<playerCount; i++) {
            snakes.add(new AlwaysGrowSnake(allkeys[i], new SnakeActor(i+1), i+1));
        }

        System.out.println("test");


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
        System.out.println("test");

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 1) {
                    addObject(snakes.get(0).getSnake(), i * 20, j * 20);
                }
                else if (board[i][j] == 2) {
                    addObject(snakes.get(1).getSnake(), i * 20, j * 20);
                }
                else if (board[i][j] == 3) {
                    addObject(snakes.get(2).getSnake(), i * 20, j * 20);
                }
                else if (board[i][j] == 4) {
                    addObject(snakes.get(3).getSnake(), i * 20, j * 20);
                }
                else if (board[i][j] == 5) {
                    addObject(new WallActor(), i * 20, j * 20);
                }
            }

        }

        List<Actor> obj = getObjects();

    }

    public void act(){

        boolean allMoving = true;

        for (int i = 0; i<snakes.size(); i++) {
            SnakeActor snakeHead = snakes.get(i).getSnake();

            if (snakes.get(i).getSnake().getDirection() == 0){
                allMoving = false;
            }
        }

        for (AlwaysGrowSnake player: snakes) {
            player.setDirection();
            if(player.getSnake().dead()){
                snakesLeft--;
            }
        }

        if(allMoving == false) {
            startTime = System.nanoTime();
            return;
        }





        long timeElapsed;

        if((timeElapsed = System.nanoTime()-startTime)>targetTime) {
            for (AlwaysGrowSnake player: snakes) {
                player.move();
            }
            targetTime = targetTime + speed - timeElapsed;
            startTime = System.nanoTime();
        }


        //When there is no winner
        if(snakesLeft==0){
            GameOver gameOverWorld = new GameOver();
            Mayflower.setWorld(gameOverWorld);
        }


        //When there is winner

        if(snakes.size() == 0){
            GameOver gameOverWorld = new GameOver(100);
            Mayflower.setWorld(gameOverWorld);
        }

        if(snakesLeft==1){

            AlwaysGrowSnake winner = null;
            for(AlwaysGrowSnake player: snakes){
                if (!player.getSnake().dead()){
                    winner = player;
                }
            }
            GameOver gameOverWorld = new GameOver(winner.getSnake().getColor());
            Mayflower.setWorld(gameOverWorld);
        }

    }
}
