import mayflower.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s581467 on 1/17/2018.
 */
public class InputManager extends Actor{
    private Map<Integer, Action> keyToAction;
    private GameModeManager gameModeManager;

    private long startTime;
    private long targetTime;
    private long speed;

    public InputManager(GameModeManager gmm){

        startTime = System.nanoTime();
        speed = 75000000;
        targetTime = speed;

        gameModeManager = gmm;

        keyToAction = new HashMap<>();

        keyToAction.put(Keyboard.KEY_UP, Action.P1_UP);
        keyToAction.put(Keyboard.KEY_DOWN, Action.P1_DOWN);
        keyToAction.put(Keyboard.KEY_LEFT, Action.P1_LEFT);
        keyToAction.put(Keyboard.KEY_RIGHT, Action.P1_RIGHT);

        keyToAction.put(Keyboard.KEY_W, Action.P2_UP);
        keyToAction.put(Keyboard.KEY_S, Action.P2_DOWN);
        keyToAction.put(Keyboard.KEY_A, Action.P2_LEFT);
        keyToAction.put(Keyboard.KEY_D, Action.P2_RIGHT);

        keyToAction.put(Keyboard.KEY_Y, Action.P3_UP);
        keyToAction.put(Keyboard.KEY_H, Action.P3_DOWN);
        keyToAction.put(Keyboard.KEY_G, Action.P3_LEFT);
        keyToAction.put(Keyboard.KEY_J, Action.P3_RIGHT);

        keyToAction.put(Keyboard.KEY_P, Action.P4_UP);
        keyToAction.put(Keyboard.KEY_SEMICOLON, Action.P4_DOWN);
        keyToAction.put(Keyboard.KEY_L, Action.P4_LEFT);
        keyToAction.put(Keyboard.KEY_APOSTROPHE, Action.P4_RIGHT);
    }

    public void act(){

        for(Integer key : keyToAction.keySet()){
            if(Mayflower.isKeyPressed(key)){
                gameModeManager.process(keyToAction.get(key));
            }
        }


        long timeElapsed;

        if((timeElapsed = System.nanoTime()-startTime)>targetTime) {
            gameModeManager.process(Action.Tick);
            targetTime = targetTime + speed - timeElapsed;
            startTime = System.nanoTime();
        }

    }

}
