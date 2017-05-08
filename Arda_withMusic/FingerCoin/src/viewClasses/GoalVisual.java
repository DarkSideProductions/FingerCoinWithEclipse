package viewClasses;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import playground.*;
/**
 * This class creates the visual of the goal of the Finger Coin game.
 */
public class GoalVisual extends JPanel
{
	//properties
	private Goal goal;

	/**
	 * Constructor
	 * @param x is the x coordinate of the center of the goal.
	 * @param y is the y coordinate of the center of the goal.
	 */
	public GoalVisual( Goal goal1 )
	{
		goal = goal1;
	}

	/**
	 * This method creates the goal posts.
	 * @param g includes the painting instructions.
	 */
	public void paint( Graphics g)
	{
		g.setColor(Color.black);
		g.drawLine((int)( goal.getX() - goal.getWidth() / 2), (int)( goal.getY() - goal.getHeight() / 2), 
				(int)(goal.getX() - goal.getWidth() / 2), (int)( goal.getY() + goal.getHeight()) / 2);
		g.drawLine((int)( goal.getX() + goal.getWidth() / 2 ), (int)( goal.getY() - goal.getHeight() / 2), 
				(int)(goal.getX() + goal.getWidth() / 2 ),  (int)( goal.getY() + (int)goal.getHeight()) / 2);
	}
}
