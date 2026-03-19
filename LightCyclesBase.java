import greenfoot.Actor;

import java.awt.*;

public class LightCyclesBase extends Actor {


    LightCyclesBase() {
        setDirection("down");
        setImageColor("Gelb");
    }

    /**
     *
     * @param direction
     * as Left, Down, Right, Up
     */
    public void setStartDirection(String direction) {

    }

    /**
     *
     * @param Color Gelb oder Blau
     */
    public void setImageColor(String Color) {
        setImage(("Lightcycles"+Color+".png"));
    }

    public void setDirection(String direction) {
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


}
