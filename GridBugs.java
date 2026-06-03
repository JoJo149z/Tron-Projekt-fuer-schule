import greenfoot.Greenfoot;

/**
 * Write a description of class GridBugs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridBugs extends WorldTemplate {

    /**
     * Welt für das Spiel GridBugs
     */

    public int playerX; // X-Position des Spielers
    public int playerY; // Y-Position des Spielers

    public int time; // Zeit, die dem Spieler noch bleibt um das Ziel zu erreichen
    public int timeTimer = 0;

    public boolean levelFinished;
    public boolean playerIsDead;

    public int level;

    public GridBugs(int level) {
        // Initialisiert die Welt für das jeweilige Level
        this.level = level;

        levelFinished = false;

        addPlayer();

        addGoal();

        switch (level) {  // erstellt das Setup für das jeweilige Level
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
                level = 3; // stellt das Level auf 3 zurück, da es nur 3 Level gibt
                addSetupLevel3();
            default:
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
            time--;                   // Timer des Spielers verändert sich
        }

        if (levelFinished) {
            setBackground("Grid Bugs Hintergrund end.png"); // Verändert den Hintergrund zum Hintergrund am Ende
            showText("Du hast gewonnen", 163, 250);
        }
        if (time < 0 && !levelFinished || playerIsDead) {
            showText("Du hast verloren", 163, 250);
            Greenfoot.delay(100);
            GameManager.resetLevel(2);  
        }
    }

    public void addPlayer() {
        playerX = 163;
        playerY = 290;
        addObject(new GridBugsPlayer(), playerX, playerY);
    }

    public void addGoal() {
        addObject(new GridBugsGoal(), 163, 145);
    }

    public void addSpinne(int x, int y, int speed) {
        addObject(new GridBugsSpinne(speed), x, y);
    }

    public void setPlayerIsDead() {
        playerIsDead = true;
    }

    public void addSetupLevel1() {
        int spiderSpeed = 1;
        addSpinne(30, 180, spiderSpeed);
        addSpinne(80, 190, spiderSpeed);
        addSpinne(246, 19, spiderSpeed);
        addSpinne(296, 180, spiderSpeed);
        

        time = 150;
    }

    public void addSetupLevel2() {
        int spiderSpeed = 1;
        
        addSpinne(20, 140, spiderSpeed);
        addSpinne(40, 180, spiderSpeed);
        addSpinne(60, 150, spiderSpeed);
        addSpinne(80, 190, spiderSpeed);
        addSpinne(246, 190, spiderSpeed);
        addSpinne(266, 150, spiderSpeed);
        addSpinne(286, 180, spiderSpeed);
        addSpinne(306, 140, spiderSpeed);

        time = 130;
    }
    
    public void addSetupLevel3()  {
        int spiderSpeed = 2;
        
        addSpinne(20, 140, spiderSpeed);
        addSpinne(40, 180, spiderSpeed);
        addSpinne(60, 150, spiderSpeed);
        addSpinne(80, 190, spiderSpeed);
        addSpinne(246, 190, spiderSpeed);
        addSpinne(266, 150, spiderSpeed);
        addSpinne(286, 180, spiderSpeed);
        addSpinne(306, 140, spiderSpeed);

        time = 130;
    }
}