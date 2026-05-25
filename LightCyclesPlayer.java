import greenfoot.Greenfoot;

/**
 * Write a description of class LightCyclesPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightCyclesPlayer extends LightCyclesBase {
    /**
     *
     * @param speed             != 0
     * @param setStartDirection left, up, down, right
     */
    LightCyclesPlayer(int speed, String setStartDirection) {
        super(speed, false, setStartDirection);
    }


    @Override
    public void handelMovement() {
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
