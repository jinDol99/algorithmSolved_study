package BrickBreaker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class StartGame extends JFrame {
	private JButton button = new JButton("Start");
	private Image background=new ImageIcon(Main.class.getResource("unknown.png")).getImage();
	public StartGame() {
		JPanel panel = new JPanel();
		JFrame jF = new JFrame();
		button.setVisible(false);
		panel.add(button);
		add(BorderLayout.SOUTH,panel);
		setLayout(null);	
		panel.setBackground(Color.black);
		button.setBounds(400, 500, 150, 70);
		add(button);
		repaint();
		button.setVisible(true);
		setVisible(true);
		button.addActionListener((e)->{
			JFrame obj = new JFrame();
			Gameplay gamePlay = new Gameplay();
			obj.setBounds(0, 0, 1000, 700);
			obj.setTitle("Breakout Ball");
			obj.setResizable(true);
			obj.setVisible(true);
			obj.setLocationRelativeTo(null);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(gamePlay);
			setVisible(false);
		}); 
		setTitle("start");
		setSize(1000,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void homeframe() {
		setTitle("1"); 
		setSize(1000,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	public static void main(String[] args) {
		 new StartGame(); 
	}
}