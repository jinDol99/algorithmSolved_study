package BrickBreaker;
import java.awt.Color;
import javax.swing.JFrame;
public class Main {
	// s
	public static void main(String[] args) {
		JFrame obj=new JFrame(); // 게임창 생성
		Gameplay gamePlay = new Gameplay(); // 게임 플레이 객체 생성
		obj.setBounds(10, 10, 700, 600); // 나오는 창의 경계(왼쪽 끝 좌표, 위쪽 끝 좌표, 오른쪽 끝 좌표, 아래쪽 끝 좌표)
		obj.setTitle("Breakout Ball"); // 게임 타이틀
		obj.setResizable(false); // 게임창의 크기 조절 불가능
		obj.setVisible(true); // 창 보임
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫았을 때 메모리에서도 삭제
		obj.add(gamePlay);
                obj.setVisible(true);
	}
}