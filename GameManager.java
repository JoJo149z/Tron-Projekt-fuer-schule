import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager extends Actor
{
    static int punkte;

    /**
     *
     * @param testGame 0-nichts, 1-LightCycles, 2-GridBugs
     */
    GameManager(int testGame, int level){
        setImage("null.png");
        punkte = 0;
        switch(testGame){
            case 1:
                Greenfoot.setWorld(new LightCycles(level));
               break;
            case 2:
                Greenfoot.setWorld(new GridBugs(level));
                break;
        }
    }
    /**
     * Act - do whatever the GameManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }

    public void showPunkte(int x, int y){
        getWorld().showText(Integer.toString(punkte), x, y);
    }

    public static void addPunkte(int change){
        punkte += change;
    }
    public static void setPunkte(int value){
        punkte=value;
    }
}
