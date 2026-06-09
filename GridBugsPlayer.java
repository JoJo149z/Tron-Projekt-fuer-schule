import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class GridBugsPlayer here.
 *
 * @author (your name)s
 * @version (a version number or a date)
 */
public class GridBugsPlayer extends Actor {
    /**
     * Klasse des Spielers.
     * Steuert den Spieler, seine Bewegungen, seine Leben und seine Schüsse
     *
     */

    boolean stillRight = false; // Prüft, ob die rechte Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist
    boolean stillDown = false; // Prüft, ob die untere Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist
    boolean stillUp = false; // Prüft, ob die obere Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist
    boolean stillLeft = false; // Prüft, ob die linke Pfeiltaste nach Schuss des Spielers noch immer gedrückt ist

    boolean mouseStillDown = false;  // prüft, ob die Maus immernoch gedrückt ist
    
    int speed = 1; // Geschwindigkeit des Spielers

    int leben = 100; // Leben des Spielers

    int deathTimer = 0;

    public void act() {
        // Verhalten, falls das Level erfolgreich abgeschlossen wurde
        if (getWorldOfType(GridBugs.class).levelFinished) {  // Prüft, ob das spiel erfolgreich beendet wurde
            if (getY() > -30) {
                // Ermöglicht, dass der Spieler nach erfolgreichem Ende des Levels nach oben steigt
                setLocation(163, getY() - 2);
                sleepFor(1);
            } else {
                GameManager.addLevelGridBugs(1);  // erhöht das GridBugs Level
                GameManager.addPunkte(getWorldOfType(GridBugs.class).time * 10 + leben);  // erhöht die Punkte des Spielers
                GameManager.setIsGridBugsCompleted(true);   // speichert, dass GridBugs erfolgreich gemeistert wurde
                GameManager.initialiseLevelSelect();    // führt zurück zur Menu-World
            }
            return;
        }
        // speichert Position des Spielers in GridBugsWorld
        getWorldOfType(GridBugs.class).playerX = getX();
        getWorldOfType(GridBugs.class).playerY = getY();

        getMovement();  // prüft, ob sich der Spieler bewegen muss und führt diese Bewegungen ggf. aus

        getShooting();  // prüft ob Spieler schießen muss und führt den Schuss ggf. aus

        if (isTouching(GridBugsSpinne.class)) {
            leben -= 10;    //  Zieht Leben ab bei Beührung mit einer Spinne
        }

        if (leben == 0 && deathTimer == 0) {
            // setzt die Explosion des Spielers bei 0 Leben in Gang und erzeugt erstes Bild der Explosion
            setImage("Explosion Status 1.png");
            deathTimer++;
        } else if (deathTimer % 3 != 0) {
            // erhöht den deathTimer für eine langsamere Explosion als wenn die Bilder bei jedem act ändern würden
            deathTimer++;
        } else if (deathTimer == 3) {
            // setzt 2. Bild der Explosion
            setImage("Explosion Status 2.png");
            deathTimer++;
        } else if (deathTimer == 6) {
            // setzt 3. Bild der Explosion
            setImage("Explosion Status 3.png");
            deathTimer++;
        } else if (deathTimer == 9) {
            // Gibt der GridBugsWorld die Information über den Tod des Spielers
            getWorldOfType(GridBugs.class).playerIsDead = true;
        }

        if (isTouching(GridBugsGoal.class) && getWorldOfType(GridBugs.class).time >= 0) {
            // Gibt der GridBugsWorld die Information, wenn der Spieler das Ziel vor dem Ablaufen der Zeit erreicht hat.
            getWorldOfType(GridBugs.class).levelFinished = true;
        }
    }

    public void getMovement() {
        /**
         * prüft, ob sich der Spieler bewegen muss und führt diese Bewegungen ggf. aus
         */

        // Position des Spielers
        int x = getX();
        int y = getY();

        // halten Fest, welche Bewegungen ausgeführt werden müssen
        int moveUp = 0;
        int moveDown = 0;
        int moveLeft = 0;
        int moveRight = 0;
        if (Greenfoot.isKeyDown("w")) {
            if (!(((y - speed < 230 && y - speed > 147) || (y - speed > 70 && y - speed < 113)) && x > 97 && x < 229) && y > 20) { // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveUp = 1; // Bewegung nach oben
            }
        }
        if (Greenfoot.isKeyDown("y") || Greenfoot.isKeyDown("s")) {
            if (!(((y + speed < 230 && y + speed > 147) || (y + speed > 70 && y + speed < 113)) && x > 97 && x < 229) && y < 329) {  // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveDown = 1; // Bewegung nach unten
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            if (!(((y < 230 && y > 147) || (y > 70 && y < 113)) && x - speed > 97 && x - speed < 229) && x > 5) { // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveLeft = 1; // Bewegung nach links
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            if (!(((y < 230 && y > 147) || (y > 70 && y < 113)) && x + speed > 97 && x + speed < 229) && x < 321) { // damit der Spieler nicht durch die Wände des zentralen Vierecks laufen kann
                moveRight = 1; // Bewegung nach rechts
            }
        }
        setLocation(x + moveRight - moveLeft, y + moveDown - moveUp);   // führt Bewegungen aus
    }

    public void getShooting() {
        /**
         * prüft ob Spieler schießen muss und führt den Schuss ggf. aus
         */

        if (Greenfoot.mousePressed(null)){
            if(!mouseStillDown){    // damit nur einmal pro Klick geschossen wird
                // Position der Maus
                int mouseX = Greenfoot.getMouseInfo().getX();
                int mouseY = Greenfoot.getMouseInfo().getY();
                
                // Unterschiede zwischen Maus und Spieler
                int difX = mouseX-getX();
                int difY = mouseY-getY();
                
                // berechnet die Rotation, die die Kugeln haben müssen, um in die richtige Richtung zu schießen
                int rotation = (int) Math.toDegrees(Math.atan2(difY, difX));
                
                // erzeugt die Kugel mit entsprechender Rotation
                shoot(rotation);
                
                // gibt an, dass gerade geschossen wurde, dass im nächsten act nicht direkt
                // nochmal geschossen werden kann
                mouseStillDown = true;
            }
        } else{
            // gibt an, dass in diesem act noch nicht geschossen wurde,
            // sodass im nächsten act wieder geschossen werden kann
            mouseStillDown = false;
        }
        /**
         * folgender Code könnte auskommentiert werden,
         * um es zu ermöglichen mit den Pfeiltasten zu schießen
           */
        /* if (Greenfoot.isKeyDown("right")) {
            if (!stillRight) {  // prüft, ob Taste erstes mal gedrückt wurde oder im act zuvor auch schon (damit immer nur eine Kugel abgeschossen wird)
                shoot(0);   // Schuss nach rechts
                stillRight = true;  // speichert, dass in diesem act geschossen wurde
            }
        } else {
            stillRight = false; // speichert, dass in diesem act nicht geschossen wurde
        }
        if (Greenfoot.isKeyDown("down")) {
            if (!stillDown) {   // prüft, ob Taste erstes mal gedrückt wurde oder im act zuvor auch schon (damit immer nur eine Kugel abgeschossen wird)
                shoot(90);  // Schuss nach unten
                stillDown = true;   // speichert, dass in diesem act geschossen wurde
            }
        } else {
            stillDown = false;  // speichert, dass in diesem act nicht geschossen wurde
        }
        if (Greenfoot.isKeyDown("left")) {
            if (!stillLeft) {   // prüft, ob Taste erstes mal gedrückt wurde oder im act zuvor auch schon (damit immer nur eine Kugel abgeschossen wird)
                shoot(180); // Schuss nach links
                stillLeft = true;   // speichert, dass in diesem act geschossen wurde
            }
        } else {
            stillLeft = false;  // speichert, dass in diesem act nicht geschossen wurde
        }
        if (Greenfoot.isKeyDown("up")) {    // prüft, ob Taste erstes mal gedrückt wurde oder im act zuvor auch schon (damit immer nur eine Kugel abgeschossen wird)
            if (!stillUp) {
                shoot(270); // Schuss nach oben
                stillUp = true; // speichert, dass in diesem act geschossen wurde
            }
        } else {
            stillUp = false;    // speichert, dass in diesem act nicht geschossen wurde
        }*/
    }

    public void shoot(int rotation) {
        /**
         * erzeugt eine Kugel mit der entsprechenden Rotation, sodass sie in die richtige Richtung fliegt
         */

        getWorld().addObject(new GridBugsKugel(rotation), getX() - 10, getY() - 5);
    }
}
