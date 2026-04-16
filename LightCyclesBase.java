import greenfoot.Actor;
import greenfoot.Greenfoot;

public class LightCyclesBase extends Actor {

    int speed;
    String farbe;

    LightCyclesBase(int speed,  String farbe, String setStartDirection) {
        setStartDirection(setStartDirection);
        setImage(("Lightcycles"+farbe+".png"));
        this.farbe = farbe;
        this.speed = speed;
    }

    public void act() {
        handelMovement();
    }

    /**
     *
     * @param direction
     * as left, down, right, up
     */
    public void setStartDirection(String direction) {
        switch (direction) {
            case "left":
                setRotation(180);
                break;
            case "right":
                setRotation(0);
                break;
            case "up":
                setRotation(270);
                break;
            case "down":
                setRotation(90);
                break;
        }
    }

    public void handelMovement() {
        checkMoveCollision();
        String key = Greenfoot.getKey();
        if (key != null) {
            if ("a".equals(key)) {
                turn(-90);
            }
            if ("d".equals(key)) {
                turn(90);
            }
        }
        move(speed);
        getWorld().addObject(new ImageObject("LightcyclesTrail"+farbe+".png"), getX(), getY());
    }

    public void checkMoveCollision() {
        int x = 0;
        int y = 0;
        int Rotation = getRotation();
        switch (Rotation) {
            case 90:
                y = y + 15;
                break;
            case 180:
                x = x - 15;
                break;
            case 270:
                y = y - 15;
                break;
            case 0:
                x = x + 15;
                break;
        }
        if (getOneObjectAtOffset(x,y,ImageObject.class)!=null){
            speed = 0;
            setImage(("LightcyclesExplosion1.png"));
            setImage(("LightcyclesExplosion2.png"));
        }
    }
}
