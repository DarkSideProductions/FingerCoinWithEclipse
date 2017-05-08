package viewClasses;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * A general ActionListener for FingerCoin.
 * @author Süleyman Taylan Topaloğlu
 * @version 07.05.2017
 */
public class GeneralListener implements ActionListener 
{
	/**
	 * Processes the action event.
	 * @param e the action event.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if(((JButton)e.getSource()).getText().equals("Back to main menu"))
		{
			FingerCoinFrame.changePanel("main menu");
		}
		if(((JButton)e.getSource()).getText().equals("Close"))
		{
			FingerCoinFrame.changePanel("settings");
		}
		if(((JButton)e.getSource()).getText().equals("Back to settings"))
		{
			FingerCoinFrame.changePanel("settings");
		}
		if(((JButton)e.getSource()).getText().equals("CREDITS"))
		{
			FingerCoinFrame.changePanel("credits");
		}
		if(((JButton)e.getSource()).getText().equals("RULES"))
		{
			FingerCoinFrame.changePanel("info");
		}
		if(((JButton)e.getSource()).getText().equals("Settings"))
		{
			FingerCoinFrame.changePanel("settings");
		}
		if(((JButton)e.getSource()).getText().equals("Single Player"))
		{
			FingerCoinFrame.changePanel("single player game");
		}
		if(((JButton)e.getSource()).getText().equals("Multi Player"))
		{
			FingerCoinFrame.changePanel("name selection");
		}
		if(((JButton)e.getSource()).getText().equals("CLICK TO CONTINUE"))
		{
			FingerCoinFrame.changePanel("multi player game");
		}
		if(((JButton)e.getSource()).getText().equals("GAME MENU") && ((JButton)e.getSource()).getClass().getName().equals("viewClasses.SingleScorePanel"))
		{
			
		}
		if(((JButton)e.getSource()).getText().equals("GAME MENU") && ((JButton)e.getSource()).getClass().getName().equals("viewClasses.MultiScorePanel"))
		{
			
		}
		if(((JButton)e.getSource()).getText().equals("Exit"))
		{
			System.exit(0);
		}
	}
}
