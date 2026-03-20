import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.awt.*;

public class LightCyclesBase extends Actor {

    int speed;

    LightCyclesBase(int speed) {
        setStartDirection("down");
        setImageColor("Gelb");
        this.speed = speed;
    }

    public void act() {
        handelMovement();
    }

    /**
     *
     * @param direction
     * as left, down, right, up
     */
    public void setStartDirection(String direction) {
        if  (direction.equals("left")) {
            setRotation(270);
        } else if (direction.equals("right")) {
            setRotation(90);
        }  else if (direction.equals("up")) {
            setRotation(0);
        }  else if (direction.equals("down")) {
            setRotation(180);
        }
    }

    /**
     *
     * @param Color Gelb oder Blau
     */
    public void setImageColor(String Color) {
        setImage(("Lightcycles"+Color+".png"));
    }

    public void handelMovement() {
        if (Greenfoot.isKeyDown("a")){
                setRotation(180);
        } else  if (Greenfoot.isKeyDown("d")){
            setRotation(0);
        }   else if (Greenfoot.isKeyDown("w")){
            setRotation(270);
        }   else if (Greenfoot.isKeyDown("s")){
            setRotation(90);
        }
        move(this.speed);
    }


}
