package viewClasses;
import playground.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class provides a visual representation for the Coin class.
 * @author Süleyman Taylan Topaloðlu
 * @version 30.04.2017
 */

public class CoinVisual
{
   //properties
   private Coin coinIns;
   private BufferedImage coinImage;
   
   //constructor
   public CoinVisual(Coin coinIns1, File f)
   {
      coinIns = coinIns1;
      try
      {
         coinImage = ImageIO.read(f);
      }
      catch(IOException e){}
   }
   
   //methods
   /**
    * Draws the coin image on top of the Coin instance.
    * @param g the Graphics reference.
    */
   public void paint(Graphics g)
   {
      //g = coinImage.createGraphics();
      g.fillOval((int)coinIns.getX(),(int)coinIns.getY() , (int)coinIns.getRadius(), (int)coinIns.getRadius());
      //g.drawImage(coinImage, (int)coinIns.getX(), (int)coinIns.getY(), (int)coinIns.getRadius()); 
      //            (int)coinIns.getRadius(), null);
   }
}


