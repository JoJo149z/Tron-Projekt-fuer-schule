import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldTemplate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTemplate extends World
{

    /**
     * Constructor for objects of class WorldTemplate.
     * 
     */
    
    
    public WorldTemplate()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(326,349, 1, false);
    }
    
    public void showScore(int x, int y){
        showText(Integer.toString(GameManager.getPunkte()), x, y);
    }
}
