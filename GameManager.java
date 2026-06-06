import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Write a description of class GameManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameManager {
    private static int punkte;
    private static int leben;
    private static int levelGridBugs = 1;
    private static int levelLightCycles = 1;
    private static boolean isLightCyclesCompleted = false;
    private static boolean isGridBugsCompleted = false;
    private static GreenfootSound backgroundMusic = new GreenfootSound("gameMusic.wav");

    public static void fullReset() {
        punkte = 0;
        levelGridBugs = 1;
        leben = 3;
        levelLightCycles = 1;
        startMusicLoop();
        softReset();
    }

    /**
     * Resets the current level based on the game type.
     *
     * @param game The type of game to reset.
     *             1-LightCycles
     *             2-GridBugs
     */
    public static void resetLevel(int game) {
        if (leben > 1) {
            leben--;
            switch (game) {
                case 1 -> initialiseLightCycles();
                case 2 -> initialiseGridBugs();
            }
        } else {
            highscoreScreen(punkte);
        }

    }

    public static void startMusicLoop() {

        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
            backgroundMusic.setVolume(20);
        }
    }

    public static void stopMusicLoop() {
        backgroundMusic.stop();
    }

    public static void highscoreScreen(int punkte) {
        writeHighscore();

        MenuWorld menu = new MenuWorld(false, false);
        Greenfoot.setWorld(menu);
        menu.showText("Game Over! ", 163, 155);
        menu.showText("Your score: " + punkte, 163, 175);
        menu.showText("Highscore: " + readHighscore(), 163, 195);
        Greenfoot.delay(200);
        fullReset();
    }

    public static Integer readHighscore() {
        try {
            return Integer.parseInt(Files.readString(Path.of("highscore")));
        } catch (IOException e) {
            return 0;
        }
    }

    public static void writeHighscore() {
        if (punkte <= readHighscore()) return;

        try {
            Files.writeString(Path.of("highscore"), Integer.toString(punkte));
        } catch (IOException e) {
            System.out.println("Failed to write highscore: " + e);
        }
    }

    public static void softReset() {
        isLightCyclesCompleted = false;
        isGridBugsCompleted = false;
        GameManager.initialiseLevelSelect();
    }

    public static void initialiseLevelSelect() {
        if (isLightCyclesCompleted && isGridBugsCompleted) {
            softReset();
        }
        Greenfoot.setWorld(new MenuWorld(!isLightCyclesCompleted, !isGridBugsCompleted));
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

    public static int getLeben() {
        return leben;
    }

    public static void setLeben(int leben) {
        GameManager.leben = leben;
    }
}
