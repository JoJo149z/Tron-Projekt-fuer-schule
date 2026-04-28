import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsPlayer extends Actor
{
    /**
     * Act - do whatever the GridBugsPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean stillRight = false;
    boolean stillDown = false;
    boolean stillUp = false;
    boolean stillLeft = false;
    
    int leben = 200;
    
    int timer = 0;
    
    public void act()
    {
        getWorldOfType(GridBugs.class).playerX = getX();
        getWorldOfType(GridBugs.class).playerY = getY();
        getMovement();
        
        getShooting();
        
        if(isTouching(GridBugsSpinne.class)){
            leben -= 10;
        }
        
        if(leben==0 && timer==0){
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
    
    public void getMovement(){
        // Steuerung zur Bewegung
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-1);
        } else if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-1, getY());
        } else if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+1, getY());
        } else if(Greenfoot.isKeyDown("y")){
            setLocation(getX(), getY()+1);
        }
        
    }
    
    public void getShooting(){
        // Steuerung zum Schießen
        if(Greenfoot.isKeyDown("right")){
            if(!stillRight){
                shoot(0);
                stillRight = true;
            }
        } else{
            stillRight = false;
        }
        if(Greenfoot.isKeyDown("down")){
            if(!stillDown){
                shoot(90);
                stillDown = true;
            }
        } else{
            stillDown = false;
        }
        if(Greenfoot.isKeyDown("left")){
            if(!stillLeft){
                shoot(180);
                stillLeft = true;
            }
        } else{
            stillLeft = false;
        }
        if(Greenfoot.isKeyDown("up")){
            if(!stillUp){
                shoot(270);
                stillUp = true;
            }
        } else{
            stillUp = false;
        }
    }
    
    public void shoot(int rotation){
        getWorld().addObject(new GridBugsKugel(rotation), getX()-10, getY()-5);
    }
}
