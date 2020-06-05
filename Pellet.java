import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.border.Border;

public class Pellet extends JComponent
{
	private Rectangle borderBall;
	public Pellet(int x, int y) 
	{
		this.setSize(new Dimension(21,41));
		this.setLocation(x,y);
		
		borderBall = new Rectangle (x,y,21,41);
	}
	
	public Rectangle returnBorder()
	{
		return borderBall;
	}
	
	private void setBorder(int x, int y)
	{
		borderBall.setLocation(x, y);
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
	
	public void update()
	{
		this.setBorder(this.getX(), this.getY());
	}

}
