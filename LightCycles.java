import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightCycles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightCycles extends WorldTemplate
{
    int difficulty;
    /**
     * Constructor for objects of class LightCycles.
     * 
     */
    public LightCycles(int score, int difficulty)
    {
        super(score);
        this.difficulty = difficulty;
        setPaintOrder(LightCyclesBase.class, ImageObject.class);
        prepare();
    }
    
    public void act(){
        showScore(50, 50);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LightCyclesPlayer lightCyclesPlayer = new LightCyclesPlayer(1, false,"up");
        addObject(lightCyclesPlayer,154,273);
        LightCyclesEnemy lightCyclesEnemy = new LightCyclesEnemy(1, true, "down");
        addObject(lightCyclesEnemy,154,100);
        if(difficulty > 1) {
            LightCyclesEnemy lightCyclesEnemy2 = new LightCyclesEnemy(1, true, "down");
            addObject(lightCyclesEnemy2, 244, 100);
            LightCyclesEnemy lightCyclesEnemy3 = new LightCyclesEnemy(1, true, "down");
            addObject(lightCyclesEnemy3, 82, 100);
        }
    }
}
