import greenfoot.Greenfoot;

/**
 * Der Spieler von Lightcycles.
 * Er fährt dauerhaft nach vorne und kann sich mit a und d drehen {@link #handelMovement()}.
 * bevor er stirbt kann er sich noch für ein paar frames retten {@link #act()}.
 *
 * @author Jonathan
 * @see #act()
 * @see #handelMovement()
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

    /**
     * führt die act Methode von LightCyclesBase aus{@link #LightCyclesBase}, {@link #handelMovement} und {@link #moveCollision} werden hier aufgerufen, damit der Spieler sich bewegen kann und stirbt, wenn er gegen eine Wand oder einen Trail fährt.
     * wenn er gegen eine Wand fahren würde, bekommt er einen Buffer von ein paar Frames, um sich zu retten, bevor er stirbt.
     *
     * @see #handelMovement()
     * @see #moveCollision()
     * @see #death()
     */
    @Override
    public void act() {
        int rotation = getRotation();
        if (startAnimation()) {
            return;
        }
        super.act();
        handelMovement();
        if (moveCollision()) { //ein Buffer für ein paar Frames, damit der Spieler sich retten kann, wenn gegen eine Wand/trail fährt.

            if (deathBuffer == 0) {
                deathBuffer = 5; // ca. 0,2 Sekunden
            }

            deathBuffer--;

            if (!moveCollision()) {
                deathBuffer = 0; // Spieler hat sich gerettet
            } else if (deathBuffer <= 0 || moveCollision() && getRotation() != rotation) {
                death(); // wenn entweder der Buffer abgelaufen ist oder der Spieler sich gedreht hat, aber immer noch in Kollision ist, stirbt er.
            }
            return;
        }


        move(speed);

        deathBuffer = 0;


    }

    /**
     * kümmert sich um die Bewegung bzw. Rotation des Spielers.
     */
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
