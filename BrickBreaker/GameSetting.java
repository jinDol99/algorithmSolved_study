package BrickBreaker;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameSetting {
	public GameSetting() {
		JFrame obj=new JFrame();
		Gameplay gamePlay = new Gameplay();
		obj.setBounds(0, 0, 1000, 700);
		obj.setTitle("Break Brick Game");
		obj.setResizable(true);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
		obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		obj.add(gamePlay);
	}
	public static void main(String[] args) {
		new GameSetting();
	}
}