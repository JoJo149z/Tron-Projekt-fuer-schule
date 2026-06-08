/**
 * Write a description of class LightCycles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightCycles extends WorldTemplate {
    int difficulty;


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
        if (difficulty > 8) {
            difficulty = 8;
        }
        if (difficulty > 4) { //ab difficulty 5 werden bei jedes zweite Mal spielen. die Geschwindigkeit erhöht.
            if (difficulty % 2 == 0) {
                enemySpeed = (difficulty - 2) / 2;
                playerSpeed = (difficulty - 2) / 2;
            } else {
                enemySpeed = (difficulty - 1) / 2;
                playerSpeed = (difficulty - 1) / 2;
            }
        }
        LightCyclesPlayer lightCyclesPlayer = new LightCyclesPlayer(playerSpeed, "up");
        addObject(lightCyclesPlayer, 154, 273);
        LightCyclesEnemy lightCyclesEnemy = new LightCyclesEnemy(enemySpeed, "down");
        addObject(lightCyclesEnemy, 154, 100);
        if (difficulty > 1) {
            LightCyclesEnemy lightCyclesEnemy1 = new LightCyclesEnemy(enemySpeed, "down");
            addObject(lightCyclesEnemy1, 244, 100);
        }
        if (difficulty > 2) {
            LightCyclesEnemy lightCyclesEnemy2 = new LightCyclesEnemy(enemySpeed, "down");
            addObject(lightCyclesEnemy2, 82, 100);
        }
    }
}
