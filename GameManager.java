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

    GameManager(){
        punkte = 0;
    }
    /**
     * Act - do whatever the GameManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().showText(Integer.toString(punkte),20, 20);
    }


    public static void addPunkte(int change){
        punkte += change;
    }
    public static void setPunkte(int value){
        punkte=value;
    }
}
