import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldTemplate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTemplate extends World
{

    /**
     * Constructor for objects of class WorldTemplate.
     * 
     */
    
    private int score;
    
    public WorldTemplate(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(326,349, 1, false);
        
        this.score = score;
    }
    
    public void showScore(int x, int y){
        showText(Integer.toString(score), x, y);
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public void addToScore(int x){
        score += x;
    }
}
