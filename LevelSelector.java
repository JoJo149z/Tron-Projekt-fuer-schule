import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Der Actor, mit der man die Levelauswahl im Menü steuert.
 *
 * @author jonathan
 */
public class LevelSelector extends Actor {

    private boolean selectionStarted;
    private int timer;

    LevelSelector() {
        selectionStarted = false;
        setRotation(-90);
        timer = 0;

    }

    /**
     * Steuert die Levelauswahl im Menü:
     * a/d zum Drehen und w/Lehrtaste zum Auswählen.
     */
    public void act() {
        if (timer < 10) {
            timer += 1;
            if (timer == 10) {
                Greenfoot.getKey(); //clear key buffer
            }
            return;
        }

        String key = Greenfoot.getKey();
        if (selectionStarted) {
            select();
        } else {
            if (key != null) {
                if ("a".equals(key)) {
                    turn(-90);
                }
                if ("d".equals(key)) {
                    turn(90);
                }
                if ("w".equals(key) || "space".equals(key)) {
                    move(100);

                    boolean foundObject = !getIntersectingObjects(ImageObject.class).isEmpty();
                    move(-100);

                    if (!foundObject) {
                        return;
                    }

                    selectionStarted = true;

                }
            }
        }
    }

    /**
     * Animation und Logik hinter dem Select an sich.
     */
    private void select() {
        if ((getX() <= 60 || (getX() >= 270) || getY() <= 100 || getY() >= 280)) { //Wenn am Bild/Punkt angekommen
            Greenfoot.delay(15);

            getIntersectingObjects(ImageObject.class).forEach(imageObject -> {
                switch (imageObject.getImageName()) {
                    case "MenuWorldBluePart.png" -> GameManager.initialiseLightCycles();
                    case "MenuWorldGreenPart.png" -> GameManager.initialiseGridBugs();
                }
            });
        } else {
            move(2);
        }

    }
}
