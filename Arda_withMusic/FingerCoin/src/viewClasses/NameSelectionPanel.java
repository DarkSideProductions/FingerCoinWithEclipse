package viewClasses;
import playground.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

/**
 * This class creates the name selection window in the multiplayer mode of FingerCoin.
 * @author Süleyman Taylan Topaloğlu
 * @version 30.04.2017
 */
public class NameSelectionPanel extends JPanel 
{
	//properties
	private JLabel namep1, namep2;
	private JTextField p1, p2;
	private JButton clickToContinue, back;
	private BufferedImage background;
	private JPanel nextPanel, lastPanel;
	private String name1, name2;
	private GeneralListener gl;
	
	//constructors
	public NameSelectionPanel()
	{
		namep1 = new JLabel("First User's Name:");
		namep2 = new JLabel("Second User's Name:");
		p1 = new JTextField();
		p2 = new JTextField();
		back = new JButton("Back to main menu");
		gl = new GeneralListener();
		clickToContinue = new JButton("CLICK TO CONTINUE");
		try
        {
        	background = ImageIO.read(new File("table.jpg"));
        }
        catch(IOException e){}
		
		// TODO sizings and arrangements
		setLayout(null);
		namep1.setBounds(150, 300, 200, 50);
		namep1.setFont(new Font("Arial",Font.PLAIN,20));
		p1.setBounds(360, 310, 200, 30);
		namep2.setBounds(150, 550, 200, 50);
		namep2.setFont(new Font("Arial",Font.PLAIN,20));
		p2.setBounds(360, 560, 200, 30);
		back.setBounds(50, 50, 100, 30);
		clickToContinue.setBounds(250, 750, 300, 60);
		clickToContinue.setFont(new Font("Arial", Font.PLAIN, 25));
		clickToContinue.setContentAreaFilled(false);
		back.addActionListener(gl);
		clickToContinue.addActionListener(gl);
		add(namep1);
		add(p1);
		add(namep2);
		add(p2);
		add(back);
		add(clickToContinue);
		
	}
	
	//methods
	/**
	 * Paints the panel with the background image.
	 * @param g the Graphics reference.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 800, 1200, null);
	}
	 
	 /**
	  * For testing purposes
	  */
	public static void main(String[] args)
	{
		JFrame fr = new JFrame();
		fr.add(new NameSelectionPanel());
		fr.setSize(800, 1080);
		fr.setVisible(true);
	}
}
