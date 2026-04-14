import greenfoot.Actor;
import greenfoot.Greenfoot;

public class LightCyclesBase extends Actor {

    int speed;
    String farbe;

    LightCyclesBase(int speed,  String farbe) {
        setStartDirection("down");
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
            case "right":
                setRotation(0);
            case "up":
                setRotation(270);
            case "down":
                setRotation(90);
        }
    }

    public void handelMovement() {
        checkCollision();
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

    public void checkCollision() {
        if (isTouching(ImageObject.class)){
            setImage(("LightcyclesExplosion1.png"));
            setImage(("LightcyclesExplosion2.png"));
        }
    }
}
