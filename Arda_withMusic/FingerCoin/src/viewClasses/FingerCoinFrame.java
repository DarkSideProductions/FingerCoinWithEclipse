package viewClasses;

import playground.*;
import controllerClasses.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.io.*;

/**
 * The total FingerCoinFrame!!
 * @author Süleyman Taylan Topaloğlu
 * @version 07.05.2017
 */
public class FingerCoinFrame extends JFrame
{
	//properties
	private static JPanel cards;
	private JPanel mainMenu, settings, nameSelect, credits, info, fieldPanel;
	private static CardLayout cardL;
	private BufferedImage background;
	private GamePanel spGame, mpGame;
	private JPanel spPlay, mpPlay;
	
	//constructor
	public FingerCoinFrame()
	{
		setSize(800, 1080);
		initComponents();
	}
	
	//methods
	/**
	 * Sets up the components for FingerCoin.
	 */
	public void initComponents() //TODO
	{
		mainMenu = new MainMenuPanel();
		mainMenu.setName("main menu");
		settings = new SettingsPanel();
		settings.setName("settings");
		nameSelect = new NameSelectionPanel();
		nameSelect.setName("name selection");
		credits = new CreditsPanel();
		info = new InfoPanel();
		spGame = new GamePanel(0,1,2);
		mpGame = new GamePanel(0,2,2);
		spPlay = new PlayPanel(spGame, 1);
		mpPlay = new PlayPanel(mpGame, 2);
		try
		{
			background = ImageIO.read(new File("table.jpg"));
		}
		catch(IOException e){}
		
		cards = new JPanel(new CardLayout());
		cards.add(mainMenu, "main menu");
		cards.add(settings, "settings");
		cards.add(nameSelect, "name selection");
		//cards.add(singleScore, "single score");
		//cards.add(multiScore, "multi score");
		cards.add(info, "info");
		cards.add(credits, "credits");
		cards.add(spPlay, "single player game");
		cards.add(mpPlay, "multi player game");
		
		cardL = (CardLayout) cards.getLayout();
		cardL.show(cards, "main menu");
		add(cards);
	}
	/**
	 * Changes the current panel.
	 * @param str the String parameter that invokes the panels' names.
	 */
	public static void changePanel(String str)
	{
		cardL.show(cards, str);
	}
	
	//testing
	public static void main(String[] args)
	{
		FingerCoinFrame fr = new FingerCoinFrame();
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
