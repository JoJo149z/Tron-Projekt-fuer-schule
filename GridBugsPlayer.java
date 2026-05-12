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

    int speed = 1;
    
    int leben = 200;
    
    int timer = 0;
    
    public void act()
    {
        if(getWorldOfType(GridBugs.class).levelFinished){
            if(getY()>-30){
                setLocation(163, getY()-1);
                sleepFor(1);
            } else {
                GameManager.addLevelGridBugs(1);
                Greenfoot.setWorld(new MenuWorld());
            }
            return;
        }
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
            return;
        }
        
        if(isTouching(GridBugsGoal.class) && getWorldOfType(GridBugs.class).time>=0){
            getWorldOfType(GridBugs.class).levelFinished = true;
        }
    }
    
    public void getMovement(){
        // Steuerung zur Bewegung
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("w")){
            if(!(((y-speed < 230 && y-speed > 147) || (y-speed > 70 && y-speed < 113)) && x > 97 && x < 229)) {  // damit nicht im mittleren Kasten
                setLocation(x, y-1);
            }
        }
        if(Greenfoot.isKeyDown("y")){
            if(!(((y+speed < 230 && y+speed > 147) || (y+speed > 70 && y+speed < 113)) && x > 97 && x < 229)) {  // damit nicht im mittleren Kasten
                setLocation(x, y+1);
            }
        }
        if(Greenfoot.isKeyDown("a")){
            if(!(((y < 230 && y > 147) || (y > 70 && y < 113)) && x-speed > 97 && x-speed < 229)) {
                setLocation(x-speed, y);
            }
        }
        if(Greenfoot.isKeyDown("d")) {
            if (!(((y < 230 && y > 147) || (y > 70 && y < 113)) && x + speed > 97 && x + speed < 229)) {
                setLocation(x + speed, y);
            }
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
