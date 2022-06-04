package BrickBreaker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JFrame {
	private JButton button = new JButton("Start");
	private Image background=new ImageIcon(Main.class.getResource("unknown.png")).getImage();
	public Main() {
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
			new Main();
			setVisible(false);
		}); 
		setTitle("start");
		setSize(1000,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	public static void main(String[] args) {
		 new Main(); 
	}
}
/*import java.awt.Color;
import javax.swing.JFrame;
public class Main {
	public static void main(String[] args) {
		JFrame obj=new JFrame(); // ����â ����
		Gameplay gamePlay = new Gameplay(); // ���� �÷��� ��ü ����
		obj.setBounds(10, 10, 700, 600); // ������ â�� ���(���� �� ��ǥ, ���� �� ��ǥ, ������ �� ��ǥ, �Ʒ��� �� ��ǥ)
		obj.setTitle("Breakout Ball"); // ���� Ÿ��Ʋ
		obj.setResizable(false); // ����â�� ũ�� ���� �Ұ���
		obj.setVisible(true); // â ����
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� �ݾ��� �� �޸𸮿����� ����
		obj.add(gamePlay);
                obj.setVisible(true);
	}
}*/