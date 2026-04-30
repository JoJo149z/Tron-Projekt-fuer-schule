import greenfoot.Actor;

public class LightCyclesBase extends Actor {

    int speed;
    String farbe;
    boolean isDead;

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
        isDead = false;
    }

    public void act() {
        handelMovement();
        if (moveCollision()){
            death();
            return;
        }
        move(speed);
        getWorld().addObject(new ImageObject("LightCyclesTrail"+farbe+".png"), getX(), getY());
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

    }

    public void death() {
            isDead = true;
            speed = 0;
            setImage(("LightcyclesExplosion1.png"));
            setImage(("LightcyclesExplosion2.png"));

    }
    public Boolean moveCollision(){
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
        if (getX()+x<=10 || getX()+x >= 316 || getY()+y<=55 || getY()+y >= 340) {
            return true;
        }
        return getOneObjectAtOffset(x, y, ImageObject.class) != null;
    }
}
