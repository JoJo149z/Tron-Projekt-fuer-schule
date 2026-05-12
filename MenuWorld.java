import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends WorldTemplate
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MenuWorld()
    { 
        addObject(new ButtonGridBugs(), 150,150);
    }
    
    public void act(){
        showScore(50, 50);
    }
}
