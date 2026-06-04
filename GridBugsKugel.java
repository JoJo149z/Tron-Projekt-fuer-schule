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
    
    int explosionTimer = 0;
    
    public GridBugsKugel(int rotation){
        this.rotation = rotation;
        setRotation(rotation);
    }
    
    public void act()
    {
        // Position der Kugel
        int x = getX();
        int y = getY();
        
        move(speed);    // Bewegung der Kugel
        
        if(isAtEdge()){
            // Entfernt Kugel, wenn sie an den Rand geht
            getWorld().removeObject(this);
            Greenfoot.start();
        }
        else if(((y<230 && y>147) || (y>70 && y<113)) && x>97 && x<229){
            // Explodiert, wenn sie gegen Rand d. zentralen Vierecks trifft
            explode();
        }
        else if(isTouching(GridBugsSpinne.class)){
            explode();  // Kugel explodiert
        }
        
        if(explosionTimer != 0){
            explode(); // führt Explosion weiter, wenn sie einmal gestartet ist
        }
    }
    
    public void explode(){
        if(explosionTimer==0){
            setImage("Explosion Status 1.png");
            explosionTimer++;
        }
        else if(explosionTimer%3!=0){
            explosionTimer++;
        }
        else if(explosionTimer==3){
            setImage("Explosion Status 2.png");
            explosionTimer++;
        }
        else if(explosionTimer==6){
            setImage("Explosion Status 3.png");
            explosionTimer++;
        }
        else if(explosionTimer==9){
            getWorld().removeObject(this);
            return;
        }
    }
}
