package viewClasses;
import playground.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * This class creates the singleplayer scoreboard of FingerCoin.
 * @author Süleyman Taylan Topaloðlu
 * @version 30.04.2017
 */
public class SingleScorePanel extends JPanel
{
   //properties
   private JLabel chances;
   private int trycount;
   private JPanel nextPanel;
   private JButton gameMenu;
   private SingleScorePanelClickListener cl;
   
   //constructors
   public SingleScorePanel()
   {
      //trycount = xx.getScore();
      chances = new JLabel("Chances Left: " + trycount + " Tries");
      gameMenu = new JButton("GAME MENU");
      cl = new SingleScorePanelClickListener();
      gameMenu.addActionListener(cl);
      add(gameMenu);
      add(chances);
   }
   
   //methods
   /**
    * Paints the scoreboard.
    * @param g the Graphics object.
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawRect(0, 0, 800, 120);
   }
   
   /**
    * This class is the listener of the game menu button in the singleplayer mode of FingerCoin.
    * @author Süleyman Taylan Topaloðlu
    */
   class SingleScorePanelClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(((JButton)e.getSource()).equals(gameMenu))
         {
            setEnabled(false);
            //xx.pause();(?)
            //nextPanel = new InfoPanel();
            //nextPanel.setEnabled(true);
         }
      }
   }
}