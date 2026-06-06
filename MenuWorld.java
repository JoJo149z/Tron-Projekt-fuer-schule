/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuWorld extends WorldTemplate {


    public MenuWorld() {
        GameManager.fullReset();
    }

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MenuWorld(boolean LightCycles, boolean GridBugs) {
        GameManager.startMusicLoop();
        if (LightCycles) {
            addObject(new ImageObject("MenuWorldBluePart.png"), 60, 190);
        }
        if (GridBugs) {
            addObject(new ImageObject("MenuWorldGreenPart.png"), 165, 100);
        }
        if (LightCycles || GridBugs) {
            addObject(new LevelSelector(), 165, 190);
        }
        //addObject(new ImageObject("MenuWorldOrangePart.png"), 270, 190);
        //ddObject(new ImageObject("MenuWorldRedPart.png"), 165, 280);
        prepare();
    }

    public void act() {
        if (GameManager.getLeben() > 0) {
            showGameInfo();
        }

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        setPaintOrder(LevelSelector.class, ImageObject.class);
    }
}
