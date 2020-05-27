import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Snake extends JComponent
{
	private int dx, dy;
	private Rectangle snek =  new Rectangle(0,0,30,15);
	public Snake(int x, int y) 
	{
		this.setSize(new Dimension(31,16));
		this.setLocation(x,y);
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
	}
	


	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLUE);
		g2.fill(snek);
		
		g2.setColor(Color.BLUE);
		g2.draw(snek);
	}
}