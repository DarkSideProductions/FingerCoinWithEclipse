package viewClasses;
import playground.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class creates the name selection window in the multiplayer mode of FingerCoin.
 * @author Süleyman Taylan Topaloðlu
 * @version 30.04.2017
 */
public class NameSelectionPanel extends JPanel 
{
   //properties
   private JLabel namep1, namep2;
   private JTextField p1, p2;
   private JButton clickToContinue, back;
   private BufferedImage background;
   private JPanel nextPanel, lastPanel;
   private String name1, name2;
   
   //constructors
   public NameSelectionPanel()
   {
      namep1 = new JLabel("First User's Name:");
      namep2 = new JLabel("Second User's Name:");
      p1 = new JTextField();
      p2 = new JTextField();
      back = new JButton("Back");
      clickToContinue = new JButton("CLICK TO CONTINUE");
      try
      {
         background = ImageIO.read(new File("table.jpg"));
      }
      catch(IOException e){}
      // TODO sizings and arrangements
   }
   
   //methods
   /**
    * Paints the panel with the background image.
    * @param g the Graphics reference.
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(background, 0, 0, 800, 1200, null);
   }
   
   /**
    * This class is the listener of the buttons and text fields of name selection window.
    * @author SÃ¼leyman Taylan TopaloÄŸlu
    */
   class NameSelectionListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(((JButton)e.getSource()).equals(back))
         {
            setEnabled(false);
            lastPanel = new MainMenuPanel();
            lastPanel.setEnabled(true);
         }
         if(((JButton)e.getSource()).equals(clickToContinue))
         {
            name1 = p1.getText();
            name2 = p2.getText();
            setEnabled(false);
            //nextPanel = new GamePanel(name1, name2);
            //nextPanel.setEnabled(true);
         }
      }
   }
}

