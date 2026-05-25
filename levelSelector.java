import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class levelSelector here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class levelSelector extends Actor {

    private boolean selectionStarted;

    levelSelector() {
        selectionStarted = false;
        setRotation(-90);
    }

    /**
     * Act - do whatever the levelSelecter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        String key = Greenfoot.getKey();
        if (!selectionStarted) {
            if (key != null) {
                if ("a".equals(key)) {
                    turn(-90);
                }
                if ("d".equals(key)) {
                    turn(90);
                }
                if ("w".equals(key)) {
                    selectionStarted = true;
                }
            }
        } else {
            select();
        }
    }

    //wenn 50 pixel bewegt dann ImageObject entfernen
    public void select() {
        if (!(getX() <= 60 || (getX() >= 270) || getY() <= 100 || getY() >= 280)) {
            move(2);
        } else {
            getIntersectingObjects(ImageObject.class).forEach(imageObject -> {
                switch (imageObject.getImageName()) {
                    case "MenuWorldBluePart.png" -> GameManager.initialiseLightCycles();
                    case "MenuWorldGreenPart.png" -> GameManager.initialiseGridBugs();
                    case "MenuWorldOrangePart.png" -> Greenfoot.setWorld(new MenuWorld());
                    case "MenuWorldRedPart.png" -> Greenfoot.setWorld(new MenuWorld());
                }
            });
            removeTouching(ImageObject.class);
        }

    }
}
