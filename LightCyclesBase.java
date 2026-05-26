import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.ArrayList;
import java.util.List;

public class LightCyclesBase extends Actor {

    static int enemyAmount;
    int speed;
    String farbe;
    boolean isDead;
    boolean isEnemy;
    int timer;

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

    public void act() {
        timer += 1;
        if (timer < 10) {
            return;
        } else if (timer == 10) {
            Greenfoot.getKey(); //clear key buffer
        }

        // enemyAmount konfigurieren
        List<LightCyclesBase> enemysList = new ArrayList<>(getWorld().getObjects(LightCyclesEnemy.class));
        enemyAmount = enemysList.size();

        if (!isDead) {
            handelMovement();
        }
        if (enemyAmount == 0) {
            if (GameManager.getLevelLightCycles() <= 5) {
                GameManager.addLevelLightCycles(1);
            }
            GameManager.setIsLightCyclesCompleted(true);
            GameManager.initialiseLevelSelect();
        }
        if (moveCollision()) {
            death();
            return;
        }
        move(speed);
        getWorld().addObject(new ImageObject("LightcyclesTrail" + farbe + ".png"), getX(), getY());
    }

    /**
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

    public void death() {
        isDead = true;
        speed = 0;
        setImage(("LightcyclesExplosion1.png"));
        Greenfoot.delay(5);
        setImage(("LightcyclesExplosion2.png"));
        if (isEnemy) {
            GameManager.addPunkte(1000);
        } else {
            Greenfoot.delay(10);
            GameManager.fullReset();
        }
        getWorld().removeObject(this);
    }

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
