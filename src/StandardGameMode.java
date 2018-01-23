/**
 * Created by s581467 on 1/17/2018.
 */
import mayflower.*;
import java.util.*;

public class StandardGameMode extends GameModeManager {
    private int numPlayers;
    private SnakeWorld world;
    private List<Snake> snakes;

    public StandardGameMode(int numPlayers, SnakeWorld world){
        this.numPlayers = numPlayers;
        this.world = world;

        snakes = new ArrayList<>();

        for (int i = 0; i<numPlayers; i++) {
            snakes.add(new Snake());
            snakes.get(i).addHead(new SnakeActor(i+1));
            snakes.get(i).setWorld(world);
        }
        if(numPlayers==1){
            world.addObject(snakes.get(0).getHead(), 2 * 20, 2 * 20);
        }
        else if(numPlayers == 2) {
            world.addObject(snakes.get(0).getHead(), 2 * 20, 2 * 20);
            world.addObject(snakes.get(1).getHead(), 37 * 20, 27 * 20);
        }
        else if(numPlayers == 3) {
            world.addObject(snakes.get(0).getHead(), 2 * 20, 2 * 20);
            world.addObject(snakes.get(1).getHead(), 37 * 20, 27 * 20);
            world.addObject(snakes.get(2).getHead(), 37 * 20, 2 * 20);
        }
        else if(numPlayers == 4) {
            world.addObject(snakes.get(0).getHead(), 2 * 20, 2 * 20);
            world.addObject(snakes.get(1).getHead(), 37 * 20, 27 * 20);
            world.addObject(snakes.get(2).getHead(), 37 * 20, 2 * 20);
            world.addObject(snakes.get(3).getHead(), 2 * 20, 27 * 20);
        }


    }

    public void process(Action action){
        switch(action){
            case P1_UP:snakes.get(0).turnUp();break;
            case P2_UP:if(snakes.size()>1){snakes.get(1).turnUp();}break;
            case P3_UP:if(snakes.size()>2){snakes.get(2).turnUp();}break;
            case P4_UP:if(snakes.size()>3){snakes.get(3).turnUp();}break;

            case P1_DOWN:snakes.get(0).turnDown();break;
            case P2_DOWN:if(snakes.size()>1){snakes.get(1).turnDown();}break;
            case P3_DOWN:if(snakes.size()>2){snakes.get(2).turnDown();}break;
            case P4_DOWN:if(snakes.size()>3){snakes.get(3).turnDown();}break;

            case P1_LEFT:snakes.get(0).turnLeft();break;
            case P2_LEFT:if(snakes.size()>1){snakes.get(1).turnLeft();}break;
            case P3_LEFT:if(snakes.size()>2){snakes.get(2).turnLeft();}break;
            case P4_LEFT:if(snakes.size()>3){snakes.get(3).turnLeft();}break;

            case P1_RIGHT:snakes.get(0).turnRight();break;
            case P2_RIGHT:if(snakes.size()>1){snakes.get(1).turnRight();}break;
            case P3_RIGHT:if(snakes.size()>2){snakes.get(2).turnRight();}break;
            case P4_RIGHT:if(snakes.size()>3){snakes.get(3).turnRight();}break;

            case Tick:
                for (Snake snake: snakes) {
                    if(snake.getHead().isTouching(PointActor.class)){
                        world.removePoint();
                        world.setPoint();
                        snake.grow(snakes.indexOf(snake)+1);
                    }
                    if(snake.getHead().getDirection() != 0){
                        snake.move();
                    }
                };break;


        }
    }

}
