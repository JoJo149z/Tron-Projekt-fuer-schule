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
    
    private static int levelGridBugs = 1;
    
    private static int levelLightCycles = 1;
    
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
    
    public static void addLevelLightCycles(int change){
        levelLightCycles += change;
    }
    public static void setLevelLightCycles(int level){
        levelLightCycles = level;
    }
    public static int getLevelLightCycles(){
        return levelLightCycles;
    }
}
