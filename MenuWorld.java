import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MenuWorld()
    {    
        super(326,349, 1); 

        addObject(new ButtonGridBugs(), 150,150);
    }
}
