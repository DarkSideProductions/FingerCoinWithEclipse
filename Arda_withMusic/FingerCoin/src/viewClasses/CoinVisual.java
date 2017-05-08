package viewClasses;

import playground.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class provides a visual representation for the Coin class.
 * @author Süleyman Taylan Topaloğlu
 * @version 30.04.2017
 */

public class CoinVisual
{
	//properties
	private Coin coinIns;
	private BufferedImage coinImage;

	//constructor
	public CoinVisual( Coin coinIns1, File f)
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
	public void paint( Graphics g)
	{
		g.drawImage(coinImage, (int)(coinIns.getX() - coinIns.getRadius()), (int)(coinIns.getY() - coinIns.getRadius()), 2*(int)coinIns.getRadius(), 2*(int)coinIns.getRadius(), null);
		if(coinIns.isChosen())
		{
			g.setColor(Color.GREEN);
			g.drawOval((int)(coinIns.getX() - coinIns.getRadius()), (int)(coinIns.getY() - coinIns.getRadius()), 2*(int)coinIns.getRadius(), 2*(int)coinIns.getRadius());
		}
	}
}
