package BrickBreaker;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameSetting {
	public GameSetting() {
		JFrame obj=new JFrame(); // 게임창 생성
		Gameplay gamePlay = new Gameplay();
		obj.setBounds(0, 0, 1000, 700); // 나오는 창의 경계(왼쪽 끝 좌표, 위쪽 끝 좌표, 오른쪽 끝 좌표, 아래쪽 끝 좌표)
		obj.setTitle("Break Brick Game"); // 게임 타이틀
		obj.setResizable(true); // 게임창의 크기 조절 불가능
		obj.setVisible(true); // 창 보임
		obj.setLocationRelativeTo(null);
		obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창을 닫았을 때 메모리에서도 삭제
		obj.add(gamePlay);
		
	}
	public static void main(String[] args) {
		new GameSetting();
	}
}