import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener
{
	private Snake snek = new Snake((int)(Math.random()*900), (int)(Math.random()*600));
	private Pellet ball = new Pellet((int)(Math.random()*800), (int)(Math.random()*500));
	
	private JPanel p = new JPanel();
	private Insets insets = new Insets(0,0,70,0);
	public Main() 
	{
		setTitle("Snake: The Game");
		setLayout(null);
		setBounds(0,0,900,600);
		setResizable(false);
		
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_W)
					snek.setDy(-1);
				if(e.getKeyCode() == e.VK_S)
					snek.setDy(1);
					
				if(e.getKeyCode() == e.VK_UP)
					snek.setDy(-1);
				if(e.getKeyCode() == e.VK_DOWN)
					snek.setDy(1);
					
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
//				if(e.getKeyCode() == e.VK_W)
//					snek.setDy(0);
//				if(e.getKeyCode() == e.VK_S)
//					snek.setDy(0);
//					
//				if(e.getKeyCode() == e.VK_UP)
//					snek.setDy(0);
//				if(e.getKeyCode() == e.VK_DOWN)
//					snek.setDy(0);
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
		});
	}

	public static void main(String[] args) 
	{
		new Main();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(snek.getY() < 0)
			snek.setDy(1);
		if(snek.getX() < 0)
			snek.setDy(-1);
		if(ball.getY() + ball.getHeight() > this.getContentPane().getHeight())
			snek.setDy(-1);
		if(ball.getX() + ball.getWidth() > this.getContentPane().getWidth())
			snek.setDy(1);
		
	}

}