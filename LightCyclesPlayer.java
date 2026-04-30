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
     * @param isEnemy           true/false
     * @param setStartDirection left, up, down, right
     */
    LightCyclesPlayer(int speed, boolean isEnemy, String setStartDirection) {
        super(speed, isEnemy, setStartDirection);
    }


    @Override
    public void handelMovement(){
        if(!isDead){
            String key = Greenfoot.getKey();
            if (key != null) {
                if ("a".equals(key)) {
                    turn(-90);
                }
                if ("d".equals(key)) {
                    turn(90);
                }
            }
        }
    }
}
