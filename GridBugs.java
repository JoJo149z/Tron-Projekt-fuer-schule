import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugs extends World
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
    
    public GridBugs(int level)
    {    
        super(326,349, 1);
        
        levelFinished = false;
        
        addPlayer();
        
        addGoal();
        
        switch(level){
            case 1:
                addSetupLevel1();
                break;
            default:
                level = 1;
                addSetupLevel1();
                break;
        }
    }
    
    public void act(){
        showText(Integer.toString(time), 163, 172);
        timeTimer--;
        if(timeTimer%6 == 0){
            time--;                                     // Timer des Spielers verändert sich
        }
        
        if(levelFinished){
            showText("Du hast gewonnen", 163, 250);
        }
        if(time<0){
            showText("Du hast verloren", 163, 250);
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
}