package viewClasses;
import playground.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;
import viewClasses.FingerCoinFrame;
/**
 * This class creates the main menu for FingerCoin.
 * @author Süleyman Taylan Topaloğlu
 * @version 30.04.2017
 */
public class MainMenuPanel extends JPanel
{
    //properties
    private JButton singlePlayer, multiPlayer, settings, exit;
    private JPanel nextPanel;
    private Image background;
    private GeneralListener gl;
    
    //constructors
    public MainMenuPanel()
    {
        singlePlayer = new JButton("Single Player");
        multiPlayer = new JButton("Multi Player");
        settings = new JButton("Settings");
        exit = new JButton("Exit");
        gl = new GeneralListener();
        try
        {
        	background = ImageIO.read(new File("table.jpg"));
        }
        catch(IOException e){}
        singlePlayer.addActionListener(gl);
        multiPlayer.addActionListener(gl);
        settings.addActionListener(gl);
        exit.addActionListener(gl);
        
        setLayout(null);
        singlePlayer.setBounds(150, 200, 500, 100);
        singlePlayer.setFont(new Font("Arial", 0, 45));
        singlePlayer.setOpaque(false);
        singlePlayer.setContentAreaFilled(false);
        multiPlayer.setBounds(150, 350, 500, 100);
        multiPlayer.setFont(new Font("Arial", 0, 45));
        multiPlayer.setOpaque(false);
        multiPlayer.setContentAreaFilled(false);
        settings.setBounds(150, 500, 500, 100);
        settings.setFont(new Font("Arial", 0, 45));
        settings.setOpaque(false);
        settings.setContentAreaFilled(false);
        exit.setBounds(150, 650, 500, 100);
        exit.setFont(new Font("Arial", 0, 45));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        
        add(singlePlayer);
    	add(multiPlayer);
    	add(settings);
    	add(exit);
    }
    
    //methods
    /**
     * Paints the panel and background.
     * @param g the Graphics object.
     */
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	g.drawImage(background, 0, 0, 800, 1200, null);
    }
    //testing
    public static void main(String[] args)
    {
    	JFrame fr = new JFrame();
    	MainMenuPanel mn = new MainMenuPanel();
    	fr.add(mn);
    	fr.setSize(800, 1080);
    	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	fr.setVisible(true);
    }
}