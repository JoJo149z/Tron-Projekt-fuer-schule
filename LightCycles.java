import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightCycles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightCycles extends World
{
    int difficulty;
    /**
     * Constructor for objects of class LightCycles.
     * 
     */
    public LightCycles(int difficulty)
    {    
        super(326,349, 1);
        this.difficulty = difficulty;
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
        if(difficulty > 1) {
            LightCyclesEnemy lightCyclesEnemy2 = new LightCyclesEnemy(1, "Gelb", "down");
            addObject(lightCyclesEnemy2, 244, 100);
            LightCyclesEnemy lightCyclesEnemy3 = new LightCyclesEnemy(1, "Gelb", "down");
            addObject(lightCyclesEnemy3, 82, 100);
        }
    }
}
