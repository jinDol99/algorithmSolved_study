package BrickBreaker;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameSetting {
	public GameSetting() {
		JFrame obj=new JFrame(); // ����â ����
		Gameplay gamePlay = new Gameplay();
		obj.setBounds(0, 0, 1000, 700); // ������ â�� ���(���� �� ��ǥ, ���� �� ��ǥ, ������ �� ��ǥ, �Ʒ��� �� ��ǥ)
		obj.setTitle("Break Brick Game"); // ���� Ÿ��Ʋ
		obj.setResizable(true); // ����â�� ũ�� ���� �Ұ���
		obj.setVisible(true); // â ����
		obj.setLocationRelativeTo(null);
		obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // â�� �ݾ��� �� �޸𸮿����� ����
		obj.add(gamePlay);
		
	}
	public static void main(String[] args) {
		new GameSetting();
	}
}