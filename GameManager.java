import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager
{
    private static int punkte;
    
    private static int levelGridBugs;
    
    public static void addPunkte(int change){
        punkte += change;
    }
    public static void setPunkte(int value){
        punkte = value;
    }
    public static int getPunkte(){
        return punkte;
    }
    
    public static void addLevelGridBugs(int change){
        levelGridBugs += change;
    }
    public static void setLevelGridBugs(int level){
        levelGridBugs = level;
    }
    public static int getLevelGridBugs(){
        return levelGridBugs;
    }
}
