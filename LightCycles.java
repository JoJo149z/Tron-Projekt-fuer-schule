/**
 * Write a description of class LightCycles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightCycles extends WorldTemplate {
    int difficulty;

    public LightCycles() {
        this(1);
    }

    /**
     * Constructor for objects of class LightCycles.
     *
     */
    public LightCycles(int difficulty) {
        this.difficulty = difficulty;
        setPaintOrder(LightCyclesBase.class, ImageObject.class);
        prepare();
    }

    public void act() {
        showGameInfo();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        int enemySpeed = 1;
        int playerSpeed = 1;
        if (difficulty > 2) {
            enemySpeed = difficulty - 1;
            playerSpeed = difficulty - 1;
        }
        LightCyclesPlayer lightCyclesPlayer = new LightCyclesPlayer(playerSpeed, "up");
        addObject(lightCyclesPlayer, 154, 273);
        LightCyclesEnemy lightCyclesEnemy = new LightCyclesEnemy(enemySpeed, "down");
        addObject(lightCyclesEnemy, 154, 100);
        if (difficulty > 1) {
            LightCyclesEnemy lightCyclesEnemy2 = new LightCyclesEnemy(enemySpeed, "down");
            addObject(lightCyclesEnemy2, 244, 100);
            LightCyclesEnemy lightCyclesEnemy3 = new LightCyclesEnemy(enemySpeed, "down");
            addObject(lightCyclesEnemy3, 82, 100);
        }
    }
}
