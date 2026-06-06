import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klasse der Kugeln, welche vom Spieler abgeschossen werden können um den Gegnern schaden zuzufügen
 * 
 * @author (your name) 
 * @version (06.06.2026)
 */
public class GridBugsKugel extends Actor
{
    /**
     * Steuert die abgeschossenen Kugeln und lässt sie ggf. explodieren
     */
    int rotation;   // zeigt Richtung an, in die die Kugel fliegt
    int speed = 4;  // Geschwindigkeit der Kugel
    
    // Timer für Explosionen der Kugel
    int explosionTimer = 0;
    
    public GridBugsKugel(int rotation){
        // initialisiert Kugel und setzt die Rotation der Kugel, sodass sie in die entsprechende Richtung fliegt
        this.rotation = rotation;
        setRotation(rotation);
    }
    
    public void act()
    {
        // Position der Kugel
        int x = getX();
        int y = getY();
        
        move(speed); // Bewegung der Kugel
        
        if(isAtEdge()){
            // Entfernt Kugel, wenn sie an den Rand geht
            getWorld().removeObject(this);
            return;
        }
        else if(((y<230 && y>147) || (y>70 && y<113)) && x>97 && x<229){
            // Explodiert, wenn sie gegen Rand d. zentralen Vierecks trifft
            explode();
        }
        else if(isTouching(GridBugsSpinne.class)){
            // Kugel explodiert, wenn sie Spinne trifft
            explode(); 
        }
        else if(explosionTimer != 0){
            // führt Explosion weiter, wenn sie einmal gestartet ist
            explode();
        }
    }
    
    public void explode(){
        if(explosionTimer==0){
            // Startet die Explosion und setzt das erste entsprechende Bild
            setImage("Explosion Status 1.png");
            explosionTimer++;
        }
        else if(explosionTimer%3!=0){
            // erhöht kontinuierlich den explosionTimer
            explosionTimer++;
        }
        else if(explosionTimer==3){
            // setzt das zwiete Bild der Explosion
            setImage("Explosion Status 2.png");
            explosionTimer++;
        }
        else if(explosionTimer==6){
            // setzt das dritte Bild der Explosion
            setImage("Explosion Status 3.png");
            explosionTimer++;
        }
        else if(explosionTimer==9){
            // entfernt die Kugel am Ende der Explosion
            getWorld().removeObject(this);
            return;
        }
    }
}
