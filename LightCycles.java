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

        super(326,349, 1);
        setPaintOrder(LightCyclesBase.class, ImageObject.class);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LightCyclesPlayer lightCyclesPlayer = new LightCyclesPlayer(1, "Blau","up");
        addObject(lightCyclesPlayer,154,273);
        LightCyclesEnemy lightCyclesEnemy = new LightCyclesEnemy(1, "Gelb", "down");
        addObject(lightCyclesEnemy,154,100);
    }
}
