package BrickBreaker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class RetryGame extends JFrame {
	private JButton but1 = new JButton("Restart");
	private JButton but2 = new JButton("End");
	public RetryGame() {
		JPanel panel = new JPanel();
		JFrame jF = new JFrame();
		panel.add(but1);
		panel.add(but2);
		add(BorderLayout.SOUTH,panel);
		panel.setBackground(Color.black);
		but1.addActionListener((e)->{
			JFrame obj=new JFrame();
			Gameplay gamePlay = new Gameplay();
			obj.setBounds(0, 0, 1000, 700);
			obj.setTitle("Breakout Ball");
			obj.setResizable(true);
			obj.setVisible(true);
			obj.setLocationRelativeTo(null);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(gamePlay);
	        obj.setVisible(true);
			setVisible(false);
		});
		but2.addActionListener((e)->{
			System.exit(0);
		});
		setTitle("Restart");
		setSize(1000,700);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD, 50));
        g.drawString("Retry?", 435,300);
        g.drawString("Press Restart to Restart", 275,375);
        g.setColor(Color.red);
		g.fillOval(700, -150, 500, 500);
		g.setColor(Color.yellow);
		g.fillRect(-140, 550, 500, 200);
	}
	public static void main(String[] args) {
		 new RetryGame();
	}
}