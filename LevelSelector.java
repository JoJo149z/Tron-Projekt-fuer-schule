import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class levelSelector here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     * Act - do whatever the levelSelecter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
                if ("w".equals(key)) {
                    move(100);

                    boolean foundObject = !getIntersectingObjects(ImageObject.class).isEmpty();
                    move(-100);

                    if (!foundObject) {
                        return;
                    }

                    selectionStarted = true;

                }
                if ("r".equals(key)) {
                    GameManager.fullReset();
                }
            }
        }
    }

    //wenn 50 pixel bewegt dann ImageObject entfernen
    public void select() {
        if ((getX() <= 60 || (getX() >= 270) || getY() <= 100 || getY() >= 280)) {
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
