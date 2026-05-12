import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager
{
    static int punkte;

    public static void addPunkte(int change){
        punkte += change;
    }
    public static void setPunkte(int value){
        punkte=value;
    }
    public static int getPunkte(){
        return punkte;
    }
}
