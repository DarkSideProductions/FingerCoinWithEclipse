package controllerClasses;
import javax.swing.*;
import viewClasses.*;
import playground.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.Timer;
import java.io.*;
import java.util.ArrayList;
import java.awt.geom.Line2D;
/**
 * This class controls the "actions" of the Finger Coin game by using javax.swing.Timer and simulates the game by
 * creating instances of classes the game has.
 * @author Ceyhun Emre Öztürk, Mustafa Bay, Arda Yüksel, Murathan Göktaş
 * @version 04.05.2017
 */
public class GamePanel extends JPanel
{
	//Properties
	PowerPanel power;
	DirectionPanel direction;
	Timer timer;
	MouseAdapter mouse;
	GameListener listen;
	CheckingForceAndDirection key;
	CoinVisual oneVisual, twoVisual, threeVisual;
	Coin one, two, three;
	Goal goal;
	GoalVisual goalVisual;
	Goalkeeper goalKeeper;
	GoalkeeperVisual goalkeeperVisual;
	FieldVisual pitchVisual;
	Field field;
	File f;
	JPanel pitchvisual;
	Graphics2D g;
	ArrayList<Drawable> elements;
	ArrayList<Coin> coins; 
	int pause;
	boolean pressed;
	double directionR;
	double directionAngle;
	double force;
	BufferedImage background;
	int turn;
	double[] initialCoordinates;
	int triesOfPlayer1;
    int triesOfPlayer2;
    int numOfPlayers;
    boolean isPlayer1sTurn;
    boolean hasPlayer1Scored;
    int difficultyLevel;
    int lectureModeCheck;
    
	/**
	 * Constructor
	 * @tlm difficultyLevel is the difficulty level of the game
	 * @tlm numOfPlayers is the number of players
	 */
	public GamePanel( int difficultyLevel, int numOfPlayers, int coinType)
	{
		setPreferredSize(new Dimension( 600, 700) );
		mouse = new SelectingCoin();
		addMouseListener( mouse);
		key = new CheckingForceAndDirection();
		listen = new GameListener();
		addKeyListener( key);
		setFocusTraversalKeysEnabled( false);
		setFocusable( true);
		this.timer = new Timer( 10, listen);
		
		try
		{
			background = ImageIO.read(new File("table.jpg"));
		}
		catch(IOException e){}

		if ( coinType == 0)
		{
			f = new File( "tl.png");
		}
		else if ( coinType == 1)
		{
			f = new File( "dolar.png");
		}
		else
		{
			f = new File( "euro.png");
		}
		this.numOfPlayers = numOfPlayers;
		isPlayer1sTurn = true;
		this.difficultyLevel = difficultyLevel;
		initGame( difficultyLevel);
	}

	/**
	 * Initates the game with the arrangement of the field elements.
	 * @param difficultyLevel is the difficulty level of the game.
	 */
	public void initGame( int difficultyLevel)
	{
		one = new Coin( 300, 630);
		two = new Coin( 360, 590);
		three = new Coin( 240, 590);
		goal = new Goal( 300, 0);
		oneVisual = new CoinVisual( one, f);
		twoVisual = new CoinVisual( two, f);
		threeVisual = new CoinVisual( three, f);
		goalKeeper = new Goalkeeper( difficultyLevel, 290, 0);
		goalkeeperVisual = new GoalkeeperVisual(difficultyLevel, goalKeeper);
		goalVisual = new GoalVisual( goal);
		pitchVisual =  new FieldVisual( 600, 700);
		elements = new ArrayList<Drawable>();
		elements.add( one);
		elements.add( two);
		elements.add( three);
		elements.add( goalKeeper);
		elements.add( goal);
		coins = new ArrayList<Coin>();
		coins.add( one);
		coins.add( two);
		coins.add( three);
		field = new Field( difficultyLevel, 600, 700, elements);
		directionR = 1;
		directionAngle = Math.PI / 2;
		force = 3;
		power = new PowerPanel( force);
		direction = new DirectionPanel( directionAngle);
		pause = 0;
		pressed = true;
		lectureModeCheck = 0;
	}

	/**
	 * This class makes the coins selectable by the mouse.
	 */
	private class SelectingCoin extends MouseAdapter
	{
		/**
		 * Constructor
		 */
		public SelectingCoin()
		{
		} 

		/**
		 * Handles the things that happen when the mouse is pressed.
		 * @param e is the created event by pressing with the mouse
		 */
		@Override 
		public void mousePressed( MouseEvent e)
		{
			if(one.contains( e.getX(), e.getY()) )
			{
				one.choose( true);
				two.choose( false);
				three.choose( false);
				System.out.println( 1);
				pressed = false;
				pause = 1;
			}
			else if(two.contains(e.getX(),e.getY()) )
			{
				one.choose( false);
				two.choose( true);
				three.choose( false);
				System.out.println(2);
				pressed = false;
				pause = 1;
			}
			else if(three.contains(e.getX(),e.getY()) )
			{
				one.choose( false);
				two.choose( false);
				three.choose( true);
				System.out.println( 3);
				pressed = false;
				pause = 1;
			}
			repaint();
		}

	}

	/**
	 * This method paints the GameMenu panel and any element on it.
	 * @param g has the painting instructions.
	 */
	public void paintComponent( Graphics g){
		super.paintComponent(g);
		g.drawImage( background, 0, 0, 600, 700, null);
		pitchVisual.draw( g);
		oneVisual.paint( g);
		twoVisual.paint( g);
		threeVisual.paint( g);
		goalkeeperVisual.paint( g);
		goalVisual.paint( g);
		requestFocusInWindow(true);
	}

	/**
	 * Returns the PowerPanel instance of this class.
	 * @return the PowerPanel object as a JPanel object
	 */
	public JPanel returnPower(){
		return power;
	}

	/**
	 * Returns the DirectionPanel instance of this class.
	 * @return the DirectionPanel object as a JPanel object
	 */
	public JPanel returnDirection(){
		return direction;
	}

	/**
	 * Stops the timer when the game is paused by the user.
	 */
	public void pauseTimer(){
		timer.stop();
		pressed = true;
	}

	/**
	 * Gets the timer back to work when the user closes the pause menu.
	 */
	public void loadTimer()
	{
		if( pause == -1){
			timer.start();
		}
		else if( pause == 0){
			pressed = true;
		}
		else if( pause == 1){
			pressed = false;
		}
	}

	/**
	 * This class makes it possible to push the coin, change the direction of the coin and the power applied to it.
	 */
	private class CheckingForceAndDirection extends KeyAdapter
	{
		/**
		 * Changes the situation of the chosen coin according to the pressed button.
		 * @param e is the KeyEvent object created by pressing one of the keys that the game allows to press.
		 */
		public void keyPressed( KeyEvent e)
		{
			if(!pressed) {
				if( e.getKeyCode() == KeyEvent.VK_A){
					if(directionAngle < Math.PI)
						directionAngle = directionAngle + (Math.PI / 180);
				}

				else if( e.getKeyCode() == KeyEvent.VK_D){
					directionAngle = directionAngle - (Math.PI / 180);
					if(directionAngle < 0){directionAngle = 0;}
				}

				else if( e.getKeyCode() == KeyEvent.VK_W){
					if(force < 5)
						force++;
				}

				else if( e.getKeyCode() == KeyEvent.VK_S){
					if(force > 1)
						force--;
				}
				else if( e.getKeyCode() == KeyEvent.VK_ENTER){
					timer.start();
					pause = -1;
					pressed = true;
					for( Coin c : coins){
						if( c.isChosen()){
							initialCoordinates = field.pushCoin( (Coin)c, force, directionR * Math.cos(directionAngle), 
									                             directionR * Math.sin( directionAngle));
						}
					}
					if ( difficultyLevel == 2 && force == 5) {
						lectureModeCheck++;
					}
				}
				direction.setAngle( directionAngle);
				power.setForce( force);
				power.repaint();
				direction.repaint();
				repaint();
			}
		}
	}  

	/**
	 * This class is the listener of the timer class of the game.
	 */
	private class GameListener implements ActionListener
	{
		/**
		 * This class updates the number of tries and checks whether the game is over and who won if the game is over.
		 * @param e is the event created by the each call of the timer.
		 */
		public void actionPerformed( ActionEvent e)
		{
			for(Coin c : coins){
				if(c.isChosen()){
					turn = coins.indexOf(c);
				}
			}
			if( !field.isGameOver() && field.getScore() < field.getTry() && lectureModeCheck < 2){
				for(Coin c : coins){
					if(c.isChosen()){
						field.slowDown((Coin)c);
						goalKeeper.move();
					}
					if( c.isChosen()  && ((Coin)c).getVelocityX() == 0 && ((Coin)c).getVelocityY() == 0 ){
						if( !Line2D.linesIntersect( initialCoordinates[0], initialCoordinates[1], 
								c.getX(), c.getY(), coins.get( (turn + 1) % 3).getX(), coins.get( (turn + 1) % 3).getY(), 
								coins.get( (turn + 2) % 3).getX(), coins.get( (turn + 2) % 3).getX() ))                             
						{
							if ( numOfPlayers == 1)
							{
								JOptionPane.showMessageDialog( GamePanel.this, "You lost ", "Number of tries:" + field.getScore(), 0);
								System.exit(0);//TO DO
							}
							else if ( isPlayer1sTurn) {
								triesOfPlayer1 = field.getScore();
								hasPlayer1Scored = false;
								isPlayer1sTurn = false;
								pause = 0;
								pressed = true;
								JOptionPane.showMessageDialog( GamePanel.this, "You couldn't score. It's now your opponent's turn.", 
										"Number of tries:" + triesOfPlayer1, 0);
								initGame( difficultyLevel);
							}
							else {
								triesOfPlayer2 = field.getScore();
								if ( !hasPlayer1Scored)
								{
									JOptionPane.showMessageDialog( GamePanel.this, "It is a draw.", 
											"Number of Player2's tries:" + triesOfPlayer2, 0);
								}
								else {
									JOptionPane.showMessageDialog( GamePanel.this, "Player1 wins.", 
											"Number of Player2's tries:" + triesOfPlayer2, 0);
								}
								System.exit(0); //TO DO
							}
						}
						timer.stop();
						pause = 1;
					}
				}
				repaint();
			  }
			else if ( field.isInside( coins.get( turn)) && lectureModeCheck < 2) {
				timer.stop();
				if ( numOfPlayers == 1)
				{
					JOptionPane.showMessageDialog( GamePanel.this, "You won", "Number of tries:" + field.getScore(), 0);
					System.exit(0);//TO DO
				}
				else if ( isPlayer1sTurn) {
					triesOfPlayer1 = field.getScore();
					hasPlayer1Scored = true;
					isPlayer1sTurn = false;
					pause = 0;
					pressed = true;
					JOptionPane.showMessageDialog( GamePanel.this, "Congratulations. It's now Player2's turn.", 
							"Number of tries:" + triesOfPlayer1, 0);
					initGame( difficultyLevel);
					repaint();
				}
				else {
					triesOfPlayer2 = field.getScore();
					if ( hasPlayer1Scored)
					{
						if ( triesOfPlayer1 == triesOfPlayer2) {
							JOptionPane.showMessageDialog( GamePanel.this, "It is a draw.", 
									"Number of Player2's tries:" + triesOfPlayer2, 0);
						}
						else if ( triesOfPlayer1 >= triesOfPlayer2) {
							JOptionPane.showMessageDialog( GamePanel.this, "Player2 wins.", 
									"Number of Player2's tries:" + triesOfPlayer2, 0);
						}
						else {
							JOptionPane.showMessageDialog( GamePanel.this, "Player1 wins.", 
									"Number of Player2's tries:" + triesOfPlayer2, 0);
						}
					}
					else {
						JOptionPane.showMessageDialog( GamePanel.this, "Player2 wins.", 
								"Number of Player2's tries:" + triesOfPlayer2, 0);
					}
					System.exit(0); //TO DO
				}
			}
			else {
				timer.stop();
				if ( numOfPlayers == 1)
				{
					JOptionPane.showMessageDialog( GamePanel.this, "You exceeded maximum number of tries or made "
									+ "the coins collide with each other!", "You lost.", 0);
					System.exit(0);//TO DO
				}
				else if ( isPlayer1sTurn)
				{
					triesOfPlayer1 = field.getScore();
					hasPlayer1Scored = false;
					isPlayer1sTurn = false;
					pause = 0;
					pressed = true;
					JOptionPane.showMessageDialog( GamePanel.this, "You couldn't score. It's now your opponent's turn.", 
							"Number of tries:" + triesOfPlayer1, 0);
					initGame( difficultyLevel);
					repaint();
				}
				else {
					triesOfPlayer2 = field.getScore();
					if ( !hasPlayer1Scored)
					{
						JOptionPane.showMessageDialog( GamePanel.this, "It is a draw.", 
								"Number of Player2's tries:" + triesOfPlayer2, 0);
					}
					else {
						JOptionPane.showMessageDialog( GamePanel.this, "Player1 wins.", 
								"Number of Player2's tries:" + triesOfPlayer2, 0);
					}
					System.exit(0); //TO DO
				}
			}

		}
	}

	/**
	 * Returns the field instance of the game.
	 * @return field
	 */
	public Field getField()
	{
		return field;
	}
	
	public int getDifficulty()
	{
		return difficultyLevel;
	}
	
	
	/**
	 * This method is for test purposes.
	 */
	public static void main( String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( 3);
		JPanel directPower = new JPanel();
		directPower.setLayout(new FlowLayout());
		directPower.setSize( 600, 300);
		frame.setSize( 600, 1000);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		GamePanel x = new GamePanel( 0, 1, 2);
		frame.add(x, BorderLayout.CENTER);
		directPower.add(x.returnPower());
		directPower.add(x.returnDirection());
		frame.add(directPower,BorderLayout.SOUTH);
		frame.pack();
	}
}


