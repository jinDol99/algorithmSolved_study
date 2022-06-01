package BrickBreaker;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class StartGame extends JFrame {
	private JButton button = new JButton("Start");
	public StartGame() {
		JPanel panel = new JPanel();
		JFrame jF = new JFrame();
		panel.add(button);
		add(BorderLayout.SOUTH,panel);
		panel.setBackground(Color.black);
		button.addActionListener((e)->{
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
		setTitle("start");
		setSize(1000,700);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		 new StartGame();
	}
}