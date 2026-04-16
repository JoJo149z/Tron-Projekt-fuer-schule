import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightCycles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightCycles extends World
{

    /**
     * Constructor for objects of class LightCycles.
     * 
     */
    public LightCycles()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(326,349, 1);
        //setPaintOrder(LightCyclesBase.class, ImageObject.class);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LightCyclesBase lightCyclesBase = new LightCyclesBase(1, "Blau","up");
        addObject(lightCyclesBase,154,273);
    }
}
