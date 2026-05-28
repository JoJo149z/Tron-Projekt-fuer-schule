import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class GridBugsPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridBugsPlayer extends Actor {
    /**
     * Klasse des Spielers
     * Steuert den Spieler und seine Schüsse, 
    */

    boolean stillRight = false; // Prüft, ob die rechte Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist
    boolean stillDown = false; // Prüft, ob die untere Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist
    boolean stillUp = false; // Prüft, ob die obere Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist
    boolean stillLeft = false; // Prüft, ob die linke Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist

    int speed = 1; // Geschwindigkeit des Spielers

    int leben = 200; // Leben des Spielers

    int timer = 0;

    public void act() {
        if (getWorldOfType(GridBugs.class).levelFinished) {  // Prüft, ob das spiel erfolgreich beendet wurde
            if (getY() > -30) {
                // Ermöglicht, dass der Spieler nach erfolgreichem Ende des Levels nach oben steigt
                setLocation(163, getY() - 1);
                sleepFor(1); 
            } else {
                GameManager.addLevelGridBugs(1);
                GameManager.setIsGridBugsCompleted(true);
                GameManager.initialiseLevelSelect();
            }
            return;
        }
        getWorldOfType(GridBugs.class).playerX = getX();
        getWorldOfType(GridBugs.class).playerY = getY();
        getMovement();

        getShooting();

        if (isTouching(GridBugsSpinne.class)) {
            leben -= 10;
        }

        if (leben == 0 && timer == 0) {
            setImage("Explosion Status 1.png");
            timer++;
        } else if (timer % 3 != 0) {
            timer++;
        } else if (timer == 3) {
            setImage("Explosion Status 2.png");
            timer++;
        } else if (timer == 6) {
            setImage("Explosion Status 3.png");
            timer++;
        } else if (timer == 9) {
            getWorldOfType(GridBugs.class).setPlayerIsDead();
        }

        if (isTouching(GridBugsGoal.class) && getWorldOfType(GridBugs.class).time >= 0) {
            getWorldOfType(GridBugs.class).levelFinished = true;
        }
    }

    public void getMovement() {
        // Steuert die Bewegung des Spielers
        int x = getX();
        int y = getY();
        int moveUp = 0;
        int moveDown = 0;
        int moveLeft = 0;
        int moveRight = 0;
        if (Greenfoot.isKeyDown("w")) {
            if (!(((y - speed < 230 && y - speed > 147) || (y - speed > 70 && y - speed < 113)) && x > 97 && x < 229)) { // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveUp = 1; // Bewegung nach oben
            }
        }
        if (Greenfoot.isKeyDown("y") || Greenfoot.isKeyDown("s")) {
            if (!(((y + speed < 230 && y + speed > 147) || (y + speed > 70 && y + speed < 113)) && x > 97 && x < 229)) {  // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveDown = 1; // Bewegung nach unten
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            if (!(((y < 230 && y > 147) || (y > 70 && y < 113)) && x - speed > 97 && x - speed < 229)) { // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveLeft = 1; // Bewegung nach links
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            if (!(((y < 230 && y > 147) || (y > 70 && y < 113)) && x + speed > 97 && x + speed < 229)) { // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveRight = 1; // Bewegung nach rechts
            }
        }
        setLocation(x+moveRight-moveLeft, y+moveDown-moveUp);
    }

    public void getShooting() {
        // Steuerung zum Schießen
        if (Greenfoot.isKeyDown("right")) {
            if (!stillRight) {
                shoot(0);
                stillRight = true;
            }
        } else {
            stillRight = false;
        }
        if (Greenfoot.isKeyDown("down")) {
            if (!stillDown) {
                shoot(90);
                stillDown = true;
            }
        } else {
            stillDown = false;
        }
        if (Greenfoot.isKeyDown("left")) {
            if (!stillLeft) {
                shoot(180);
                stillLeft = true;
            }
        } else {
            stillLeft = false;
        }
        if (Greenfoot.isKeyDown("up")) {
            if (!stillUp) {
                shoot(270);
                stillUp = true;
            }
        } else {
            stillUp = false;
        }
    }

    public void shoot(int rotation) {
        getWorld().addObject(new GridBugsKugel(rotation), getX() - 10, getY() - 5);
    }
}
