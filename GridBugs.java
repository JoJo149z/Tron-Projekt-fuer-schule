import greenfoot.Greenfoot;

/**
 * Write a description of class GridBugs here.
 *
 * @author ()
 * @version (06.06.2026)
 */
public class GridBugs extends WorldTemplate {

    /**
     * Welt für das Spiel GridBugs
     * - baut das Setup für die Level auf
     * - zeigt den Timer an
     */

    // Position des Spielers
    public int playerX;
    public int playerY;

    public int time; // Zeit, die dem Spieler noch bleibt um das Ziel zu erreichen
    public int timeTimer = 0;  // Timer der läuft, um time zu verlangsamen

    public boolean levelFinished;   // zeigt an, ob der Spieler das Level erfolgreich beendet hatie Mitte erreicht hat
    public boolean playerIsDead;

    public int level;   // aktuelles Level des Spiels

    public GridBugs(int level) {
        // Initialisiert die Welt für das jeweilige Level
        this.level = level;

        // zeigt an, ob der Spieler schon in der Mitte ist
        levelFinished = false;

        addPlayer();

        addGoal();

        switch (level) {
            /*
             * ruft je nach Level die passende Funktion auf
             * um das Setup herzustellen
               */
            case 1:
                addSetupLevel1();
                break;
            case 2:
                addSetupLevel2();
                break;
            case 3:
                addSetupLevel3();
                break;
            case 4: 
                // stellt das Level auf 3 zurück, da es nur 3 Level gibt
                level = 3;
                addSetupLevel3();
                break;
            default:
                // stellt das Level im Zweifelsfall auf 1 zurück
                level = 1;
                addSetupLevel1();
                break;
        }
    }

    public void act() {
        showGameInfo(); // Zeigt die aktuellen Punkte des Spielers an

        showText(Integer.toString(time), 163, 172); // Zeigt den Timer an
        timeTimer--;
        if (timeTimer % 6 == 0 & !levelFinished) {  // ermöglicht einen langsameren Timer
            time--;                   // Timer des Spielers sinkt um 1 nach unten
        }

        if (levelFinished) {
            /* Verändert den Hintergrund zum Hintergrund am Ende
               */
            setBackground("Grid Bugs Hintergrund end.png");
            showText("Du hast gewonnen", 163, 250);
        }
        if (time < 0 && !levelFinished || playerIsDead) {
            // erzeugt reset des Levels, falls noch Leben vorhanden sind
            showText("Du hast verloren", 163, 250);
            removeObjects(getObjects(GridBugsKugel.class));
            removeObjects(getObjects(GridBugsPlayer.class));
            removeObjects(getObjects(GridBugsSpinne.class));
            Greenfoot.delay(100);
            GameManager.resetLevel(2);  
        }
    }

    public void addPlayer() {
        // initialisiert Spieler
        playerX = 163;
        playerY = 290;
        addObject(new GridBugsPlayer(), playerX, playerY);
    }

    public void addGoal() {
        /* 
         * initialisiert ein unsichtbares Objekt in der Mitte
         * des zentralen Vierecks, welches erreicht werden
         * muss, um das Level zu bestehen
           */
        addObject(new GridBugsGoal(), 163, 145);
    }

    public void addSpinne(int x, int y, int speed) {
        // erstellt eine neue Spinne bei (x, y) mit der Geschwindigkeit speed
        addObject(new GridBugsSpinne(speed), x, y);
    }

    public void addSetupLevel1() {
        // erzeugt das Setup für Level 1
        int spiderSpeed = 1; // Geschwindigkeit der Spinnen
        
        addSpinne(30, 180, spiderSpeed);
        addSpinne(80, 190, spiderSpeed);
        addSpinne(246, 19, spiderSpeed);
        addSpinne(296, 180, spiderSpeed);
        
        // legt fest, wie lange der Spieler Zeit hat
        time = 500;
    }

    public void addSetupLevel2() {
        // erzeugt das Setup für Level 2
        int spiderSpeed = 1;  // Geschwindigkeit der Spinnen
        
        addSpinne(20, 140, spiderSpeed);
        addSpinne(40, 180, spiderSpeed);
        addSpinne(60, 150, spiderSpeed);
        addSpinne(80, 190, spiderSpeed);
        addSpinne(246, 190, spiderSpeed);
        addSpinne(266, 150, spiderSpeed);
        addSpinne(286, 180, spiderSpeed);
        addSpinne(306, 140, spiderSpeed);

        // legt fest, wie lange der Spieler Zeit hat
        time = 130;
    }
    
    public void addSetupLevel3()  {
        // erzeugt das Setup für Level 3
        int spiderSpeed = 2;  // Geschwindigkeit der Spinnen
        
        addSpinne(20, 140, spiderSpeed);
        addSpinne(40, 180, spiderSpeed);
        addSpinne(60, 150, spiderSpeed);
        addSpinne(80, 190, spiderSpeed);
        addSpinne(246, 190, spiderSpeed);
        addSpinne(266, 150, spiderSpeed);
        addSpinne(286, 180, spiderSpeed);
        addSpinne(306, 140, spiderSpeed);

        // legt fest, wie lange der Spieler Zeit hat
        time = 130;
    }
}