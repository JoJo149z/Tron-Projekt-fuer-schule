import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.ArrayList;
import java.util.List;

/**
 * Eine base Klasse für die Lightcycles um redundanten Code zu vermeiden, da Spieler und Gegner sich in vielen Punkten ähnlich verhalten.
 *
 * @author Jonathan
 * @see #act()
 * @see #startAnimation()
 * @see #setStartDirection(String)
 * @see #death()
 * @see #moveCollision()
 */
public class LightCyclesBase extends Actor {

    static int enemyAmount;
    int speed;
    String farbe;
    boolean isDead;
    boolean isEnemy;
    int timer;
    int deathBuffer = 0;

    /**
     *
     * @param speed             != 0
     * @param isEnemy           true/false
     * @param setStartDirection left, up, down, right
     */
    LightCyclesBase(int speed, boolean isEnemy, String setStartDirection) {
        setStartDirection(setStartDirection);
        this.farbe = isEnemy ? "Gelb" : "Blau";
        setImage("Lightcycles" + farbe + ".png");
        this.isEnemy = isEnemy;
        this.speed = speed;
        isDead = false;
        timer = 0;
    }

    /**
     * kümmert sich um die Logik beim Besiegen aller Gegner, sowie das Spawnen der Trails, die die Lightcycles hinterlassen.
     */
    public void act() {
        if (startAnimation()) {
            return;
        }

        // enemyAmount konfigurieren
        List<LightCyclesBase> enemysList = new ArrayList<>(getWorld().getObjects(LightCyclesEnemy.class));
        enemyAmount = enemysList.size();

        if (enemyAmount == 0) {
            if (GameManager.getLevelLightCycles() <= 5) {
                GameManager.addLevelLightCycles(1);
            }
            GameManager.setIsLightCyclesCompleted(true);
            GameManager.initialiseLevelSelect();
        }
        //trail spawnen
        getWorld().addObject(new ImageObject("LightcyclesTrail" + farbe + ".png"), getX(), getY());
    }

    /**
     * Startanimation mit Countdown, damit der Spieler sich auf den Start vorbereiten kann, sowie dass löschen des Keybuffers.
     *
     * @return true, wenn die Animation noch läuft, false, wenn sie vorbei ist
     */
    protected boolean startAnimation() {
        timer += 1;
        if (timer < 40) {
            switch (timer / 10) {
                case 3 -> getWorld().showText("GO!", 163, 175);
                case 2 -> getWorld().showText("3", 163, 175);
                case 1 -> getWorld().showText("2", 163, 175);
                default -> getWorld().showText("1", 163, 175);
            }
            return true;
        } else if (timer == 40) {
            Greenfoot.getKey(); //clear key buffer aber nur nach dem kurzen delay
            getWorld().showText(null, 163, 175);
        }
        return false;

    }

    /**
     * setzt die Startrotation der Lightcycle, damit sie beim Start die richtige Richtung schauen
     *
     * @param direction as left, down, right, up
     */
    public void setStartDirection(String direction) {
        switch (direction) {
            case "left":
                setRotation(180);
                break;
            case "right":
                setRotation(0);
                break;
            case "up":
                setRotation(270);
                break;
            case "down":
                setRotation(90);
                break;
        }
    }

    public void handelMovement() {
    }

    /**
     * kümmert sich um die Animation und Logik bzw. Konsequenzen des Todes von Lightcycles.
     */
    public void death() {
        isDead = true;
        speed = 0;
        setImage(("LightcyclesExplosion1.png"));
        Greenfoot.delay(5);
        setImage(("LightcyclesExplosion2.png"));
        if (isEnemy) {
            GameManager.addPunkte(500);
        } else {
            Greenfoot.delay(10);
            GameManager.resetLevel(1);
        }
        getWorld().removeObject(this);
    }

    /**
     * prüft, ob die Lightcycle in der nächsten Bewegung mit einem Trail oder einer Wand kollidieren würde, wenn sie sich in die aktuelle Richtung weiterbewegt.
     *
     * @return true, wenn eine Kollision stattfinden würde, false, wenn nicht.
     */
    public Boolean moveCollision() {
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = 0;
        switch (getRotation()) {
            case 90:
                y = 5;
                dy = 1;
                break;
            case 180:
                x = -5;
                dx = -1;
                break;
            case 270:
                y = -5;
                dy = -1;
                break;
            case 0:
                x = 5;
                dx = 1;
                break;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = -2; j < 2; j++) {
                if (getOneObjectAtOffset(x + i * dx + j * Math.abs(dy), y - i * dy + j * Math.abs(dx), ImageObject.class) != null) {
                    return true;
                }
            }

        }
        return getX() + x <= 10 || getX() + x >= 316 || getY() + y <= 55 || getY() + y >= 340;
    }
}
