package BrickBreaker;
import java.awt.Color;
import javax.swing.JFrame;
public class Main {
	// s
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
}