import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Snake 
{
	private Rectangle snek =  new Rectangle(0,0,30,15);
	public Snake(int x, int y) 
	{
		this.setSize(new Dimension(31,16));
		this.setLocation(x,y);
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
