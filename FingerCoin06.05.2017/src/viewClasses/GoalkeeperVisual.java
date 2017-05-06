package viewClasses;
import java.awt.Graphics;
import playground.*;

public class GoalkeeperVisual {
	  Goalkeeper keeper;
	  public GoalkeeperVisual(int difficulty, Goalkeeper keeper1)
	  {
	    keeper = keeper1;
	  }
	  public void paint(Graphics g) {
	    g.drawRect ((int)keeper.getX(), (int)keeper.getY(), (int)keeper.getHeight(), (int)keeper.getWidth());
	  }
}
