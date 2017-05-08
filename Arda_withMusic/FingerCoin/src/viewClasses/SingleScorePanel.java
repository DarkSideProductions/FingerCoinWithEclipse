package viewClasses;
import playground.*;
import controllerClasses.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * This class creates the singleplayer scoreboard of FingerCoin.
 * @author Süleyman Taylan Topaloğlu
 * @version 30.04.2017
 */
public class SingleScorePanel extends JPanel
{
	//properties
	private JLabel chances;
	private int trycount;
	private JPanel nextPanel;
	private JButton gameMenu;
	private GeneralListener cl;
	private GamePanel gamePanel;
	
	//constructors
	public SingleScorePanel(GamePanel gp)
	{
		this.gamePanel = gp;
		trycount = gamePanel.getField().getScore();
		chances = new JLabel("Chances Left: " + trycount + " Tries");
		gameMenu = new JButton("GAME MENU");
		cl = new GeneralListener();
		gameMenu.addActionListener(cl);
		
		setLayout(null);
		gameMenu.setBounds(240, 30, 120, 30);
		chances.setBounds(30, 30, 150, 30);
		add(gameMenu);
		add(chances);
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
		chances.setText("You Tried " + trycount);
		g.drawRect(0, 0, 800, 120);
	}
	public void setTries(int tries)
	{
		trycount = tries;
	}
	//testing
	/*public static void main(String[] args)
	{
		JFrame fr = new JFrame();
		fr.add(new SingleScorePanel());
		fr.setSize(800, 120);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}*/
}