import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
public class Pellet {

	private Ellipse2D.Double pellet = new Ellipse2D.Double(0,0,14,14);
	public Pellet(int x, int y) 
	{
		this.setSize(new Dimension(15,15));
		this.setLocation(x,y);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.WHITE);
		g2.fill(pellet);
		g2.setColor(Color.WHITE);
		g2.draw(pellet);
	}
}
