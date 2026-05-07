import greenfoot.Actor;

public class LightCyclesBase extends Actor {

    int speed;
    String farbe;
    boolean isDead;
    boolean isEnemy;

    /**
     *
     * @param speed             != 0
     * @param isEnemy           true/false
     * @param setStartDirection left, up, down, right
     */
    LightCyclesBase(int speed, boolean isEnemy, String setStartDirection) {
        setStartDirection(setStartDirection);
        this.farbe = isEnemy? "Gelb":"Blau";
        setImage("Lightcycles"+farbe+".png");
        this.isEnemy = isEnemy;
        this.speed = speed;
        isDead = false;
    }

    public void act() {
        handelMovement();
        if (moveCollision() && speed>0){
            death();
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

    public void handelMovement() {}

    public void death() {
            isDead = true;
            speed = 0;
            if (isEnemy) {
                GameManager.addPunkte(1000);
            } else {
                GameManager.setPunkte(0);
            }
            setImage(("LightcyclesExplosion1.png"));
            setImage(("LightcyclesExplosion2.png"));
    }
    public Boolean moveCollision(){
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = 0;
        switch (getRotation()) {
            case 90:
                y += 5;
                dy=1;
                break;
            case 180:
                x -= 5;
                dx = -1;
                break;
            case 270:
                y = y - 5;
                dy=-1;
                break;
            case 0:
                x = x + 5;
                dx = 1;
                break;
        }
        for (int i = 0; i < 3; i++) {
            if (getOneObjectAtOffset(x+i*dx, y-i*dy, ImageObject.class) != null) {
                return true;
            }
        }
        return getX() + x <= 10 || getX() + x >= 316 || getY() + y <= 55 || getY() + y >= 340;
    }
}
