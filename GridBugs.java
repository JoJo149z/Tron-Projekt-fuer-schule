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
    public GridBugs(int level)
    {    
        super(326,349, 1);
        
        addPlayer();
        
        switch(level){
            case 1:
                addSetupLevel1();
            default:
                level = 1;
                addSetupLevel1();
                break;
        }
    }
    
    public void addPlayer(){
        addObject(new GridBugsPlayer(), 163, 290);
    }
    
    public void addSpinne(int x, int y){
        addObject(new GridBugsSpinne(), x, y);
    }
    
    public void addSetupLevel1(){
        addSpinne(30, 180);
        addSpinne(80, 190);
        addSpinne(246, 190);
        addSpinne(296, 180);
    }
}