import greenfoot.Greenfoot;

/**
 * Write a description of class GameManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameManager {
    private static int punkte;

    private static int levelGridBugs = 1;

    private static int levelLightCycles = 1;
    private static boolean isLightCyclesCompleted = false;
    private static boolean isGridBugsCompleted = false;

    public static void fullReset() {
        punkte = 0;
        levelGridBugs = 1;
        levelLightCycles = 1;
        GameManager.initialiseLevelSelect();
    }

    public static void softReset() {
        isLightCyclesCompleted = false;
        isGridBugsCompleted = false;
        GameManager.initialiseLevelSelect();
    }

    public static void initialiseLevelSelect() {
        Greenfoot.setWorld(new MenuWorld());
    }

    public static void initialiseLightCycles() {
        Greenfoot.setWorld(new LightCycles(levelLightCycles));
    }

    public static void initialiseGridBugs() {
        Greenfoot.setWorld(new GridBugs(levelGridBugs));
    }

    public static void addPunkte(int change) {
        punkte += change;
    }

    public static int getPunkte() {
        return punkte;
    }

    public static void setPunkte(int value) {
        punkte = value;
    }

    public static void addLevelGridBugs(int change) {
        levelGridBugs += change;
    }

    public static int getLevelGridBugs() {
        return levelGridBugs;
    }

    public static void setLevelGridBugs(int level) {
        levelGridBugs = level;
    }

    public static void addLevelLightCycles(int change) {
        levelLightCycles += change;
    }

    public static int getLevelLightCycles() {
        return levelLightCycles;
    }

    public static void setLevelLightCycles(int level) {
        levelLightCycles = level;
    }

    public static boolean getIsLightCyclesCompleted() {
        return isLightCyclesCompleted;
    }

    public static void setIsLightCyclesCompleted(boolean isLightCyclesCompleted) {
        GameManager.isLightCyclesCompleted = isLightCyclesCompleted;
    }

    public static boolean getIsGridBugsCompleted() {
        return isGridBugsCompleted;
    }

    public static void setIsGridBugsCompleted(boolean isGridBugsCompleted) {
        GameManager.isGridBugsCompleted = isGridBugsCompleted;
    }
}
