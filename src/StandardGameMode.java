/**
 * Created by s581467 on 1/17/2018.
 */
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import mayflower.*;
import java.util.*;

public class StandardGameMode extends GameModeManager {
    private Map<Snake, Boolean> isDead;
    private SnakeWorld world;
    private List<Snake> snakes;
    private int snakeCount;
    private Map<String,String> skin;

    public StandardGameMode(int numPlayers, SnakeWorld world, Map<String,String> color){
        snakeCount = numPlayers;
        this.world = world;
        skin = color;
        snakes = new ArrayList<>();
        isDead = new HashMap<>();

        for (int i = 0; i<numPlayers; i++) {
            snakes.add(new Snake());
            snakes.get(i).addHead(new SnakeActor(i+1));
            snakes.get(i).setWorld(world);
            isDead.put(snakes.get(i), false);
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
                boolean allMoving = true;
                for (Snake snake: snakes) {
                    if (snake.getHead().getDirection() == 0) {
                        allMoving = false;
                    }
                }

                if(allMoving == false){
                    return;
                }

                for (Snake snake: snakes) {
                    if(isDead.get(snake).booleanValue()==true){
                        continue;
                    }
                    boolean grew = false;
                    if(snake.getHead().isTouching(PointActor.class)){
                        world.removePoint();
                        world.setPoint();
                        snake.grow(snakes.indexOf(snake)+1);
                        grew = true;
                    }

                    if(snake.getHead().dead() && !grew){
                        isDead.put(snake, new Boolean(true));
                    }

                    snake.move();


                    if(snake.getHead().dead() && !grew){
                        isDead.put(snake, new Boolean(true));
                    }
                }

                snakeCount = 0;
                for(Snake player: snakes){
                    snakeCount++;
                    if(isDead.get(player).booleanValue()) {
                        snakeCount--;
                        for (SnakeActor s : player.getSegments()) {
                            world.removeObject(s);
                        }
                    }
                }
                ;break;
        }
        System.out.println(snakeCount);
        if(snakeCount == 0){
            Mayflower.setWorld(new GameOver());
        }

    }

}
