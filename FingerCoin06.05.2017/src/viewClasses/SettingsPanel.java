package viewClasses;
import playground.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class creates the Settings class for FingerCoin.
 * @author Süleyman Taylan Topaloðlu
 * @version 30.04.2017
 */
public class SettingsPanel extends JPanel
{
   //properties
   private JButton easy, medium, hard, lecture;
   private JSlider sound;
   private JButton back, rules, credits;
   private JPanel lastPanel, nextPanel;
   private SettingsClickListener cl;
   private JButton nextCoin, prevCoin;
   private BufferedImage coin, nextC, prevC;
   private Image background, temp;
   private SoundChangeListener chL;
   private Integer coinType;
   private JLabel settings, diff, cType, volume;
   
   //constructor
   public SettingsPanel()
   {
      easy = new JButton("Easy");
      medium = new JButton("Medium");
      hard = new JButton("Hard");
      lecture = new JButton("LECTURE");
      sound = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
      back = new JButton("Back");
      rules = new JButton("RULES");
      credits = new JButton("CREDITS");
      cl = new SettingsClickListener();
      chL = new SoundChangeListener();
      settings = new JLabel("Settings");
      diff = new JLabel("Difficulty");
      cType = new JLabel("Coin");
      volume = new JLabel("Sound");
      try
      {
         background = ImageIO.read(new File("table.jpg"));
         nextC = ImageIO.read(new File("right.png"));
         prevC = ImageIO.read(new File("left.png"));
         coin = ImageIO.read(new File("para.jpg"));
         coinType = 1;
      }
      catch(IOException e){}
      nextCoin = new JButton(new ImageIcon(nextC.getScaledInstance(50, 50, BufferedImage.TYPE_INT_ARGB)));
      nextCoin.setContentAreaFilled(false);
      nextCoin.setBorderPainted(false);
      nextCoin.setOpaque(false);
      nextCoin.setBounds(450, 350, 50, 50);
      prevCoin = new JButton(new ImageIcon(prevC.getScaledInstance(48, 48, BufferedImage.TYPE_INT_ARGB)));
      prevCoin.setContentAreaFilled(false);
      prevCoin.setBorderPainted(false);
      prevCoin.setOpaque(false);
      prevCoin.setBounds(300, 350, 50, 50);
      
      easy.addActionListener(cl);
      medium.addActionListener(cl);
      hard.addActionListener(cl);
      lecture.addActionListener(cl);
      rules.addActionListener(cl);
      credits.addActionListener(cl);
      back.addActionListener(cl);
      sound.addChangeListener(chL);
      
      
      setPreferredSize(new Dimension(800, 1200));
      setLayout(null);
      sound.setBounds(275, 550, 200, 20);
      sound.setOpaque(false);
      easy.setBounds(200, 200, 100, 30);
      medium.setBounds(320, 200, 100, 30);
      hard.setBounds(440, 200, 100, 30);
      lecture.setBounds(560, 200, 100, 30);
      rules.setBounds(350, 700, 100, 50);
      credits.setBounds(350, 800, 100, 50);
      rules.setOpaque(false);
      rules.setContentAreaFilled(false);
      credits.setOpaque(false);
      credits.setContentAreaFilled(false);
      back.setBounds(50, 30, 70, 20);
      settings.setBounds(350, 50, 100, 50);
      settings.setFont(new Font("Arial", 0, 25));
      diff.setBounds(30, 190, 100, 50);
      diff.setFont(new Font("Arial", 0, 25));
      cType.setBounds(30, 340, 100, 50);
      cType.setFont(new Font("Arial", 0, 25));
      volume.setBounds(30, 540, 100, 50);
      volume.setFont(new Font("Arial", 0, 25));
      // TODO sizings and arrangements
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
   }
   
   /**
    * This class is the listener of the Settings panel buttons in FingerCoin.
    * @author Süleyman Taylan Topaloðlu
    */
   class SettingsClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) //TODO much work here
      {
         if(((JButton)e.getSource()).equals(back))
         {
            setEnabled(false);
            lastPanel = new MainMenuPanel();
            lastPanel.setEnabled(true);
         }
         if(((JButton)e.getSource()).equals(rules))
         {
            setEnabled(false);
            //nextPanel = new InfoPanel();
            nextPanel.setEnabled(true);
            
         }
         if(((JButton)e.getSource()).equals(credits))
         {
            setEnabled(false);
            //nextPanel = new CreditsPanel();
            nextPanel.setEnabled(true);
         }
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
         /*if(((JButton)e.getSource()).equals(nextCoin) /*&& coinType == 1)
          {
          try
          {
          coin = ImageIO.read(new File("coin2.jpg"));
          }
          catch(IOException f){}
          coinType = 2;
          }*/
         /*if(((JButton)e.getSource()).equals(prevCoin) /*&& coinType == 2)
          {
          try
          {
          coin = ImageIO.read(new File("coin.jpg"));
          }
          catch(IOException f){}
          //coinType = 1;
          }*/
         repaint();
      }
      
   }
   
   /**
    * This class listens the sliding bar that changes sounds in FingerCoin.
    * @author Süleyman Taylan Topaloðlu
    */
   class SoundChangeListener implements ChangeListener //TODO
   {
      public void stateChanged(ChangeEvent e)
      {
         
      }
   }
   
   //This method is for test purposes
   public static void main(String[] args)
   {
      JFrame fr = new JFrame();
      SettingsPanel s = new SettingsPanel();
      fr.add(s);
      fr.setSize(800, 1350);
      fr.setVisible(true);
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}