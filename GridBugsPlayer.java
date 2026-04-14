import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsPlayer extends Actor
{
    /**
     * Act - do whatever the GridBugsPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-1);
        } else if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-1, getY());
        } else if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+1, getY());
        } else if(Greenfoot.isKeyDown("y")){
            setLocation(getX(), getY()+1);
        }
    }
}
