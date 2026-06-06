/**
 * MenuWorld ist eine World, welche so gut wie keine Spiel-UI enthält bis auf eibischen text oben.
 * MenuWorld dient als Startpunkt des Spiels, und wird als World für level Select sowie als Highscore-Screen benutzt.
 *
 * @author Jonathan
 * @see #MenuWorld(boolean, boolean)
 * @see #act()
 */
public class MenuWorld extends WorldTemplate {

    /**
     * Standardkonstruktor für MenuWorld, welcher das Spiel zurücksetzt via Greenfoot reset.
     */
    public MenuWorld() {
        GameManager.fullReset();
    }

    /**
     * Constructor for MenuWorld.
     * wenn eines der parameter true ist, dann wird auch ein {@link LevelSelector} initialisiert, da ausgegangen wird das es sich um Level Select handelt.
     *
     * @param LightCycles soll für das Level Select die LightCyclesmap/-image geladen werden?
     * @param GridBugs    soll für das Level Select die GridBugsmap/-image geladen werden?
     */
    public MenuWorld(boolean LightCycles, boolean GridBugs) {
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
        setPaintOrder(LevelSelector.class, ImageObject.class); //damit der LevelSelector über den ImageObjects liegt.
    }

    /**
     * Wenn leben größer als 0 ist, dann wird die Methode {@link #showGameInfo()} aufgerufen, welche die Punkte, den Highscore und die Leben anzeigt.
     */
    public void act() {
        if (GameManager.getLeben() > 0) {
            showGameInfo();
        }

    }
}
