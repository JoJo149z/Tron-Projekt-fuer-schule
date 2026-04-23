import greenfoot.Actor;
import greenfoot.Greenfoot;

public class LightCyclesBase extends Actor {

    int speed;
    String farbe;

    /**
     *
     * @param speed             != 0
     * @param farbe             Gelb/Blau
     * @param setStartDirection left, up, down, right
     */
    LightCyclesBase(int speed, String farbe, String setStartDirection) {
        setStartDirection(setStartDirection);
        this.farbe = farbe;
        this.speed = speed;
    }

    public void act() {
        checkMoveCollision();
        handelMovement();
        getWorld().addObject(new ImageObject("LightcyclesTrail"+farbe+".png"), getX(), getY());
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
        move(speed);
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
