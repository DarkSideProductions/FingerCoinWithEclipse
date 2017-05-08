package viewClasses;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
/**
 * This class shows the creators of the Finger Coin game to the user.
 * @author Oğuzhan Ayla, Süleyman Taylan Topaloğlu
 * @version 01.05.2017
 */
public class CreditsPanel extends JPanel
{
   //properties
   JLabel label;
   JButton button1;
   JButton button2;
   JButton button3;
   JButton button4;
   JButton button5;
   JButton button6;
   private JButton back;
   private GeneralListener gl;
   private BufferedImage background;
   
   /**
    * Constructor
    */
   public CreditsPanel()
   {
      label = new JLabel("CREDITS");
      button1 = new JButton("Arda Yüksel");
      button2 = new JButton("Süleyman Taylan Topaloğlu");
      button3 = new JButton("Mustafa Bay");
      button4 = new JButton("Ceyhun Emre Öztürk");
      button5 = new JButton("Talha Murathan Göktaş");
      button6 = new JButton("Mehmet Oğuzhan Ayla");
      back = new JButton("Back to settings");
      gl = new GeneralListener();
      
      setLayout(null);
      setPreferredSize(new Dimension(800,1080));
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setBounds(350, 50, 100, 50);
      label.setFont(new Font("Arial", 1, 20));
      label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      back.setBounds(50, 30, 70, 20);
      back.addActionListener(gl);
      button1.setBounds(290, 250, 220, 50);
      button2.setBounds(290, 350, 220, 50);
      button3.setBounds(290, 450, 220, 50);
      button4.setBounds(290, 550, 220, 50);
      button5.setBounds(290, 650, 220, 50);
      button6.setBounds(290, 750, 220, 50);
      button1.setContentAreaFilled(false);
      button2.setContentAreaFilled(false);
      button3.setContentAreaFilled(false);
      button4.setContentAreaFilled(false);
      button5.setContentAreaFilled(false);
      button6.setContentAreaFilled(false);
      button1.setFont(new Font("Arial", 1, 13));
      button2.setFont(new Font("Arial", 1, 13));
      button3.setFont(new Font("Arial", 1, 13));
      button4.setFont(new Font("Arial", 1, 13));
      button5.setFont(new Font("Arial", 1, 13));
      button6.setFont(new Font("Arial", 1, 13));
      try
      {
    	  background = ImageIO.read(new File("table.jpg"));
      }
      catch(IOException e){}
      add(label);
      add(button1);
      add(button2);
      add(button3);
      add(button4);
      add(button5);
      add(button6);
      add(back);
   }
   
   /**
    * Paints the panel.
    * @param g is the graphic instructions.
    */
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   g.drawImage(background, 0, 0, 800, 1200, null);
   }
   
   /**
    * This method is for test purposes.
    */
   public static void main(String[] args)
   {
	   JFrame fr = new JFrame();
	   fr.add(new CreditsPanel());
	   fr.setSize(800, 1080);
	   fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   fr.setVisible(true);
   }
}
