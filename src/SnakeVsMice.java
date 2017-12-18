import mayflower.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by s581467 on 12/4/2017.
 */



public class SnakeVsMice extends World {

    private int[][] board = new int[40][30];
    private long startTime;
    private long targetTime;
    private long speed;
    private List<Mice> mice;
    private Snake snake;
    private Map<Mice, Boolean> isDead;
    private int ticksPast;
    private int previousWinner;
    private boolean grew;


    public SnakeVsMice(int playerCount, int previousWinner){
        ticksPast = 0;
        this.previousWinner = previousWinner;
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


        mice = new ArrayList<>();
        isDead = new HashMap<>();

        snake = new Snake(allkeys[previousWinner]);
        snake.addHead(new SnakeActor(previousWinner+1));



        for (int i = 0; i<playerCount; i++) {
            if(i == previousWinner){
                continue;
            }
            mice.add(new Mice(allkeys[i], i+1));
        }

        for (Mice thing: mice) {
            isDead.put(thing, false);
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
                    addObject(mice.get(0), i * 20, j * 20);
                }
                else if (board[i][j] == 2) {
                    addObject(mice.get(1), i * 20, j * 20);
                }
                else if (board[i][j] == 3) {
                    addObject(mice.get(2), i * 20, j * 20);
                }
                else if (board[i][j] == 4) {
                    addObject(snake.getHead(), i * 20, j * 20);
                }
                else if (board[i][j] == 5) {
                    addObject(new WallActor(), i * 20, j * 20);
                }
            }

        }

    }

    public void act(){



        snake.setDirection();

        if(snake.getHead().getDirection() == 0){
            startTime = System.nanoTime();
            return;
        }

        List<Mice> toRemove = new ArrayList<>();

        for (Mice player : mice){
            if(player.isDead()){
                isDead.put(player, new Boolean(true));
            }
        }

        //Removing Dead Mice
        for (Mice player : mice) {
            if (isDead.get(player).booleanValue()) {
                removeObject(player);
                toRemove.add(player);
            }
        }

        mice.removeAll(toRemove);

        snake.setDirection();

        for (Mice player : mice) {
            player.move();
        }

        long timeElapsed;

        if ((timeElapsed = System.nanoTime() - startTime) > targetTime) {
            ticksPast++;
            snake.move();

            targetTime = targetTime + speed - timeElapsed;
            startTime = System.nanoTime();
            grew = false;
        }

        if(ticksPast >= 15){
            grew = true;
            ticksPast = 0;

            SnakeActor toAdd = new SnakeActor(snake.getHead().getColor());
            snake.addTail(toAdd);

            addObject(toAdd, snake.getHead().getX(), snake.getHead().getY());
        }

        if(snake.getHead().dead() && !grew){
            Mayflower.setWorld(new SnakeVsMice(4, previousWinner));
        }



        if(mice.size() == 0){
            GameOver gameOverWorld = new GameOver(100);
            Mayflower.setWorld(gameOverWorld);
        }
        //keep track of winner somehow
        if(mice.size() == 1){
            int newWinner = mice.get(0).getColor();
            System.out.println(newWinner);
            Mayflower.setWorld(new SnakeVsMice(4, newWinner-1));
        }

    }
}
