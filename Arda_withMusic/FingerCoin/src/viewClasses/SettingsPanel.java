package viewClasses;
import playground.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class creates the Settings class for FingerCoin.
 * @author Süleyman Taylan Topaloğlu
 * @version 30.04.2017
 */
public class SettingsPanel extends JPanel implements ActionListener
{
	//properties
	private JButton easy, medium, hard, lecture;
	private JSlider sound;
	private JButton back, rules, credits;
	private JButton nextCoin, prevCoin;
	private BufferedImage coin, nextC, prevC;
	private BufferedImage[] coins;
	private Image background;
	private SoundChangeListener chL;
	private int coinType;
	private JLabel settings, diff, cType, volume;
	private GeneralListener gl;
	
	//constructor
	public SettingsPanel()
	{
		easy = new JButton("Easy");
		medium = new JButton("Medium");
		hard = new JButton("Hard");
		lecture = new JButton("LECTURE");
		sound = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		back = new JButton("Back to main menu");
		rules = new JButton("RULES");
		credits = new JButton("CREDITS");
		chL = new SoundChangeListener();
		settings = new JLabel("Settings");
		diff = new JLabel("Difficulty");
		cType = new JLabel("   Coin");
		volume = new JLabel("  Sound");
		gl = new GeneralListener();
		coins = new BufferedImage[3];
		try
		{
			background = ImageIO.read(new File("table.jpg"));
			nextC = ImageIO.read(new File("right.png"));
			prevC = ImageIO.read(new File("left.png"));
			coin = ImageIO.read(new File("para.png"));
			coins[0] = ImageIO.read(new File("para.png"));
			coins[1] = ImageIO.read(new File("dolar.png"));
			coins[2] = ImageIO.read(new File("euro.png"));
			coinType = 1;
		}
		catch(IOException e){}

		nextCoin = new JButton(new ImageIcon(nextC.getScaledInstance(50, 50, BufferedImage.TYPE_INT_ARGB)));
		nextCoin.setContentAreaFilled(false);
		nextCoin.setBorderPainted(false);
		nextCoin.setOpaque(false);
		nextCoin.setBounds(500, 350, 50, 50);
		
		prevCoin = new JButton(new ImageIcon(prevC.getScaledInstance(48, 48, BufferedImage.TYPE_INT_ARGB)));
		prevCoin.setContentAreaFilled(false);
		prevCoin.setBorderPainted(false);
		prevCoin.setOpaque(false);
		prevCoin.setBounds(300, 350, 50, 50);

		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		lecture.addActionListener(this);
		rules.addActionListener(gl);
		credits.addActionListener(gl);
		back.addActionListener(gl);
		sound.addChangeListener(chL);
		nextCoin.addActionListener(this);
		prevCoin.addActionListener(this);

		setPreferredSize(new Dimension(800, 1200));
		setLayout(null);
		sound.setBounds(225, 560, 400, 20);
		sound.setOpaque(false);
		easy.setBounds(200, 200, 100, 30);
		medium.setBounds(320, 200, 100, 30);
		hard.setBounds(440, 200, 100, 30);
		lecture.setBounds(560, 200, 100, 30);
		rules.setBounds(300, 700, 200, 50);
		credits.setBounds(300, 800, 200, 50);
		rules.setOpaque(false);
		rules.setContentAreaFilled(false);
		rules.setFont(new Font("Arial", 0, 20));
		credits.setOpaque(false);
		credits.setContentAreaFilled(false);
		credits.setFont(new Font("Arial", 0, 20));
		back.setBounds(50, 30, 70, 20);
		settings.setBounds(330, 50, 150, 50);
		settings.setFont(new Font("Arial", 1, 30));
		settings.setHorizontalAlignment(JLabel.CENTER);
		settings.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		diff.setBounds(30, 190, 100, 50);
		diff.setFont(new Font("Arial", 0, 25));
		diff.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cType.setBounds(30, 340, 100, 50);
		cType.setFont(new Font("Arial", 0, 25));
		cType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		volume.setBounds(30, 540, 100, 50);
		volume.setFont(new Font("Arial", 0, 25));
		volume.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		add(easy);
		add(medium);
		add(hard);
		add(lecture);
		add(sound);
		add(back);
		add(credits);
		add(rules);
		add(nextCoin);
		add(prevCoin);
		add(settings);
		add(diff);
		add(cType);
		add(volume);
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
		g.drawImage(coin, 375, 325, 100, 100, null);
	}
	/**
	 * This class is the listener of the Settings panel buttons in FingerCoin.
	 * @author Süleyman Taylan Topaloğlu
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		if(((JButton)e.getSource()).equals(easy))
		{
			((JButton)e.getSource()).setEnabled(false);
			medium.setEnabled(true);
			hard.setEnabled(true);
			lecture.setEnabled(true);
			//xx.setDifficulty(0);
		}
		if(((JButton)e.getSource()).equals(medium))
		{
			((JButton)e.getSource()).setEnabled(false);
			easy.setEnabled(true);
			hard.setEnabled(true);
			lecture.setEnabled(true);
			//xx.setDifficulty(1);
		}
		if(((JButton)e.getSource()).equals(hard))
		{
			((JButton)e.getSource()).setEnabled(false);
			medium.setEnabled(true);
			easy.setEnabled(true);
			lecture.setEnabled(true);
			//xx.setDifficulty(2);
		}
		if(((JButton)e.getSource()).equals(lecture))
		{
			((JButton)e.getSource()).setEnabled(false);
			medium.setEnabled(true);
			hard.setEnabled(true);
			easy.setEnabled(true);
			//xx.setDifficulty(2);
		}
		if(((JButton)e.getSource()).equals(prevCoin) && !(coinType == 1))
		{
			coinType--;
			coin = coins[coinType - 1];
		}
		if(((JButton)e.getSource()).equals(nextCoin) && !(coinType == 3))
		{
			coinType++;
			coin = coins[coinType - 1];
		}
		if(coinType > 3) coinType = 3;
		if(coinType < 1) coinType = 1;
		repaint();
	}
	/**
	 * Gets the current coin image.
	 * @return the current coin image.
	 */
	public BufferedImage getCoin()
	{
		return coin;
	}
	/**
	 * Gets the current coin type.
	 * @return the current coin type.
	 */
	public int getCoinType()
	{
		return coinType;
	}

	/**
	 * This class listens the sliding bar that changes sounds in FingerCoin.
	 * @author Süleyman Taylan Topaloğlu
	 */
	class SoundChangeListener implements ChangeListener //TODO
	{
		public void stateChanged(ChangeEvent e)
		{
			
		}
	}
	
	/**
	  * For testing
	  */
	public static void main(String[] args)
	{
		JFrame fr;
		SettingsPanel s = new SettingsPanel();
		fr = new JFrame();
		fr.add(s);
		fr.setSize(800, 1350);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}