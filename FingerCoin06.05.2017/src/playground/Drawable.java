package playground;
/**
 * This interface contains methods for drawable classes of the Finger Coin game's model classes.
 * @author Ceyhun Emre Öztürk
 * @version 28.04.2017
 */
public interface Drawable{
   
   public double getX();
   
   public double getY();
   
   public boolean contains( double xC, double yC);
}
