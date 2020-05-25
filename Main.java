import java.awt.Insets;
import java.awt.event.ActionListener;

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
	}

	public static void main(String[] args) 
	{
		new Main();
	}

}
