import greenfoot.Greenfoot;

/**
 * Der Gegner von Lightcycles.
 * Er fährt dauerhaft nach vorne und dreht sich zufällig entweder nach rechts oder nach links oder in die einzige Richtung bei der man nicht direct stirbt, wenn er gegen eine Wand oder einen Trail fahren würde.
 *
 * @author Jonathan
 * @see #act()
 * @see #handelMovement()
 */
public class LightCyclesEnemy extends LightCyclesBase {
    /**
     *
     * @param speed             != 0
     * @param setStartDirection left, up, down, right
     * @see LightCyclesBase#LightCyclesBase(int, boolean, String)
     */
    LightCyclesEnemy(int speed, String setStartDirection) {
        super(speed, true, setStartDirection);
    }

    /**
     * Führt die act Methode von LightCyclesBase aus{@link #LightCyclesBase}, {@link #handelMovement} und {@link #moveCollision} werden hier aufgerufen, damit der Gegner sich bewegen kann und stirbt, wenn er gegen eine Wand oder einen Trail fährt.
     *
     * @see #handelMovement()
     * @see #moveCollision()
     * @see #death()
     */
    @Override
    public void act() {
        if (startAnimation()) {
            return;
        }
        super.act();

        if (!isDead) {
            handelMovement();
        }

        if (moveCollision()) {
            death();
            return;
        }

        move(speed);
    }

    /**
     * Wenn er gegen eine Wand oder einen Trail fahren würde, dreht er sich zufällig entweder nach rechts oder noch links oder in die einzige Richtung, bei der er nicht direct stirbt.
     *
     * @see #moveCollision()
     */
    @Override
    public void handelMovement() {
        if (moveCollision()) {
            int i = Greenfoot.getRandomNumber(2);
            if (i == 0) {
                turn(90);
            } else if (i == 1) {
                turn(-90);
            }
            if (moveCollision()) {
                if (i == 0) {
                    turn(-180);
                } else if (i == 1) {
                    turn(180);
                }
            }
        }
    }
}
