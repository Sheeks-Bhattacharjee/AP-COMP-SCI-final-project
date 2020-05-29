import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener
{ 
	private Snake snek = new Snake(450,300);
	private Rectangle borderSnek = new Rectangle (450,300,15,15);
	private Pellet ball = new Pellet((int)(Math.random()*800), (int)(Math.random()*500));
	private BadPellet bad = new BadPellet((int)(Math.random()*800), (int)(Math.random()*500));
	private Rectangle borderBad = new Rectangle (bad.getX(), bad.getY(),21,41);
	private Rectangle borderBall = new Rectangle (ball.getX(), ball.getY(),21,41);
	
	private boolean gameOver = false;
	private JLabel gameEnd = new JLabel("");

	//private JPanel main = new JPanel();
//	private Insets insets = new Insets(0,0,70,0);
	public Main() 
	{
		this.setTitle("Snake: The Game");
		this.setBounds(0,0,900,600);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(900,600));
		this.pack();
		this.setLayout(null);
		
//		CardLayout c1 = new CardLayout();
//		main.setLayout(c1);
		
		//panel1 start
		
//		JPanel panel1 = new JPanel();
//		panel1.setSize(new Dimension(900,600));
//		panel1.setLayout(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
//		panel1.setBackground(new Color(0,0,77,255));
//		
//		JLabel inst = new JLabel("USE THE WASD KEYS TO MOVE THE SNAKE!");
//		inst.setFont(new Font("SERIF", Font.BOLD, 15));
//		inst.setForeground(Color.WHITE);
//		inst.setSize(400,40);
//		panel1.add(inst,gbc);
//		
//		JLabel inst2 = new JLabel(" COLLECT ALL THE PELLETS!");
//		inst2.setFont(new Font("SERIF", Font.PLAIN, 15));
//		inst2.setForeground(Color.WHITE);
//		inst2.setSize(400,40);
//		gbc.gridy++;
//		panel1.add(inst2,gbc);
//		
//		JButton cont = new JButton("CLICK TO CONTINUE");
//		cont.setSize(250,100);
//		cont.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				c1.show(main, "second");
//			}
//		});
//		gbc.gridx++;
//		gbc.gridy--;
//		gbc.gridwidth = 2;
//		panel1.add(cont,gbc);
//		
//		main.add(panel1, "first");
		
		//panel2 start
		
		JPanel panel2 = new JPanel();
//		panel2.setLayout(new GridBagLayout());
		panel2.setSize(new Dimension (900,600));
		
		this.gameEnd.setBounds(new Rectangle(250,50,900,50));
		this.gameEnd.setLocation(0, this.getContentPane().getHeight()-50);
		this.gameEnd.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		this.gameEnd.setForeground(Color.WHITE);
		this.add(this.gameEnd);
		
//		pack();
		
		this.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_W)
				{
					snek.setDy(-2);
					snek.setDx(0);
				}
				if(e.getKeyCode() == e.VK_S)
				{
					snek.setDy(2);
					snek.setDx(0);
				}
				if(e.getKeyCode() == e.VK_A)
				{
					snek.setDx(-2);
					snek.setDy(0);
				}
				if(e.getKeyCode() == e.VK_D)
				{
					snek.setDx(2);
					snek.setDy(0);
				}
			}
			public void keyTyped(KeyEvent e) 
			{
			}
			public void keyReleased(KeyEvent e) 
			{
			}
		});
		
		this.add(snek);
		this.add(ball);
		this.add(bad);
		
//		main.add(panel2, "second");
//		
//		c1.show(main, "first");
//		this.add(main);
		
		panel2.setBackground(Color.white);
		this.add(panel2);
		
		Timer t1 = new Timer(10,this);
		t1.start();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new Main();
	}

	public void actionPerformed(ActionEvent e) 
	{
		snek.update();
		borderSnek.setLocation(snek.getX(), snek.getY());
		
		if (borderSnek.intersects(borderBall))
		{
			ball.setLocation((int)(Math.random()*800), (int)(Math.random()*500));
			borderBall.setLocation(ball.getX(), ball.getY());
		}
		
		if(borderSnek.intersects(borderBad))
			gameOver = true;
		
		if(gameOver)
		{
			snek.setDx(0);
			snek.setDy(0);
			remove(ball);
			gameEnd.setText("GAME OVER");
			return;
		}
		repaint();
	}
}
