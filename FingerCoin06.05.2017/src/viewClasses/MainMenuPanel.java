package viewClasses;
import playground.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;
/**
 * This class creates the main menu for FingerCoin.
 * @author Süleyman Taylan Topaloðlu
 * @version 30.04.2017
 */
public class MainMenuPanel extends JPanel
{
   //properties
   private JButton singlePlayer, multiPlayer, settings, exit;
   private JPanel nextPanel;
   private Image background;
   private MainClickListener cl;
   //constructors
   public MainMenuPanel()
   {
      singlePlayer = new JButton("Single Player");
      multiPlayer = new JButton("Multi Player");
      settings = new JButton("Settings");
      exit = new JButton("Exit");
      cl = new MainClickListener();
      try
      {
         background = ImageIO.read(new File("table.jpg"));
      }
      catch(IOException e){}
      singlePlayer.addActionListener(cl);
      multiPlayer.addActionListener(cl);
      settings.addActionListener(cl);
      exit.addActionListener(cl);
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
      // TODO sizings and arrangements
   }
   
   //methods
   /**
    * Paints the panel and background.
    * @param g the Graphics object.
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage((Image) background, 0, 0, 800, 1200, null);
   }
   
   /**
    * This class is the listener of the buttons in the Main Menu of FingerCoin.
    * @author Süleyman Taylan Topaloðlu
    */
   class MainClickListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) //TODO
      {
         /*if(((JButton)e.getSource()).equals(singlePlayer))
          {
          setEnabled(false);
          //nextPanel = new GamePanel();
          //nextPanel.setEnabled(true);
          }*/
         if(((JButton)e.getSource()).equals(multiPlayer))
         {
            setEnabled(false);
            nextPanel = new NameSelectionPanel();
            nextPanel.setEnabled(true);
         }
         if(((JButton)e.getSource()).equals(settings))
         {
            setEnabled(false);
            nextPanel = new SettingsPanel();
            nextPanel.setEnabled(true);
         }
         if(((JButton)e.getSource()).equals(exit))
         {
            System.exit(0);
         }
      }
   }
   
   //This method is for test purposes.
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

