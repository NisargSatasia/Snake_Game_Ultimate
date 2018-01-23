import java.util.List;
import mayflower.*;

/**
 * Created by s581467 on 1/17/2018.
 */
public abstract class GameModeManager {

    private List<Snake> snakes;
    private World world;

    public List<Snake> getSnakes(){
        return snakes;
    }
    public World getWorld(){
        return world;
    }
    public Snake getSnake(int index){
        return snakes.get(index);
    }

    public void addSnake(Snake snake){
        snakes.add(snake);
    }
    public void setWorld(World world){
        this.world = world;
    }

    public abstract void process(Action action);
}
