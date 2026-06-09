import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Zentrale Verwaltungsklasse des Spiels.
 * Der GameManager steuert den gesamten Spielzustand, einschließlich Punkte,
 * Leben, Levelprogression, Spielmodi sowie Audio- und Reset-Logik.
 * Außerdem verwaltet er den Wechsel zwischen Menüs und Spielwelten.
 *
 * @author Jonathan
 *
 */
public class GameManager {
    private static final GreenfootSound backgroundMusic = new GreenfootSound("gameMusic.wav");
    private static final GreenfootSound explosion1 = new GreenfootSound("explosion1.wav");
    private static int punkte;
    private static int leben;
    private static int levelGridBugs = 1;
    private static int levelLightCycles = 1;
    private static boolean isLightCyclesCompleted = false;
    private static boolean isGridBugsCompleted = false;

    /**
     * Reset des Spiels, der alle Werte auf ihre Anfangswerte zurücksetzt.
     *
     * @see #softReset()
     */
    public static void fullReset() {
        punkte = 0;
        levelGridBugs = 1;
        leben = 3;
        levelLightCycles = 1;
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
            highscoreScreen();
        }

    }

    /**
     * Startet die Hintergrundmusik, falls sie noch nicht läuft.
     *
     * @see #stopMusicLoop()
     */
    public static void startMusicLoop() {

        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
            backgroundMusic.setVolume(20);
        }
    }

    /**
     * Stoppt die Hintergrundmusik.
     *
     * @see #startMusicLoop()
     */
    public static void stopMusicLoop() {
        backgroundMusic.stop();
    }

    /**
     * Spielt ein Explosionsgeräusch ab mit einer bestimmten Lautstärke.
     *
     * @param volume In Prozent
     */
    public static void playExplosion1(int volume) {
        explosion1.play();
        explosion1.setVolume(volume != 0 ? volume : 70);
    }

    /**
     * Kreiert ein Highscore-Screen und updated ihn auch {@link #writeHighscore()}.
     * Zeigt die Punkte des Spielers, sowie den Highscore an, und startet nach einer kurzen Verzögerung einen {@link #fullReset()}.
     */
    public static void highscoreScreen() {
        writeHighscore();

        MenuWorld menu = new MenuWorld(false, false);
        Greenfoot.setWorld(menu);
        menu.showText("Game Over! ", 163, 155);
        menu.showText("Your score: " + punkte, 163, 175);
        menu.showText("Highscore: " + readHighscore(), 163, 195);
        Greenfoot.delay(200);
        fullReset();
    }

    /**
     * Gibt den in einer datei gespeichertem Highscore zurück.
     *
     * @return Highscore
     * @see #highscoreScreen()
     */
    public static Integer readHighscore() {
        try {
            return Integer.parseInt(Files.readString(Path.of("highscore")));
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * Schreibt den aktuellen Score als Highscore in eine Datei, wenn dieser höher ist.
     */
    public static void writeHighscore() {
        if (punkte <= readHighscore()) return;

        try {
            Files.writeString(Path.of("highscore"), Integer.toString(punkte));
        } catch (IOException e) {
            System.out.println("Failed to write highscore: " + e);
        }
    }

    /**
     * Soft reset für, wenn alle Spiele abgeschlossen sind.
     *
     * @see #initialiseLevelSelect()
     * @see #fullReset()
     */
    public static void softReset() {
        isLightCyclesCompleted = false;
        isGridBugsCompleted = false;
        GameManager.initialiseLevelSelect();
    }

    /**
     * Initialisiert den Level Select und die dazugehörende Welt, und führt gegebenenfalls ein {@link #softReset()} durch.
     */
    public static void initialiseLevelSelect() {
        if (isLightCyclesCompleted && isGridBugsCompleted) {
            softReset();
        }
        Greenfoot.setWorld(new MenuWorld(!isLightCyclesCompleted, !isGridBugsCompleted));
    }

    /**
     * Initialisiert die LightCycles-Welt mit {@link #levelLightCycles} als Level.
     */
    public static void initialiseLightCycles() {
        Greenfoot.setWorld(new LightCycles(levelLightCycles));
    }

    /**
     * Initialisiert die GridBugs-Welt mit {@link #levelGridBugs} als Level
     */
    public static void initialiseGridBugs() {
        Greenfoot.setWorld(new GridBugs(levelGridBugs));
    }

    /**
     * Punkte werden um change addiert.
     *
     * @param change Die Menge an Punkten die addiert wird.
     */
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
