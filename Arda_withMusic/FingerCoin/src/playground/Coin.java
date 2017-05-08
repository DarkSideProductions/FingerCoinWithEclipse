package playground;
/**
 * This class simulates the coins of the Finger Coin game.
 * @author Ceyhun Emre Öztürk
 * @version 28.04.2017
 */
public class Coin implements Drawable{
   
   //properties
   private final double RADIUS = 20;
   private final double MASS = 0.01;
   
   private double x;
   private double y;
   private double velocityX;
   private double velocityY;
   private boolean chosen;
   
   /**
    * Constructor
    * @param x is the given x coordinate
    * @param y is the given y coordinate
    */
   public Coin( double x, double y) {
      
      this.x = x;
      this.y = y;
      velocityX = 0;
      velocityY = 0;
      chosen = false;
   }
   
   /**
    * Gets the x coordinate of the symmetrical center of the Coin.
    * @return x
    */
   @Override
   public double getX() {
      return x;
   }
   
   /**
    * Gets the y coordinate of the symmetrical center of the Coin.
    * @return y
    */
   @Override
   public double getY() {
      return y;
   }
   
   /**
    * Checks whether the Coin contains the given point.
    * @param xC is the x coordinate of the given point.
    * @param yC is the y coordinate of the given point.
    * @return true if the Coin contains the given point, otherwise returns false.
    */
   @Override
   public boolean contains( double xC, double yC) {
      if ( ( xC - x) * ( xC - x) + ( yC - y) * ( yC - y) < RADIUS * RADIUS) {
         return true;
      }
      return false;
   }
   
   /**
    * Gets the radius of the Coin
    * @return RADIUS
    */
   public double getRadius() {
      return RADIUS;
   }
   
   /**
    * Sets the variable named chosen of the class.
    * @param chosen carries the new value of this.chosen.
    */
   public void choose( boolean chosen) {
      if ( chosen == true) {
         this.chosen = true;
      }
      else {
         this.chosen = false;
      }
   }
   
   /**
    * Returns the value of the variable named chosen.
    * @return true if this Coin is chosen, otherwise returns false.
    */
   public boolean isChosen() {
      return chosen;
   }
   
   /**
    * Sets the components of the velocity of the Coin.
    * @param x is the x component.
    * @param y is the y component.
    */
   public void setSpeed( double x, double y) {
      velocityX = x;
      velocityY = y;
   }
   
   /**
    * Gets the x component of the velocity of the coin.
    * @return velocityX
    */
   public double getVelocityX() {
      return velocityX;
   }
   
   /**
    * Gets the y component of the velocity of the coin.
    * @return velocityY
    */
   public double getVelocityY() {
      return velocityY;
   }
   
   /**
    * Causes the Coin to move.
    */
   public void move() {
      x = x + velocityX/100;
      y = y - velocityY/100;
      System.out.println("velocityx" + velocityX);
   }
   
   /**
    * Gets the mass of the coin.
    * @return MASS
    */
   public double getMass() {
      return MASS;
   }
}
