import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsSpinne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsSpinne extends Actor
{
    /**
     * Act - do whatever the GridBugsSpinne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int timer = 0;
    int speed = 1;
    
    public void act()
    {
        if(isTouching(GridBugsKugel.class)){
            timer++;
        }
        
        if(isTouching(GridBugsPlayer.class)){
            move(-10);
        }
        
        if(timer != 0){
            timer++;
        }
        
        if(timer == 6){
            getWorld().removeObject(this);
        }
        
        getMoving();
    }
    
    public void getMoving(){
        int playerX = getWorldOfType(GridBugs.class).playerX;
        int playerY = getWorldOfType(GridBugs.class).playerY;
        
        int difX = playerX-getX();
        int difY = playerX-getY();
        
        if(difX>difY && difX>0){
            setLocation(getX()+speed, getY());
        }
    }
}
