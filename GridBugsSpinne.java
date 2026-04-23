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
    
    public void act()
    {
        if(isTouching(GridBugsKugel.class)){
            timer++;
        }
        
        if(timer != 0){
            timer++;
        }
        
        if(timer == 6){
            getWorld().removeObject(this);
        }
    }
}
