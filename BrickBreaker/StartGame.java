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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void homeframe() {
		setTitle("1");//Ÿ��Ʋ
		setSize(1000,700);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setVisible(true);//â�� ���̰�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
	}
	public static void main(String[] args) {
		 new StartGame();
	}
}