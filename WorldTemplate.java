import greenfoot.World;

/**
 * Template für alle Welten des Spiels.
 *
 * @author Noel & Jonathan
 * @see #started()
 * @see #stopped()
 * @see #showGameInfo()
 */
public class WorldTemplate extends World {

    /**
     * Beim start (in Greenfoot) wird die Musik gestartet.
     *
     * @see GameManager#startMusicLoop()
     * @see World#started()
     */
    @Override
    public void started() {
        super.started();
        GameManager.startMusicLoop();
    }

    /**
     * Beim stop (in Greenfoot) wird die Musik gestoppt.
     *
     * @see GameManager#stopMusicLoop()
     * @see World#stopped()
     */
    @Override
    public void stopped() {
        super.stopped();
        GameManager.stopMusicLoop();
    }

    /**
     * Constructor for objects of class WorldTemplate.
     *
     */
    public WorldTemplate() {
        // Erstellt die Welt ohne festen Rand in der Größe 326x349
        super(326, 349, 1, false);
    }

    /**
     * Zeigt die Punkte, den Highscore und die verbleibenden Leben an
     *
     * @see #showText(String, int, int)
     */
    public void showGameInfo() {
        showText(Integer.toString(GameManager.getPunkte()), 50, 50);
        showText(Integer.toString(GameManager.readHighscore()), 165, 50);
        showText("Leben: " + GameManager.getLeben(), 270, 50);
    }
}
