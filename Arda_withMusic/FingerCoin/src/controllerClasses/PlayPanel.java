package controllerClasses;
import javax.swing.*;
import viewClasses.*;
import playground.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

import java.io.*;
import java.util.ArrayList;
/**
 * The total playing panel of FingerCoin.
 * @author Mustafa Bay, Süleyman Taylan Topaloğlu
 * 08.05.2017
 */
public class PlayPanel extends JPanel 
{
	private GamePanel gamePanel;
	private SingleScorePanel spScore;
	private MultiScorePanel mpScore;
	private GameListener2 gl;
	private int leftTries, numOfTries;
	private Timer timer;
	private int playerNumber;
	
	public PlayPanel(GamePanel gamePanel , int numOfPlayers)
	{
		this.gamePanel = gamePanel;
		setPreferredSize(new Dimension(800, 1080));
		setLayout(null);
		gl = new GameListener2();
		this.timer = new Timer( 10, gl);
		timer.start();
		playerNumber = numOfPlayers;
		if(numOfPlayers == 1)
		{
		    spScore = new SingleScorePanel(gamePanel);
			spScore.setBounds(0, 0, 600, 60);
			this.gamePanel.setBounds(0, 60, 600, 700);
			this.gamePanel.returnDirection().setBounds(400, 850, 200, 200);
			this.gamePanel.returnPower().setBounds(0, 800, 300, 200);
			add(spScore);
			add(this.gamePanel);
			add(this.gamePanel.returnDirection());
			add(this.gamePanel.returnPower());
		}
		else if(numOfPlayers == 2)
		{
			mpScore = new MultiScorePanel(gamePanel);
			mpScore.setBounds(0, 0, 600, 60);
			this.gamePanel.setBounds(0, 60, 600, 700);
			this.gamePanel.returnDirection().setBounds(400, 850, 200, 200);
			this.gamePanel.returnPower().setBounds(0, 800, 300, 200);
			add(mpScore);
			add(this.gamePanel);
			add(this.gamePanel.returnDirection());
			add(this.gamePanel.returnPower());
		}
	}
	class GameListener2 implements ActionListener
	{
		public void actionPerformed( ActionEvent e)
		{
			if( playerNumber == 1){
				spScore.setTries(gamePanel.getField().getScore());
			}
			else{
				
			}
			repaint();	
		}
    }
	
	
	public static void main(String[] args)
	{
		JFrame fr = new JFrame();
		GameSound music = new GameSound("Pokemon.mp3");
		music.start();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel x = new GamePanel( 0, 1, 1);
		PlayPanel pp = new PlayPanel(x, 1);
		fr.setSize(800, 1080);
		fr.add(pp);
		fr.setVisible(true);
	}
}
