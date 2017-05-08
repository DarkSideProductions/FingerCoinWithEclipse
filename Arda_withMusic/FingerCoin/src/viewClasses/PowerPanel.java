package viewClasses;
import javax.swing.*;
import java.awt.*;

/**
 * This class will demonstrate the power panel
 * @author Arda Yüksel
 * @version 07.05.2017
 */
public class PowerPanel extends JPanel{
	
	//properties
	private final int WIDTH = 600;
	private final int HEIGHT = 150;
	private final int RECTANGLE_SIDE = 50;
	private final int MAX_FORCE = 5;
	private double force;
	
	/**
	 * Default constructor for PowerPanel
	 * @param force is the magnitude of force
	 */
	public PowerPanel(double force ){
		this.setPreferredSize( new Dimension(WIDTH,HEIGHT) );
		this.force = force; 
	}
	
	/**
	 * Changes the force
	 * @param force is the magnitude of force
	 */
	public void setForce(double force){
		this.force = force;
	}
	
	/**
	 * draws power rectangles
	 * @param g is the graphics component
	 */
	public void paintComponent( Graphics g ){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		for(int i = 0; i < MAX_FORCE;i++ ){
			if(i < force){
				g.fillRect( (i+1)*RECTANGLE_SIDE, RECTANGLE_SIDE, RECTANGLE_SIDE, RECTANGLE_SIDE);
			}
			else{
				g.setColor(Color.WHITE);
				g.fillRect( (i+1)*RECTANGLE_SIDE, RECTANGLE_SIDE, RECTANGLE_SIDE, RECTANGLE_SIDE);
			}
		}
	}
	
	/**
	 * For testing purposes
	 */
	public static void main(String[] args){
		JPanel power = new PowerPanel(3);
		JFrame a = new JFrame();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.add(power);
		a.pack();
		a.setVisible(true);
	}
}
