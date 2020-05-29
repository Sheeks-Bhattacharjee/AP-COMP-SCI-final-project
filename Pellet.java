import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
public class Pellet extends JComponent
{
	
	public Pellet(int x, int y) 
	{
		this.setSize(new Dimension(21,41));
		this.setLocation(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(0, 20, 20, 17);
		g.setColor(Color.black);
		g.fillRect(10, 15, 3, 7);
		g.setColor(Color.green);
		g.fillRect(5, 13, 5, 3);
	}

}
