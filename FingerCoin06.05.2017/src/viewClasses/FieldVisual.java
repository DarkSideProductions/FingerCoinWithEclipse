package viewClasses;
import playground.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
/**
 * This class creates the visual of the pitch of the Finger Coin game.
 * @author Ceyhun Emre Öztürk
 * @version 04.05.2017
 */
public class FieldVisual
{
   //properties
   private int prefWidth, prefHeight;
   
   //constructor
   public FieldVisual( double prefWidth, double prefHeight)
   {
      this.prefWidth = (int) prefWidth;
      this.prefHeight = (int) prefHeight;
   }
   
   //methods
   /**
    * Draws bounds of the field.
    * @param g the Graphics reference.
    */
   public void draw( Graphics g)
   {
      g.drawRect( 0, 0, prefWidth, prefHeight);
   }
}