import greenfoot.*;

/**
 * Write a description of class LightCyclesPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightCyclesPlayer extends LightCyclesBase
{
    /**
     *
     * @param speed             != 0
     * @param farbe             Gelb/Blau
     * @param setStartDirection left, up, down, right
     */
    LightCyclesPlayer(int speed, String farbe, String setStartDirection) {
        super(speed, farbe, setStartDirection);
    }


    @Override
    public void handelMovement(){
        checkMoveCollision();
        String key = Greenfoot.getKey();
        if (key != null) {
            if ("a".equals(key)) {
                turn(-90);
            }
            if ("d".equals(key)) {
                turn(90);
            }
        }
        move(speed);

    }
}
