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
    
    int deathTimer = 0;
    int movingTimer = 0;
    int cloningTimer = 0;
    int speed;  // Geschwindigkeit der Spinne
    int backPushPlayer = 7; // wie stark eine Spinne von dem Player verschoben werden kann
    int backPushSpider = 1; // wie stark eine Spinne von einer Spinne verschoben werden kann
    
    public GridBugsSpinne(int speed){
        this.speed = speed; // Initialisiert eine neue Spinne mit der entsprechenden Geschwindigkeit
    }
    
    public void act()
    {
        movingTimer++;
        if(movingTimer%2==0){
            getMoving();        // bewegt sich nur alle 2 acts (für bessere Regulation der Geschwindigkeit)
        }
        
        if(isTouching(GridBugsKugel.class)){
            deathTimer++;   // setzt deathTimer auf 1
        }
        
        if(deathTimer != 0){
            deathTimer++;   // beginnt, wenn von Kugel berührt
        }
        
        if(deathTimer == 6){
            // Spinne explodiert 6 acts nach Berührung mit der Kugel
            GameManager.addPunkte(10);
            getWorld().removeObject(this);
            return;
        }
        
        cloningTimer++;
        if((cloningTimer+1)%30==0){
            int randomNumber = Greenfoot.getRandomNumber(10);
            if(randomNumber == 0){
                cloneSpider();
            }
        }
        
        // Holt Position des Spielers
        int playerX = getWorldOfType(GridBugs.class).playerX;
        int playerY = getWorldOfType(GridBugs.class).playerY;
        
        // Position der Spinne selbst
        int x = getX();
        int y = getY();
        
        // Unterschiede der Positionen von Spinne und Spieler in X- und Y-Richtung
        int difX = playerX-x;
        int difY = playerY-y;
        
        // Spinne springt zurück, wenn sie einen Spieler berührt
        if(!(x+backPushPlayer>100 && x-backPushPlayer<226 && y+backPushPlayer>75 && y-backPushPlayer<200)){     // Passt auf, dass Spinne nicht durch die Wand des Vierecks zurückgeworfen wird
            /**
             * wirft die Spinne nach berührung  mit dem Spieler zurück, sodass immer nur einmal Leben abgezogen werden
               */
            if(isTouching(GridBugsPlayer.class)){
                if(difX<=0){
                    if(difY<=0){
                        setLocation(x+backPushPlayer, y+backPushPlayer);
                    } else{
                        setLocation(x+backPushPlayer, y-backPushPlayer);
                    }
                } else {
                    if(difY<=0){
                        setLocation(x-backPushPlayer, y+backPushPlayer);
                    } else{
                        setLocation(x-backPushPlayer, y-backPushPlayer);
                    }
                }
            }
        }
    }
    
    public void getMoving(){
        // Holt Position des Spielers
        int playerX = getWorldOfType(GridBugs.class).playerX;
        int playerY = getWorldOfType(GridBugs.class).playerY;
        
        // Position der Spinne selbst
        int x = getX();
        int y = getY();
        
        // Unterschiede der Positionen von Spinne und Spieler in X- und Y-Richtung
        int difX = playerX-x;
        int difY = playerY-y;
        
        if(x+speed>100 && x-speed<226 && y+speed>75 && y-speed<200){ // Falls am Rand des Vierecks (Damit Spinne nicht in die Wand des zentralen Vierecks kommt)
            if(x<100){
                if(y>=140){
                    setLocation(x, y+speed);
                } else{
                    setLocation(x, y-speed);
                }
            } else if(x>=226){
                if(y>140){
                    setLocation(x, y+speed);
                } else{
                    setLocation(x, y-speed);
                }
            } else if(y<=80){
                if(x>163){
                    setLocation(x, y+speed);
                } else{
                    setLocation(x, y-speed);
                }
            } else if(y>=200){
                if(difX>163){
                    setLocation(x+speed, y);
                } else{
                    setLocation(x-speed, y);
                }
            }
        } else{ // falls nicht am Rand des zentralen Vierecks
            // Spinne bewegt sich immer in die Richtung (x oder y) in der sie weiter entfernt vom Spieler ist
            if(difX>difY){
                if(difX>0){
                    setLocation(x+speed, y);
                } else {
                    setLocation(x, y-speed);
                }
            } else {
                if(difY>0){
                    setLocation(x, y+speed);
                } else {
                    setLocation(x-speed, y);
                }
            }
        }
    }
    
    public void pushBack(){
        int x = getX();
        int y = getY();
        if((movingTimer)%4==0){
            if(!(x+backPushSpider>100 && x-backPushSpider<226 && y+backPushSpider>75 && y-backPushSpider<200)){
                if(isTouching(GridBugsSpinne.class)){
                    double randomNumber = Math.random();
                    if(randomNumber<0.25){
                        setLocation(x+backPushSpider, y+backPushSpider);
                    } else if (randomNumber<0.5){
                        setLocation(x+backPushSpider, y-backPushSpider);
                    } else if (randomNumber<0.75){
                        setLocation(x-backPushSpider, y+backPushSpider);
                    } else {
                        setLocation(x-backPushSpider, y-backPushSpider);
                    }
                }
            }
        }
    }
    
    public void cloneSpider(){
        int x = getX();
        int y = getY();
        
        int cloneBackPush = 20;
        if(!(x+cloneBackPush>100 && x-cloneBackPush<226 && y+cloneBackPush>75 && y-cloneBackPush<200)){
            getWorldOfType(GridBugs.class).addSpinne(getX()+20, getY(), speed);
            setLocation(x-20, y);
        }
    }
}
