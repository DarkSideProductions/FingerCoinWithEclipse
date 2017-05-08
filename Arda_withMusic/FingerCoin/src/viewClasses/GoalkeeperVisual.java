package viewClasses;
import java.awt.Color;
import java.awt.Graphics;
import playground.*;
/**
 * Creates a visual representation of the goalkeeper of the FieldCoin game.
 * @author Mustafa Bay
 * @version 07.05.2017
 */
public class GoalkeeperVisual {
	
	//properties
	Goalkeeper keeper;
	
	/**
	 * Constructor
	 * @param difficulty is the difficulty of the game.
	 * @param keeper1 is the goalkeeper object.
	 */
	public GoalkeeperVisual(int difficulty, Goalkeeper keeper1)
	{
		keeper = keeper1;
	}
	
	/**
	 * Is the painter method.
	 * @param g has the painting instructions.
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect ((int)keeper.getX(), (int)keeper.getY(), (int)keeper.getHeight(), (int)keeper.getWidth());
	}
}
