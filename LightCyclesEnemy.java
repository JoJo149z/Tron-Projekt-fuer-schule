import greenfoot.Greenfoot;

/**
 * Write a description of class LightCyclesEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightCyclesEnemy extends LightCyclesBase
{
    /**
     *
     * @param speed             != 0
     * @param farbe             Gelb/Blau
     * @param setStartDirection left, up, down, right
     */
    LightCyclesEnemy(int speed, String farbe, String setStartDirection) {
        super(speed, farbe, setStartDirection);
    }
    @Override
    public void handelMovement() {
        if (!isDead){
            if (moveCollision()){
                int i = Greenfoot.getRandomNumber(2);
                if (i == 0) {
                    turn(90);
                } else if (i == 1) {
                    turn(-90);
                }
            }
        }
    }
}
