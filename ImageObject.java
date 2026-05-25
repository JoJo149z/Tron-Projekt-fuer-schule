import greenfoot.Actor;

public class ImageObject extends Actor {
    private final String imageName;

    public ImageObject(String imageName) {
        this.imageName = imageName;
        setImage(imageName);
    }

    public String getImageName() {
        return imageName;
    }
}
