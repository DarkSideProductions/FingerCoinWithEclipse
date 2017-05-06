package playground;
import java.util.ArrayList;
/**
 * This class simulates the field of the Finger Coin game, updates the score of the game and determines whether the 
 * game is over.
 * @author Arda Yüksel
 * @version 28.04.2017
 */
public class Field {
   
   //properties
   private final double GRAVITATIONAL_ACCELERATION = 9.8;
      
   private double kineticFrictionCoefficient, height, width;
   private int difficulty, score;
   private boolean gameOver;
   private ArrayList<Drawable> fieldObjects;
   
   /**
    * Constructor
    * @param difficultyLevel is the difficulty level of the game as an int value.
    * @param prefWidth is the preffered width of the field.
    * @param prefHeight is the preffered height of the field.
    * @param elements is the list of objects on the field.
    */
   public Field( int difficultyLevel, double prefWidth, double prefHeight, ArrayList<Drawable> elements){
      difficulty = difficultyLevel;
      width = prefWidth;
      height = prefHeight;
      fieldObjects = elements;
      score = 0;
      gameOver = false;
      setFriction();
   }
   
   //methods
   
   /**
    * Sets the value of the frictionCoefficient accordingly to the value of the variable named difficulty.
    */
   private void setFriction() {
      if( difficulty == 0 ){
         kineticFrictionCoefficient = 0.2;
      }
      else if( difficulty == 1 ) {
         kineticFrictionCoefficient = 0.5;
      }
      else {
         kineticFrictionCoefficient = 0.7;
      }
   }
   
   /**
    * Makes the given Coin move slower because of the friction.
    * @param c is the Coin to get slower due to the friction
    */
   public void slowDown( Coin c ) {
      double objectFriction;
      double velocityMagnitude;
      
      //magnitude of the velocity for the vector
      velocityMagnitude = Math.pow( c.getVelocityY()*c.getVelocityY() + 
                                   c.getVelocityX()*c.getVelocityX(), 0.5);
      //friction will be zero at width/2
      if( difficulty == 0 ){
         objectFriction = Math.abs( 1 - ( c.getX() - width/2 ) ) / (width / 2) * kineticFrictionCoefficient * 
                                          GRAVITATIONAL_ACCELERATION;
      }
      else if( difficulty == 1){
         objectFriction = kineticFrictionCoefficient * GRAVITATIONAL_ACCELERATION;
      }
      else {
         objectFriction = Math.abs( c.getX() - width/2 ) / (width / 2) * kineticFrictionCoefficient * 
                                    GRAVITATIONAL_ACCELERATION;
      }
      c.move();
      c.setSpeed( c.getVelocityX() - objectFriction*(c.getVelocityX() / velocityMagnitude),
                 c.getVelocityY() - objectFriction*(c.getVelocityY() / velocityMagnitude));
      isInside(c);
      isCrushed(c);
      isInsideField(c);
      if( c.getVelocityX() == 0 && c.getVelocityY() == 0 ){
         score++;
      }
   }
   
   /**
    * Pushes the given Coin.
    * @param c is the given Coin.
    * @param force is the force of the push.
    * @param x is the x component of the force.
    * @param y is the y component of the force.
    * @return the coordinates of the coin before the push.
    */
   public double[] pushCoin( Coin c, double force, double x, double y) {
      
      double objectFriction;
      double velocityMagnitude;
      double[] initialCoordinates = { c.getX(), c.getY()};
      //static friction coefficient = kineticFrictionCoefficient + 0.1
      if ( force > c.getMass() * GRAVITATIONAL_ACCELERATION * ( kineticFrictionCoefficient + 0.1)) {
         if( difficulty == 0 ){
            objectFriction = ( kineticFrictionCoefficient + 0.1) * 
                               Math.abs( 1 - ( c.getX() - width/2 ) ) / (width / 2) * GRAVITATIONAL_ACCELERATION;
         }
         else if( difficulty == 1){
            objectFriction = ( kineticFrictionCoefficient + 0.1) * GRAVITATIONAL_ACCELERATION;
         }
         else {
            objectFriction = ( kineticFrictionCoefficient + 0.1) * Math.abs( c.getX() - width/2 ) / (width / 2) * 
                               GRAVITATIONAL_ACCELERATION;
         }
         
         velocityMagnitude = force / c.getMass() - ( kineticFrictionCoefficient + 0.1) * GRAVITATIONAL_ACCELERATION;
         c.setSpeed( velocityMagnitude * x / Math.pow( x * x + y * y, 0.5), 
                     velocityMagnitude * y / Math.pow( x * x + y * y, 0.5));
      }
      else {
         c.setSpeed( 0, 0);
      }
      
      return initialCoordinates;
   }
   
   /**
    * Checks whether the given Coin has reached ( and possibly passed) the line of the goal or not.
    * @param c is the Coin to check its location.
    * @return true if a goal has been scored, otherwise returns false.
    */
   public boolean isInside( Coin c){
      for ( Drawable o: fieldObjects ){
         if ( !isCrushed( c) &&( o instanceof Goal ) && ( o.contains( c.getX(), c.getY()) ) ){
            gameOver = true;
            return true;
         }
      }
      return false;
   }
   
   /**
    * Checks whether the given Coin has collided with other objects.
    * @param c is the Coin to check.
    * @return true if the Coin has collided with other objects, otherwise returns false.
    */
   public boolean isCrushed( Coin c)
   {
      double distance;
      
      for ( Drawable o: fieldObjects){
         distance = Math.pow( Math.pow( Math.abs( o.getX()-c.getX()),2 ) + 
                              Math.pow( Math.abs( o.getY()-c.getY()),2 ),2 );
         if ( o instanceof Coin && o != c && distance <= ((Coin) o).getRadius() + c.getRadius() ){
            gameOver = true;
            return true;
         }
         if ( o instanceof Goalkeeper ){
            if ( c.getX() + c.getRadius() == o.getX() - ((Goalkeeper) o).getWidth() / 2 ){
               gameOver = true;
               return true;
            }
            else if ( c.getX() - c.getRadius() == o.getX() + ((Goalkeeper) o).getWidth() / 2 ){
               gameOver = true;
               return true;
            }
            else if ( c.getY() - c.getRadius() == o.getY() + ((Goalkeeper) o).getHeight() / 2 ){
               gameOver = true;
               return true;
            }
            else if ( distance * distance  == c.getRadius() * c.getRadius() +
                    (((Goalkeeper) o).getWidth() / 2 ) * (((Goalkeeper) o).getWidth() / 2 ) +
                    (((Goalkeeper) o).getHeight() / 2 ) * (((Goalkeeper) o).getHeight() / 2 ) ){
               gameOver = true;
               return true;
            }
         }
      }
      return false;
   }
   
   /**
    * Checks whether the given Coin is inside the field or not.
    * @param c is the given Coin.
    * @return true if the Coin object is inside field, otherwise returns false.
    */
   public void isInsideField( Coin c)
   {
      if ( isInside( c) || isCrushed( c) || 
           ( 0 <= c.getX() && c.getX() <= width && 0 <= c.getY() && c.getY() <= height)) {
         gameOver = true;
      }
      gameOver =false;
   }
   
   /**
    * Returns the value of the gameOver.
    * @return true if game is over, otherwise returns false.
    */
   public boolean isGameOver(){
      return gameOver;
   }
   
   /**
    * Returns the score of this game.
    * @return score
    */
   public int getScore(){
      return score;
   }
}
