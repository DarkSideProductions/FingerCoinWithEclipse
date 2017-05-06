package viewClasses;
import java.awt.*;
import javax.swing.*;
/**
 * This class shows the creators of the Finger Coin game to the user.
 * @author Oðuzhan Ayla
 * @version 01.05.2017
 */
public class Credits extends JPanel
{
   //properties
   JLabel label;
   JButton button1;
   JButton button2;
   JButton button3;
   JButton button4;
   JButton button5;
   JButton button6;
   
   /**
    * Constructor
    */
   public Credits()
   {
      label = new JLabel("CREDITS");
      button1 = new JButton("Arda Yüksel");
      button2 = new JButton("Taylan Toplaoðlu");
      button3 = new JButton("Mustafa Bay");
      button4 = new JButton("Ceyhun Öztürk");
      button5 = new JButton("Murathan Göktaþ");
      button6 = new JButton("Oðuzhan Ayla");
      
      this.add(label);
      this.add(button1);
      this.add(button2);
      this.add(button3);
      this.add(button4);
      this.add(button5);
      this.add(button6);
   }
}
