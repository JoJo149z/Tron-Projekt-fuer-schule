import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridBugsSpinne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridBugsSpinne extends Actor
{
    /**
     * Act - do whatever the GridBugsSpinne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int timer = 0;
    int movingTimer = 0;
    int speed = 1;
    
    public void act()
    {
        movingTimer++;
        if(movingTimer%2==0){
            getMoving();
        }
        
        if(isTouching(GridBugsKugel.class)){
            timer++;
        }
        
        if(timer != 0){
            timer++;
        }
        
        if(timer == 6){
            getWorld().removeObject(this);
        }
    }
    
    public void getMoving(){
        int playerX = getWorldOfType(GridBugs.class).playerX;
        int playerY = getWorldOfType(GridBugs.class).playerY;
        
        int difX = playerX-getX();
        int difY = playerY-getY();
        
        if(!(getX()>95 && getX()<231 && getY()>75 && getY()<205)){
            if(isTouching(GridBugsPlayer.class)){
                if(difX<0){
                    if(difY<0){
                        setLocation(getX()+20, getY()+20);
                    } else{
                        setLocation(getX()+20, getY()-20);
                    }
                } else {
                    if(difY<0){
                        setLocation(getX()-20, getY()+20);
                    } else{
                        setLocation(getX()-20, getY()-20);
                    }
                }
            }
            
            if(difX>difY){
                if(difX>0){
                    setLocation(getX()+speed, getY());
                } else {
                    setLocation(getX(), getY()-speed);
                }
            } else {
                if(difY>0){
                    setLocation(getX(), getY()+speed);
                } else {
                    setLocation(getX()-speed, getY());
                }
            }
        } else{
            if(getX()<100){
                if(getY()>140){
                    setLocation(getX(), getY()+speed);
                } else{
                    setLocation(getX(), getY()-speed);
                }
            } else if(getX()>226){
                if(getY()>140){
                    setLocation(getX(), getY()+speed);
                } else{
                    setLocation(getX(), getY()-speed);
                }
            } else if(getY()<80){
                if(getX()>163){
                    setLocation(getX(), getY()+speed);
                } else{
                    setLocation(getX(), getY()-speed);
                }
            } else if(getY()>200){
                if(difX>163){
                    setLocation(getX()+speed, getY());
                } else{
                    setLocation(getX()-speed, getY());
                }
            }
        }
    }
}
