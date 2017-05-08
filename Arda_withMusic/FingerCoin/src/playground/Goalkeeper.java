package playground;
/**
 * This class simulates the goalkeeper of the Finger Coin game.
 * @author Ceyhun Emre Öztürk
 * @version 28.04.2017
 */
public class Goalkeeper implements Drawable{
   
   //properties
   private final int WIDTH = 10;
   private final int HEIGHT = 20;
   
   private double x;
   private double y;
   private double velocityX;
   
   /**
    * Constructor
    * @param difficulty is the int value of the given difficulty level.
    * @param x is the given x coordinate.
    * @param y is the given y coordinate.
    */
   public Goalkeeper( int difficulty, double x, double y) {
      this.x = x;
      this.y = y;
      
      if ( difficulty == 0)
      {
         velocityX = 2;
      }
      else if ( difficulty == 1)
      {
         velocityX = 4;
      }
      else
      {
         velocityX = 6;
      }
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
      if( (xC < x + WIDTH/ 2  && xC > x - WIDTH/ 2) && ( yC < y + HEIGHT/ 2  && yC > y - HEIGHT/ 2  ) ){
         return true;
      }
      return false; 
   }
   
   /**
    * Gets the height of the Goalkeeper.
    * @return HEIGHT
    */
   public double getHeight(){
      return HEIGHT;
   }
   
   /**
    * Gets the width of the Goalkeeper.
    * @return WIDTH
    */
   public double getWidth(){
      return WIDTH;
   }
   
   /**
    * Causes the Goalkeeper to move.
    */
   public void move()
   {
	  if( (x > 380|| x < 200))
	  {
		  velocityX = velocityX * (-1);
	  }
	    x = x + velocityX;
   }
}
