import greenfoot.World;

/**
 * Write a description of class WorldTemplate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldTemplate extends World {

    /**
     * Constructor for objects of class WorldTemplate.
     *
     */


    public WorldTemplate() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(326, 349, 1, false);
    }

    public void showGameInfo() {
        showText(Integer.toString(GameManager.getPunkte()), 50, 50);
        showText(Integer.toString(GameManager.readHighscore()), 165, 50);
        showText("Leben: " + GameManager.getLeben(), 270, 50);
    }
}
