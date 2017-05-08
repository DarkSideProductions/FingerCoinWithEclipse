package viewClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class shows the rules and controls of the game.
 * @author Mustafa Bay, Süleyman Taylan Topaloğlu, Ceyhun Emre Öztürk
 * @version 07.05.2017
 */
public class InfoPanel extends JPanel
{
	private BufferedImage background;
	private JButton button;
	private JTextArea textField;
	private JLabel rulesOfTheGame;
	private GeneralListener gl;
	public InfoPanel()
	{
		button = new JButton("Close");
		
		textField = new JTextArea( "Rules:" + "\n" + 
				"The players cannot hit other coins with the chosen one.\n If the player " + 
				"hits the other coins, one of the goal posts or the goalkeeper object,\n" +
				"the player will automatically lose.\n Also, if the coin does not pass " +
				"between the other two coins,\n the player will immediately lose again.\n" +
				"In multiplayer, player with less tries to score a goal wins." + 
				"\n\nControls:\n" + 
				"|A| -> Chooses the coin in the left" + "\n" +
				"|D| -> Chooses the coin in the right" + "\n" + 
				"Arrows -> To change direction" + "\n" + 
				"Enter -> To switch to force selection/ To launch coin" + "\n" +
				"Escape -> To cancel the latest operation" );  
		gl = new GeneralListener();
		textField.setEditable(false);
		textField.setOpaque(false);
		
		setLayout(null);
		rulesOfTheGame = new JLabel ("Rules And Controls Of The Game");
		rulesOfTheGame.setBounds(200, 50, 400, 75);
		rulesOfTheGame.setHorizontalAlignment(JLabel.CENTER);
		rulesOfTheGame.setFont(new Font("Arial", 1, 20));
		rulesOfTheGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textField.setBounds(100, 250, 600, 300);
		textField.setFont(new Font("Arial", 0, 16));
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setPreferredSize(new Dimension(800,1080));
		
		button.setBounds(350, 600, 100, 50);
		button.addActionListener(gl);
		
		try
		{
			background = ImageIO.read(new File("table.jpg"));
		}
		catch(IOException e){}
		add(rulesOfTheGame);
		add(textField);
		add(button);
	}

	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( background,0,0,800,1200,null);
	}
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,1080);
		window.add(new InfoPanel());
		window.setVisible(true);
	}
}