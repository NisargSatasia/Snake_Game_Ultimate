import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Label;
import mayflower.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by s581467 on 1/17/2018.
 */
public class SnakeWorld extends World {
    private int[][] board = new int[40][30];
    private PointActor point;
    private Label scoreDisplay;
    private long startTime;
    private long targetTime;
    private long speed;
    private Snake snake;
//    private Stack<Portal> portalStack;
//    private Map<Portal, int[]> portalMap;

    public void act(){
    }

    public void setPoint() {
        addObject(point, (int) (Math.random()*36+1) * 20, (int) (Math.random()*26+1) * 20);
    }
    public void removePoint(){
        removeObject(point);
    }

    public void setInput(InputManager input){
        addObject(input,0,0);
    }

    public SnakeWorld() {
        point = new PointActor();
        addObject(point, (int) (Math.random()*36+1) * 20, (int) (Math.random()*26+1) * 20);

        scoreDisplay = new Label("Score: ", 20);
        board = Maps.getRegular();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    addObject(new WallActor(), i * 20, j * 20);
                }
            }
        }
    }

}
