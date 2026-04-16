import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsKugel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsKugel extends Actor
{
    /**
     * Act - do whatever the GridBugsKugel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int rotation;
    int speed = 4;
    
    public GridBugsKugel(int rotation){
        this.rotation = rotation;
        setRotation(rotation);
    }
    
    public void act()
    {
        move(speed);
        
        if(isTouching(GridBugsSpinne.class)){
            getWorld().removeObject(this);
        }        
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
