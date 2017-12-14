import mayflower.Actor;

/**
 * Created by s581467 on 12/8/2017.
 */
public class Portal extends Actor {

    private Portal link;

    public Portal(){
        setImage("img/portal.png");
    }

    public void setLink(Portal link){
        this.link = link;
    }

    public Portal getLink(){
        return link;
    }

    public void act(){

    }
}
