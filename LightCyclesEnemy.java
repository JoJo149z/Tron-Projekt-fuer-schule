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
     * @param isEnemy           true/false
     * @param setStartDirection left, up, down, right
     */
    LightCyclesEnemy(int speed, Boolean isEnemy, String setStartDirection) {
        super(speed, isEnemy, setStartDirection);
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
