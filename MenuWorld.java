/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuWorld extends WorldTemplate {

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MenuWorld() {
        addObject(new LevelSelector(), 165, 190);
        if (!GameManager.getIsLightCyclesCompleted()) {
            addObject(new ImageObject("MenuWorldBluePart.png"), 60, 190);
        }
        if (!GameManager.getIsGridBugsCompleted()) {
            addObject(new ImageObject("MenuWorldGreenPart.png"), 165, 100);
        }

        //addObject(new ImageObject("MenuWorldOrangePart.png"), 270, 190);
        //ddObject(new ImageObject("MenuWorldRedPart.png"), 165, 280);
        prepare();
    }

    public void act() {
        showScore(50, 50);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        setPaintOrder(LevelSelector.class, ImageObject.class);
    }
}
