package viewClasses;
import playground.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class creates the multiplayer scoreboard of FingerCoin.
 * @author Süleyman Taylan Topaloðlu
 * @version 30.04.2017
 */
public class MultiScorePanel extends JPanel
{
   //properties
   private JLabel p1 , p2;
   private int trycount1, trycount2;
   private JPanel nextPanel;
   private JButton gameMenu;
   private MultiScorePanelClickListener cl;
   
   //constructors
   public MultiScorePanel()
   {
      // trycount1 = xx.getScore(1);
      // trycount2 = xx.getScore(2);
      p1 = new JLabel("First Player: " + trycount1 + "Tries");
      p2 = new JLabel("Second Player: " + trycount2 + "Tries");
      gameMenu = new JButton("GAME MENU");
      cl = new MultiScorePanelClickListener();
      gameMenu.addActionListener(cl);
      add(gameMenu);
      add(p1);
      add(p2);
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
    * This class is the listener of the game menu button in the multiplayer mode of FingerCoin.
    * @author SÃ¼leyman Taylan TopaloÄŸlu
    */
   class MultiScorePanelClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(((JButton)e.getSource()).equals(gameMenu))
         {
             setEnabled(false);
             //nextPanel = new InfoPanel();
             //nextPanel.setEnabled(true);
          }
       }
    }
}

