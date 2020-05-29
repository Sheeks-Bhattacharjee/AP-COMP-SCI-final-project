import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class BadPellet extends JComponent
{
	
	public BadPellet(int x, int y) 
	{
		this.setSize(new Dimension(21,41));
		this.setLocation(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(65,0,77,1));
		g.fillOval(0, 20, 20, 17);
		g.setColor(Color.black);
		g.fillRect(10, 15, 3, 7);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(5, 13, 5, 3);
	}

}
