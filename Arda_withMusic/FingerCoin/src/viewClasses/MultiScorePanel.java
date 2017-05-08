package viewClasses;
import playground.*;
import controllerClasses.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class creates the multiplayer scoreboard of FingerCoin.
 * @author Süleyman Taylan Topaloğlu
 * @version 30.04.2017
 */
public class MultiScorePanel extends JPanel
{
	//properties
	private JLabel p1 , p2;
	private int trycount1, trycount2;
	private JPanel nextPanel;
	private JButton gameMenu;
	private GeneralListener cl;
	private GamePanel gamePanel;
	
	//constructors
	public MultiScorePanel(GamePanel gp)
	{
		trycount1 = 0;
		trycount2 = 0;
		gamePanel = gp;
		p1 = new JLabel("First Player: " + trycount1 + " Tries");
		p2 = new JLabel("Second Player: " + trycount2 + " Tries");
		gameMenu = new JButton("GAME MENU");
		cl = new GeneralListener();
		gameMenu.addActionListener(cl);
		
		setLayout(null);
		gameMenu.setBounds(240, 30, 120, 30);
		p1.setBounds(30, 30, 150, 30);
		p2.setBounds(450, 30, 150, 30);
		add(gameMenu);
		add(p1);
		add(p2);
		setPreferredSize(new Dimension(600, 60));
	}

	//methods
	/**
	 * Paints the scoreboard.
	 * @param g the Graphics object.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(0, 0, 800, 120);
	}
	//testing
	/*public static void main(String[] args)
	{
		JFrame fr = new JFrame();
		fr.add(new MultiScorePanel());
		fr.setSize(800, 120);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}*/
}