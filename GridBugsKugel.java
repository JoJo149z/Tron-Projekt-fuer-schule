import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsKugel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsKugel extends Actor
{
    /**
     * Act - do whatever the GridBugsKugel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int rotation;
    int speed = 4;
    
    int timer = 0;
    
    public GridBugsKugel(int rotation){
        this.rotation = rotation;
        setRotation(rotation);
    }
    
    public void act()
    {
        move(speed);
        
        if(isAtEdge()){
            getWorld().removeObject(this);
            Greenfoot.start();
        }
        else if(isTouching(GridBugsSpinne.class) && timer==0){
            setImage("Explosion Status 1.png");
            timer++;
        }
        else if(timer%3!=0){
            timer++;
        }
        else if(timer==3){
            setImage("Explosion Status 2.png");
            timer++;
        }
        else if(timer==6){
            setImage("Explosion Status 3.png");
            timer++;
        }
        else if(timer==9){
            getWorld().removeObject(this);
        }
        
    }
}
