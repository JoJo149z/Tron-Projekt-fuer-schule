import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsGoal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsGoal extends Actor
{
    /**
     * Act - do whatever the GridBugsGoal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(GridBugsPlayer.class) && getWorldOfType(GridBugs.class).time>=0){
            getWorldOfType(GridBugs.class).levelFinished = true;
        }
    }
}
