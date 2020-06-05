import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener
{ 
	private Snake snek = new Snake(450,300);
	//private LinkedList<Snake> snakePart = new LinkedList<>();
	private LinkedList<Pellet> food = new LinkedList<>();
	//private Pellet ball = new Pellet((int)(Math.random()*800), (int)(Math.random()*500));
	private BadPellet bad = new BadPellet((int)(Math.random()*800), (int)(Math.random()*500));
	
	private boolean generatePellet = false;
	private boolean gameOver = false;
	private int scNum = 0;
	private JLabel gameEnd = new JLabel("");
	JLabel score = new JLabel(scNum + "");

	public Main() 
	{
		this.setTitle("Snake: The Game");
		this.setBounds(0,0,900,600);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(900,600));
		this.pack();
		this.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(new Dimension (900,600));
		
		JLabel inst = new JLabel("USE THE WASD KEYS TO MOVE THE SNAKE!");
		inst.setFont(new Font("SERIF", Font.BOLD, 15));
		inst.setForeground(Color.WHITE);
		inst.setSize(400,40);
		panel2.add(inst);
		
		JLabel inst2 = new JLabel("DONT EAT THE WICKED PURPLE APPLE!");
		inst2.setFont(new Font("SERIF", Font.BOLD, 15));
		inst2.setForeground(Color.WHITE);
		inst2.setSize(400,40);
		panel2.add(inst2);

		this.gameEnd.setBounds(new Rectangle(250,50,900,50));
		this.gameEnd.setLocation(300, 250);
		this.gameEnd.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		this.gameEnd.setForeground(Color.WHITE);
		this.add(this.gameEnd);
		
		score.setBounds(new Rectangle(50,30,100,30));
		score.setFont(new Font("Times New Roman", Font.BOLD, 30));
		score.setForeground(Color.YELLOW);
		add(score);
		
		Pellet initial = new Pellet((int)(Math.random()*800), (int)(Math.random()*500));
		food.add(initial);
		
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
				inst.setText("");
				inst2.setText("");
			}
			public void keyTyped(KeyEvent e) 
			{
			}
			public void keyReleased(KeyEvent e) 
			{
			}
		});
		this.add(snek);
		for(Pellet food: food)
			this.add(food);
		this.add(bad);
		
		panel2.setBackground(new Color(0,0,77,255));
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
	
	private int valueGenerator()
	{
		return (int)(Math.random()*5);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		snek.update();
		for(Pellet ball : food)
		{
			ball.update();
		}
		bad.update();
		if(snek.getX() >= 850)
			snek.setLocation(10, snek.getY());
		if(snek.getX() <= 1)
			snek.setLocation(899, snek.getY());
		if(snek.getY() >= 550)
			snek.setLocation(snek.getX(), 10);
		if(snek.getY() <= 1)
			snek.setLocation(snek.getX(), 599);
		
		
		if(this.valueGenerator() == 3)
			generatePellet = true;
		else
			generatePellet = false;
		
		if(generatePellet)
		{
			Pellet p = new Pellet((int)(Math.random()*800),(int)(Math.random()*500));
			food.add(p);
		}
		for(Pellet p:food) 
		{
			if (snek.returnBorder().intersects(p.returnBorder()))
			{
				p.setLocation((int)(Math.random()*800), (int)(Math.random()*500));
				scNum++;
				score.setText((scNum) + "");
				bad.setLocation((int)(Math.random()*800), (int)(Math.random()*500));
				while(bad.returnBorder().intersects(p.returnBorder()))
					bad.setLocation((int)(Math.random()*800), (int)(Math.random()*500));
				if (scNum >= 10)
				{
					snek.setDx(0);
					snek.setDy(0);
					for(Pellet ball: food)
						remove(ball);
					remove(snek);
					gameEnd.setText("YOU WON!!!");
					System.out.print("\uD83C\uDF88");//its supposed to print a balloon emoji in the console but it didnt work on my computer, I hope it works on yours :)
					System.out.print("\uD83E\uDD51"); //its supposed to print avocado emoji in the console but it didnt work on my computer, I hope it works on yours :)
				}
			}
		}
		
		if(snek.returnBorder().intersects(bad.returnBorder()))
			gameOver = true;
		
		if(gameOver)
		{
			snek.setDx(0);
			snek.setDy(0);
			for(Pellet ball: food)
				remove(ball);
			remove(snek);
			gameEnd.setText("GAME OVER");
			return;
		}
		repaint();
	}
}
