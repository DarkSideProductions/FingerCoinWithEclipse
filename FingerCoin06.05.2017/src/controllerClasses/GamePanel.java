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

	/**
	 * This class controls the "actions" of the Finger Coin game by using javax.swing.Timer and simulates the game by
	 * creating instances of classes the game has.
	 * @author Ceyhun Emre Öztürk, Mustafa Bay, Arda Yüksel, Murathan Göktaþ
	 * @version 04.05.2017
	 */
	public class GamePanel extends JPanel
	{
	   //Properties
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
	   boolean pressed;
	   double directionR;
	   double directionAngle;
	   double force;
	   
	   
	   
	   /**
	    * Constructor
	    * @tlm difficultyLevel is the difficulty level of the game
	    * @tlm numOfPlayers is the number of players
	    */
	   public GamePanel( int difficultyLevel, int numOfPlayers, int coinType)
	   {
		   setPreferredSize(new Dimension(600,700) );
		   mouse = new SelectingCoin();
		   addMouseListener(mouse);
		   key = new CheckingForceAndDirection();
		   listen = new GameListener();
		   addKeyListener(key);
		   setFocusTraversalKeysEnabled(false);
		   setFocusable(true);
		   this.timer = new Timer(10,listen);
		   initGame( difficultyLevel, numOfPlayers, coinType);
	   }
	   
	   public void initGame( int difficultyLevel, int numOfPlayers, int coinType)
	   {
	
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
	          one = new Coin(300,30);
		      two = new Coin(360,590);
		      three = new Coin(240,590);
		      goal = new Goal(600,0);
		      oneVisual = new CoinVisual(one, f);
		      twoVisual = new CoinVisual(two, f);
		      threeVisual = new CoinVisual(three, f);
		      goalKeeper = new Goalkeeper(difficultyLevel, 290, 0);
		      goalkeeperVisual = new GoalkeeperVisual(difficultyLevel, goalKeeper);
		      goalVisual = new GoalVisual(goal);
		      pitchVisual =  new FieldVisual(600,700);
		      elements = new ArrayList<Drawable>();
		      elements.add(one);
		      elements.add(two);
		      elements.add(three);
		      elements.add(goalKeeper);
		      coins = new ArrayList<Coin>();
		      coins.add(one);
		      coins.add(two);
		      coins.add(three);
		      field = new Field(difficultyLevel,800,800,elements);
		      directionR = 1;
		      directionAngle = Math.PI / 2;
		      force = 3;
		      pressed = true;
	   }
	   
	   private class SelectingCoin extends MouseAdapter
	   {
		   public SelectingCoin()
		     {
		     } 
		   @Override
		   public void mousePressed(MouseEvent e)
		   {
			    if(one.contains(e.getX(),e.getY()) )
				   {
					   one.choose(true);
					   two.choose(false);
					   three.choose(false);
					   System.out.println(1);
					   pressed = false;
					   }
				   else if(two.contains(e.getX(),e.getY()) )
				   {
					   one.choose(false);
					   two.choose(true);
					   three.choose(false);
					   System.out.println(2);
					   pressed = false;
					   }
				   else if(three.contains(e.getX(),e.getY()) )
				   {
					   one.choose(false);
					   two.choose(false);
					   three.choose(true);
					   System.out.println(3);
					   pressed = false;
					   }
		   }
		   
	   }
	   public void paintComponent(Graphics g){
		   super.paintComponent(g);
		   pitchVisual.draw(g);
		   oneVisual.paint(g);
		   twoVisual.paint(g);
		   threeVisual.paint(g);
		   goalkeeperVisual.paint(g);
	   }
	   
	   private class CheckingForceAndDirection extends KeyAdapter
	   {
		 public CheckingForceAndDirection()
	     {
			   System.out.println("a");
			    
	     }

	     public void keyPressed(KeyEvent e)
	     {
	        System.out.println("b");
	   	    if(true) {
	    	 if(e.getKeyCode()== KeyEvent.VK_A){
	    		 if(directionAngle < Math.PI)
	    			    directionAngle = directionAngle + (Math.PI/200);
	    		 System.out.println("pressed A");
	    		 System.out.println(directionAngle);
	    	 }
            
	    	 else if(e.getKeyCode()== KeyEvent.VK_D){
	    		  directionAngle = directionAngle - (Math.PI/200);
		    	 if(directionAngle < 0){directionAngle = 0;}
	            System.out.println("pressed D");
	    		 System.out.println(directionAngle);
		     }
	    	 
	    	 else if(e.getKeyCode()== KeyEvent.VK_W){
	    		 if(force < 5)
	                    force++;
	    		 System.out.println("pressed W");
	    		 System.out.println(force);
	    	 }
	    	 
             else if(e.getKeyCode() == KeyEvent.VK_S){
            	 if(force > 0)
	                    force--;
            	 System.out.println("pressed S");
            	 System.out.println(force);
	    	 }
             else if(e.getKeyCode()== KeyEvent.VK_ENTER){
            	 timer.start();
            	 pressed = true;
            	 System.out.println("pressed Enter");
            	 for(Coin c : coins){
  				   if(c.isChosen()){
  					   field.pushCoin((Coin)c, force, directionR*Math.cos(directionAngle), directionR*Math.sin(directionAngle));
  				 }
  			   }
	    	 }
	       }
	     }
	   }  

	   private class GameListener implements ActionListener
	   {
		   private GameListener()
		   {
		   }
		   public void actionPerformed(ActionEvent e)
		   {
			   System.out.println("rep0");
			   repaint();
			   if( !field.isGameOver() ){
				   for(Coin c : coins){
	  				   if(c.isChosen()){
	  					   field.slowDown((Coin)c);
	  					   goalKeeper.move();
	  					 System.out.println("rep1");
	  				   }
	  				   System.out.println("rep2");
	  				   System.out.println(((Coin)c).getVelocityX());
	  				   System.out.println(((Coin)c).getVelocityY());
	  				 if( c.isChosen()  && ((Coin)c).getVelocityX() == 0 && ((Coin)c).getVelocityY() == 0 ){
	  					 timer.stop();
	  				   }
			   }
				  
		   }
			   else{
				 JOptionPane.showMessageDialog(GamePanel.this, "Play again? ", "Game over", 0);

			   }
		}
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setSize(700,700);
	    frame.setVisible(true);
	    frame.setLayout(new BorderLayout());
	    GamePanel x = new GamePanel(2,1,1);
	    frame.add(x, BorderLayout.CENTER);
	    frame.pack();
	}
}
	   