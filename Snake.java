import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Snake extends JComponent
{
	private int dx, dy;
	private Ellipse2D.Double snek = new Ellipse2D.Double(0,0,20,20);
	private Rectangle borderSnek;
	public Snake(int x, int y) 
	{
		this.setSize(new Dimension(21,21));
		this.setLocation(x,y);
		
		borderSnek = new Rectangle (x,y,20,20);
	}
	
	public Rectangle returnBorder()
	{
		return borderSnek;
	}
	
	private void setBorder(int x, int y)
	{
		borderSnek.setLocation(x, y);
	}
	
	public void setDx(int dx)
	{
		this.dx = dx;
	}
	
	public void setDy(int dy)
	{
		this.dy = dy;
	}
	
	public void update()
	{
		this.setLocation(this.getX() + dx, this.getY() + dy);
		this.setBorder(this.getX(), this.getY());
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(10, 255, 55, 255));				//new Color(210,255,53,255));
		g2.fill(snek);
		
		g2.setColor(Color.BLACK);
		g2.draw(snek);
	}
}
