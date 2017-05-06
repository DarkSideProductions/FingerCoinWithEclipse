package viewClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
/**
 * This class shows the rules and controls of the game.
 * @author Mustafa Bay
 * @version 01.05.2017
 */
public class InfoPanel extends JPanel
{
//   private BufferedImage background;
  public InfoPanel()
  {
    JButton button = new JButton("Close");
    setLayout(new GridLayout(3,1));
    setSize(100,150);
    JTextArea textField = new JTextArea( "Rules:" + "\n" + 
                                         "The players cannot hit other coins with the chosen one.\n If the player" + 
                                         "hits the other coins, one of the goal posts or the goalkeeper object,\n" +
                                         "the player will automatically lose.\n Also, if the coin does not pass" +
                                         "between the other two coins, the player will immediately lose again.\n" +
                                         "In multiplayer, player with less tries to score a goal wins." + 
                                         "\nControls:\n" + 
                                         "|A| -> Chooses the coin in the left" + "\n" +
                                         "|D| -> Chooses the coin in the right" + "\n" + 
                                         "Arrows -> To change direction" + "\n" + 
                                         "Enter -> To switch to force selection/ To launch coin" + "\n" +
                                         "Escape -> To cancel the latest operation" );  
    textField.setEditable(false);
//    JLabel rules = new JLabel("Rules:" + "\n" + 
//                              "akljhfgkyalhgfuýyghrelaýuh " + "\n" +
//                              "|A| -> ssdakhgjhdsgyda " + "\n" +
//                              "|D| -> fasfdfsgasggasg" + "\n" + 
//                              "|->| -> dkfhagjhdasgfd" + "\n" + 
//                              "|<-| -> chjasvgcadvc" );
    JLabel rulesOfTheGame = new JLabel ("Rules And Controls Of The Game");
//    try
//    {
//       background = ImageIO.read(new File("table.jpg"));
//    }
//    catch(IOException e){}
    add(rulesOfTheGame);
    add(textField);
    add(button);
  }
  
  /**
  public void paintComponent(Graphics g)
  {
     super.paintComponent(g);
     g.drawImage( background,0,0,800,1200,null);
  }
  */
  
  //This method is for test purposes.
  public static void main(String[] args)
  {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    window.getContentPane().add(new InfoPanel());
    window.setVisible(true);
  }
}