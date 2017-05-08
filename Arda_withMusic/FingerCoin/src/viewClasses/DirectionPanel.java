package viewClasses;
import java.awt.*;
import java.awt.geom.Arc2D;
import javax.swing.*;
/**
 * This class shows the direction that the coin will follow when it is pushed.
 * @author Arda Yüksel
 * @version 07.05.2017
 */
public class DirectionPanel extends JPanel {
	
	//properties
	private final int WIDTH = 200;
	private final int HEIGHT = 200;
	private final int RADIUS = 100;
	private final double START_ANGLE = 0;
	private final double MID_ANGLE = 90;
	private final double FINISH_ANGLE = 180;
	private double angle;
	
	/**
	 * Default constructor for DirectionPanel
	 * @param angle is the angle in radians
	 */
	public DirectionPanel(double angle){
		this.setPreferredSize( new Dimension(WIDTH,HEIGHT) );
		this.angle = (180*angle)/Math.PI;
	}
	
	/**
	 * Changes the angle
	 * @param angle is the angle in radians
	 */
	public void setAngle(double angle){
		this.angle = (180*angle)/Math.PI;
	}
	
	/**
	 * Draws the area
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.ORANGE);
		g2.fill(new Arc2D.Double((WIDTH/2)-RADIUS, (HEIGHT/2) - RADIUS , RADIUS, RADIUS, START_ANGLE, FINISH_ANGLE, Arc2D.OPEN));
		g2.setColor(Color.CYAN);
		g2.fill(new Arc2D.Double((WIDTH/2)-RADIUS, (HEIGHT/2) - RADIUS , RADIUS, RADIUS, MID_ANGLE,angle-90, Arc2D.PIE));
	}
}
