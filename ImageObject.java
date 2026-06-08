import greenfoot.Actor;

/**
 * Eine Klasse welche nur zum Bild hinzufügen gedacht ist.
 *
 * @see #ImageObject
 * @see #getImageName()
 */
public class ImageObject extends Actor {
    private final String imageName;

    /**
     * @param imageName Name des Bildes
     */
    public ImageObject(String imageName) {
        this.imageName = imageName;
        setImage(imageName);
    }

    public String getImageName() {
        return imageName;
    }
}
