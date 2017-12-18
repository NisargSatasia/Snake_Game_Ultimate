import mayflower.Actor;
import mayflower.Mayflower;

import java.util.ArrayDeque;

/**
 * Created by s581467 on 12/14/2017.
 */
public class Mice extends Actor {
    private int[] keys;
    private int color;

    public Mice(int[] keyset, int color){
        keys = keyset;
        this.color = color;

        switch(color){
            case 1: setImage("img/snakeYellow.png");break;
            case 2: setImage("img/snakeGreen.png");break;
            case 3: setImage("img/snakeBlue.png");break;
            case 4: setImage("img/snakeWhite.png");break;
        }
    }
    public void move(){

        //up
        if(Mayflower.isKeyPressed(keys[0])){
            if(!this.getObjectsAtOffset( 0, -this.getImage().getHeight(), WallActor.class ).isEmpty() || !this.getObjectsAtOffset( 0, -this.getImage().getHeight(), Mice.class ).isEmpty()){
                return;
            }
            setLocation(getX(), getY()-20);
        }
        //down
        else if(Mayflower.isKeyPressed(keys[1])){
            if(!this.getObjectsAtOffset( 0, this.getImage().getHeight(), WallActor.class ).isEmpty() || !this.getObjectsAtOffset( 0, this.getImage().getHeight(), Mice.class ).isEmpty()){
                return;
            }
            setLocation(getX(), getY()+20);
        }
        //left
        else if(Mayflower.isKeyPressed(keys[2])){
            if(!this.getObjectsAtOffset( -this.getImage().getHeight(), 0, WallActor.class ).isEmpty() || !this.getObjectsAtOffset( -this.getImage().getHeight(), 0, Mice.class ).isEmpty()){
                return;
            }
            setLocation(getX()-20, getY());
        }
        //right
        else if(Mayflower.isKeyPressed(keys[3])){
            if(!this.getObjectsAtOffset( this.getImage().getHeight(), 0, WallActor.class ).isEmpty() || !this.getObjectsAtOffset( this.getImage().getHeight(), 0, Mice.class ).isEmpty()){
                return;
            }
            setLocation(getX()+20, getY());
        }
    }

    public void act() {}

    public boolean isDead(){
        if (this.isTouching(SnakeActor.class)){
            return true;
        }
        return false;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor(){
        return color;
    }
}
