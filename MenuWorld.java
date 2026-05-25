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
        //addObject(new ButtonGridBugs(), 150, 150);
        addObject(new levelSelector(), 165, 190);
        addObject(new ImageObject("MenuWorldBluePart.png"), 60, 190);
        addObject(new ImageObject("MenuWorldGreenPart.png"), 165, 100);
        addObject(new ImageObject("MenuWorldOrangePart.png"), 270, 190);
        addObject(new ImageObject("MenuWorldRedPart.png"), 165, 280);
    }

    public void act() {
        showScore(50, 50);
    }
}
