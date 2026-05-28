import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugs extends WorldTemplate
{

    /**
     * Constructor for objects of class GridBugs.
     * 
     */
    
    public int playerX;
    public int playerY;
    
    public int time;
    public int timeTimer = 0;
    
    public boolean levelFinished;
    
    public int level;
    
    public GridBugs(int level)
    {   
        this.level = level;
        
        levelFinished = false;
        
        addPlayer();
        
        addGoal();
        
        switch(level){
            case 1:
                addSetupLevel1();
                break;
            case 2:
                addSetupLevel2();
                break;
            default:
                level = 1;
                addSetupLevel1();
                break;
        }
    }
    
    public void act(){
        showScore(50, 50);
        
        showText(Integer.toString(time), 163, 172); // Zeigt den Timer an
        timeTimer--;
        if(timeTimer%6 == 0 & !levelFinished){
            time--;                                     // Timer des Spielers verändert sich
        }
        
        if(levelFinished){
            setBackground("Grid Bugs Hintergrund end.png");
            showText("Du hast gewonnen", 163, 250);
        }
        if(time<0){
            showText("Du hast verloren", 163, 250);
            Greenfoot.delay(10);
            GameManager.fullReset();
        }
    }
    
    public void addPlayer(){
        playerX = 163;
        playerY = 290;
        addObject(new GridBugsPlayer(), playerX, playerY);
    }
    
    public void addGoal(){
        addObject(new GridBugsGoal(), 163, 145);
    }
    
    public void addSpinne(int x, int y){
        addObject(new GridBugsSpinne(), x, y);
    }
    
    public void addSetupLevel1(){
        addSpinne(30, 180);
        addSpinne(80, 190);
        addSpinne(246, 190);
        addSpinne(296, 180);
        
        time = 100;
    }
    
    public void addSetupLevel2() {
        addSpinne(20, 140);
        addSpinne(40, 180);
        addSpinne(60, 150);
        addSpinne(80, 190);
        addSpinne(246, 190);
        addSpinne(266, 150);
        addSpinne(286, 180);
        addSpinne(306, 140);
        
        time = 130;
    }
}