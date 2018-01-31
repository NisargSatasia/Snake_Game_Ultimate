/**
 * Created by s581467 on 1/17/2018.
 */
import mayflower.*;
import java.util.*;

public class TwitchPlaysMode extends GameModeManager {
    private Map<Snake, Boolean> isDead;
    private SnakeWorld world;
    private List<Snake> snakes;
    private int numPlayers;
    private Snake snake;

    private Map<Integer, String> commands;

    public TwitchPlaysMode(int numPlayers, SnakeWorld world){
        this.numPlayers = numPlayers;
        this.world = world;


        snakes = new ArrayList<>();
        isDead = new HashMap<>();
        commands = new HashMap<>();

        snakes.add(new Snake());
        snakes.get(0).addHead(new SnakeActor(1));
        snakes.get(0).setWorld(world);
        isDead.put(snakes.get(0), false);

        world.addObject(snakes.get(0).getHead(), 2 * 20, 2 * 20);

        snake = snakes.get(0);

        for(int i=0; i<4; i++){
            commands.put(new Integer(i), ""+i);
        }
    }

    public void process(Action action){

        switch(action){
            case P1_UP:
                commands.put(new Integer(0), "up");break;
            case P2_UP:
                commands.put(new Integer(1), "up");break;
            case P3_UP:
                commands.put(new Integer(2), "up");break;
            case P4_UP:
                commands.put(new Integer(3), "up");break;

            case P1_DOWN:
                commands.put(new Integer(0), "down");break;
            case P2_DOWN:
                commands.put(new Integer(1), "down");break;
            case P3_DOWN:
                commands.put(new Integer(2), "down");break;
            case P4_DOWN:
                commands.put(new Integer(3), "down");break;

            case P1_LEFT:
                commands.put(new Integer(0), "left");break;
            case P2_LEFT:
                commands.put(new Integer(1), "left");break;
            case P3_LEFT:
                commands.put(new Integer(2), "left");break;
            case P4_LEFT:
                commands.put(new Integer(3), "left");break;

            case P1_RIGHT:
                commands.put(new Integer(0), "right");break;
            case P2_RIGHT:
                commands.put(new Integer(1), "right");break;
            case P3_RIGHT:
                commands.put(new Integer(2), "right");break;
            case P4_RIGHT:
                commands.put(new Integer(3), "right");break;

            case Tick:
                String command = commands.get(new Integer(0));
                boolean canMove = true;

                for(int i = 0; i<numPlayers; i++){
                    if(!commands.get(new Integer(i)).equals(command)){
                        canMove=false;
                    }
                }

                if(canMove) {
                    switch (command) {
                        case "up":
                            snake.turnUp();
                            break;
                        case "down":
                            snake.turnDown();
                            break;
                        case "left":
                            snake.turnLeft();
                            break;
                        case "right":
                            snake.turnRight();
                            break;
                    }
                }

                snake.move();

                if(snake.getHead().isTouching(PointActor.class)){
                    world.removePoint();
                    world.setPoint();
                    snake.grow(snakes.indexOf(snake)+1);
                }

                if(snake.getHead().dead()){
                    isDead.put(snake, new Boolean(true));
                }
        }

        if (isDead.get(snake).booleanValue()){
            Mayflower.setWorld(new GameOver());
        }

    }

}
