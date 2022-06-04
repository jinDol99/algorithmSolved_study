package BrickBreaker;
/*import java.awt.BorderLayout;
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
	public RetryGame() { // ¤±¤±
		JPanel panel = new JPanel();
		JFrame jF = new JFrame();
		but1.setBounds(400, 500, 150, 70);
		setLayout(null);
		but1.setVisible(false);
		add(but1);
		repaint();
		but1.setVisible(true);
		but1.addActionListener((e)->{
			new Main();
			setVisible(false);
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
		g.setColor(Color.black);
		g.fillRect(1, 1, 1000, 700);
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
}*/