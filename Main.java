import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener
{
	private Snake snek = new Snake((int)(Math.random()*900), (int)(Math.random()*600));
	private Pellet ball = new Pellet((int)(Math.random()*800), (int)(Math.random()*500));
	
	
	
	private JPanel main = new JPanel();
	private Insets insets = new Insets(0,0,70,0);
	public Main() 
	{
		setTitle("Snake: The Game");
		setLayout(null);
		setBounds(0,0,900,600);
		setResizable(false);
		
		CardLayout c1 = new CardLayout();
		main.setLayout(c1);
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel inst = new JLabel("USE THE WASD KEYS TO MOVE THE SNAKE!");
		inst.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		inst.setForeground(Color.WHITE);
		panel1.add(inst,gbc);
		JButton cont = new JButton("CLICK TO CONTINUE");
		cont.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				c1.show(main, "second");
			}
		});
		gbc.gridx++;
		panel1.add(cont,gbc);
		panel1.setBackground(new Color(0,0,77,255));
		panel1.setSize(new Dimension(900,600));
		main.add(panel1, "first");
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		gbc.gridx = 0;
		panel2.setPreferredSize(new Dimension(900,600));
		pack();
		
		panel2.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_W)
					snek.setDy(-1);
				if(e.getKeyCode() == e.VK_S)
					snek.setDy(1);
				if(e.getKeyCode() == e.VK_A)
					snek.setDx(-1);
				if(e.getKeyCode() == e.VK_D)
					snek.setDx(1);
			}
			public void keyTyped(KeyEvent e) 
			{
			}
			public void keyReleased(KeyEvent e) 
			{
			}
		});
		
		panel2.add(snek);
		panel2.add(ball);
		
		main.add(panel2);
		
		c1.show(main, "first");
		this.add(main);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new Main();
	}

	public void actionPerformed(ActionEvent e) 
	{		
	}

}
