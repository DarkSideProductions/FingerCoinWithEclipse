package playground;
/**
 * This class simulates the goal of the Finger Coin Game.
 * @author Arda Yüksel
 * @version 28.04.2017
 */
public class Goal implements Drawable {
   
   //properties
   private final double HEIGHT = 20;
   private final double WIDTH = 200;
   
   private double x, y;
   
   /**
    * Constructor
    * @param xC is the x coordinate of the symmetrical center of the Goal.
    * @param yC is the y coordinate of the symmetrical center of the Goal.
    */
   public Goal(double xC,double yC){
      x = xC;
      y = yC;
   }
   
   /**
    * Gets the x coordinate of the symmetrical center of the Goal.
    * @return x
    */
   @Override
   public double getX(){
      return x;
   }
   
   /**
    * Gets the y coordinate of the symmetrical center of the Goal.
    * @return y
    */
   @Override
   public double getY(){
      return y;
   }
   
   /**
    * Gets the height of the Goal.
    * @return HEIGHT
    */
   public double getHeight(){
      return HEIGHT;
   }
   
   /**
    * Gets the width of the Goal.
    * @return WIDTH
    */
   public double getWidth(){
      return WIDTH;
   }
   
   /**
    * Checks whether the Goal contains the given point.
    * @param xC is the x coordinate of the given point.
    * @param yC is the y coordinate of the given point.
    * @return true if the Goal contains the given point, otherwise returns false.
    */
   @Override
   public boolean contains(double xC, double yC){
      if( (xC < x + WIDTH/ 2  && xC > x - WIDTH/ 2) && ( yC < y + HEIGHT/ 2  && yC > y - HEIGHT/ 2  ) ){
         return true;
      }
      return false; 
   }
}
