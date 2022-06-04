package BrickBreaker;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
class Gameplay extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score = 0;
	private int totalBricks = 10;
	private Timer timer;
	private int delay = 8;
	private int playerX = 500;
	private int ballposX = 500;
	private int ballposY = 600;
	private int ballXdir = -1;
	private int ballYdir = 2;
	private MapGenerator map;
	private int pl = 100;
	private boolean direction = false;
	public static int stage = 1;
	private static int temp = stage;
	private static int speed = 4;
	private boolean _chkLose = true;
	JButton nextLevel = new JButton("next Level");
	public Gameplay() { // 추가 설정을 위한 코드
		map = new MapGenerator(2, 5);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g) { // 각종 컴포넌트의 설정 및 그리기 코드
		g.setColor(Color.black); // 색깔 별로 필요한 컴포넌트들 설정
		g.fillRect(1, 1, 1000, 700);

		map.draw((Graphics2D) g);

		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 700);
		g.fillRect(0, 0, 1000, 3);
		g.fillRect(983, 0, 3, 700);
			
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString("Stage : "+stage, 450,30);
		g.drawString("Score : "+score, 850,30);
		
		g.setColor(Color.yellow);
		g.fillRect(playerX, 650, pl, 8); 

		g.setColor(Color.red);
		g.fillOval(ballposX, ballposY, 20, 20);

		if(totalBricks <= 0) { // 승리시
			LevelUp test = new LevelUp();
			try {
				test.LevelUp();
				Thread.sleep(0);
			} catch(Exception Object) {
			}
			if (stage == 1)
				win3(g);
			else if (stage == 2)
				win2();
			else
				win3(g);
		}
		if(ballposY > 670) { // 패배시
			Fail test = new Fail();
			try {
				test.Fail();
				Thread.sleep(3000);
			} catch(Exception e) {
			}
			    lose(g);
		    }
		g.dispose();
	}
	public void win() { // 첫스테이지 클리어시
		ballposX = 500;
		ballposY = 600;
		ballXdir = -1;
		ballYdir = 2;
		playerX = 500;
		score = 0;
		totalBricks = 24;
		stage = 2;
		temp = stage;
		speed = 6;
		pl = 90;
		map = new MapGenerator(4, 6); 
		play = false;
		repaint();
	}
	public void win2() { // 두번째 스테이지 클리어시
		ballposX = 500;
		ballposY = 600;
		ballXdir = -1;
		ballYdir = 2;
		playerX = 500;
		score = 0;
		totalBricks = 48;
		stage = 3;
		temp = stage;
		speed = 8;
		pl = 80;
		map = new MapGenerator(8, 6); 
		play = false;
		repaint();
	}
	public void win3(Graphics g) { // 마지막 스테이지 클리어시
		play = false;
		g.setColor(Color.black);
		g.fillRect(1, 1, 1000, 700);
		g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD, 50));
        g.drawString("Congraturation", 435,300);
        g.setFont(new Font("serif",Font.BOLD, 70));
        g.drawString("Game Clear!!", 250,400);
        g.setColor(Color.red);
		g.fillOval(700, -150, 500, 500);
		g.setColor(Color.yellow);
		g.fillRect(-140, 550, 500, 200);
		setVisible(true);
	}
	public void lose(Graphics g) { // 패배시
		_chkLose = false;
		play = false;
        ballXdir = 0;
        ballYdir = 0;
		g.setColor(Color.black);
		g.fillRect(1, 1, 1000, 700);
		g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD, 50));
        g.drawString("Retry?", 435,300);
        g.drawString("Press Enter to Restart", 250,375);
        g.setColor(Color.red);
		g.fillOval(700, -150, 500, 500);
		g.setColor(Color.yellow);
		g.fillRect(-140, 550, 500, 200);
		stage = 0;
	}
	public void keyPressed(KeyEvent e) { // 각종 키보드 클릭시 처리 코드
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 오른쪽 방향키 클릭 
			if(playerX >= 880) {
				playerX = 880;
			}
			else {
				moveRight();
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // 왼쪽 방향키 클릭
			if(playerX < 10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { // 엔터 클릭
			if(_chkLose) return;
			restart();
        }		
	}
	public void restart() { // 재시작시
		if(!play & temp == 1) { // 첫번째 스테이지 재시작
			ballposX = 500;
			ballposY = 600;
			ballXdir = -1;
			ballYdir = 2;
			playerX = 500;
			score = 0;
			stage = temp;
			totalBricks = 10;
			map = new MapGenerator(2, 5);
			repaint();
			setVisible(true);
		} else if (!play & temp == 2) // 두번째 스테이지 재시작
			win();
		else if (!play & temp == 3) // 세번째 스테이지 재시작
			win2();
	}
	public void keyReleased(KeyEvent e) {} // 추상 메소드 구현
	public void keyTyped(KeyEvent e) {} // 추상 메소드 구현
	public void moveRight() { // 스틱 오른쪽으로 이동
			play = true;
			playerX+=20;
			direction = false;
	}
	public void moveLeft() { // 스틱 왼쪽으로 이동
			play = true;
			playerX-=20;
			direction = true;
	}
	public void actionPerformed(ActionEvent e) { // 각종 컴포넌트의 이동 및 충돌 시 처리
		timer.start();
		if(play) {
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 650, pl, 8))) {
				ballYdir = -ballYdir;
				if (direction == true)
					ballXdir = -speed;
				else if (direction == false)
					ballXdir = speed;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 650, pl, 8))) {
				ballYdir = -ballYdir;
				ballXdir = ballXdir + 3;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 650, pl, 8))) { 
				ballYdir = -ballYdir;
			}	
			A: for(int i = 0; i<map.map.length; i++) {
				for(int j =0; j<map.map[0].length; j++) {				
					if(map.map[i][j] > 0) {
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						if(ballRect.intersects(brickRect))
						{
							Music test = new Music();
							try {
								test.Music();
								Thread.sleep(0);
							} catch(Exception Object) {
							}
							map.setBrickValue(0, i, j);
							score+=5;
							totalBricks--;
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
							}
							else {
								ballYdir = -ballYdir;
							}
							break A;
						}
					}
				}
			}
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 970) {
				ballXdir = -ballXdir;
			}
			repaint();	
		}
	}
}
/*import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
public class Gameplay extends JPanel implements KeyListener, ActionListener
{
	private boolean play = false; // 게임 시작 전
	private int score = 0; // 점수
	private int totalBricks = 48; // 공의 전체 갯수(남아있는 갯수)
	private Timer timer; // 타이머
	private int delay=8; // 공 속도(숫자가 작을수록 딜레이가 덜 걸려 빨라짐)
	private int playerX = 310; // 스틱의 X 좌표
	private int ballposX = 120; // 공의 X 좌표
	private int ballposY = 350; // 공의 Y 좌표
	private int ballXdir = -1; // 공의 X 방향 이동의 속도(숫자가 커질수록 커짐)
	private int ballYdir = -2; // 공의 Y 방향 이동의 속도(숫자가 커질수록 커짐)
	private MapGenerator map; 
	public Gameplay()
	{
		map = new MapGenerator(4, 12); // 브릭의 갯수(세로 갯수, 가로 갯수)
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g) // 각종 컴포넌트의 설정
	{
		// background
		g.setColor(Color.black); // 배경의 색깔
		g.fillRect(1, 1, 692, 592); // 배경의 색깔 범위(서쪽,북쪽, 동쪽,남쪽 좌표)
		
		// drawing map
		map.draw((Graphics2D) g);
		
		// borders
		g.setColor(Color.yellow); // 경계의 색깔
		g.fillRect(0, 0, 3, 592); // 왼쪽 경계
		g.fillRect(0, 0, 692, 3); // 위쪽 경계
		g.fillRect(683, 0, 3, 592); // 오른쪽 경계
		
		// the scores 		
		g.setColor(Color.white); // 점수 색깔
		g.setFont(new Font("serif",Font.BOLD, 25)); // 점수 폰트 및 크기
		g.drawString(""+score, 590,30); // (기본 점수, 점수 X 좌표, Y 좌표)
		
		// the paddle
		g.setColor(Color.yellow); // 스틱 색깔
		g.fillRect(playerX, 550, 100, 8); 
		// 스틱 좌표(X 좌표, Y 좌표, 길이, 두께)
		
		// the ball
		g.setColor(Color.red); // 공의 색깔
		g.fillOval(ballposX, ballposY, 20, 20); 
		// (공의 X 좌표, 공의 Y 좌표, 공의 좌우 길이, 공의 상하 길이)
	
		// when you won the game
		if(totalBricks <= 0) // 남은 브릭의 갯수가 0개 이하일때(승리시)
		{
			 play = false;
             ballXdir = 0; // 공의 X 이동을 0으로 (정지)
     		 ballYdir = 0; // 공의 Y 이동을 0으로 (정지)
             g.setColor(Color.RED); // 승리시 나오는 문구 색깔
             g.setFont(new Font("serif",Font.BOLD, 30));
             // 승리시 나오는 문구 포트와 크기
             g.drawString("You Won", 260,300);
             // 승리시 나오는 문구 및 X 좌표, Y 좌표
             g.setColor(Color.RED);
             // 승리시 나오는 문구 색깔
             g.setFont(new Font("serif",Font.BOLD, 20));
             // 승리시 나오는 문구 포트와 크기
             g.drawString("Press (Enter) to Restart", 230,350);
             // 승리시 나오는 문구 및 X 좌표, Y 좌표
		}
		
		// when you lose the game
		if(ballposY > 570) // 공이 바닥 아래로 내려갔을 때(패배시)
        {
			 play = false;
             ballXdir = 0; // 공의 X 이동을 0으로 (정지)
     		 ballYdir = 0; // 공의 Y 이동을 0으로 (정지)
             g.setColor(Color.RED); // 패배시 나오는 문구 색깔
             g.setFont(new Font("serif",Font.BOLD, 30));
             // 패배시 나오는 문구 포트와 크기
             g.drawString("Game Over, Scores: "+score, 190,300);
             // 패배시 나오는 문구(+점수) 및 X 좌표, Y 좌표
             g.setColor(Color.RED);
             // 패배시 나오는 문구 색깔
             g.setFont(new Font("serif",Font.BOLD, 20));  
             // 패배시 나오는 문구 포트와 크기
             g.drawString("Press (Enter) to Restart", 230,350);
             // 패배시 나오는 문구 및 X 좌표, Y 좌표
        }
		g.dispose(); // 현재의 Frame만 종료
	}
	public void keyPressed(KeyEvent e) // 특정 키를 눌렀을때
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) // 오른쪽 방향키 입력
		{        
			if(playerX >= 600) // 스틱이 오른쪽 벽에 닿아있으면
			{
				playerX = 600; // 그 자리 그대로
			}
			else // 스틱이 오른쪽 벽에 닿아있지 않다면
			{
				moveRight(); // 스틱의 오른쪽 이동
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) // 왼쪽 방향키 입력
		{          
			if(playerX < 10) // 스틱이 왼쪽 벽에 닿아있으면
			{
				playerX = 10; // 그 자리 그대로
			}
			else // 스틱이 왼쪽 벽에 닿아있지 않다면
			{
				moveLeft(); // 스틱의 왼쪽 이동
			}
        }		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) // Enter를 눌렀을 때
		{          
			if(!play) // 게임이 플레이 되지 않고 있는 상황(죽었을 때)
			{
				play = true;
				ballposX = 120; // 공의 X 좌표 기본 위치로 재설정
				ballposY = 350; // 공의 Y 좌표 기본 위치로 재설정
				ballXdir = -1; // 공의 X 좌표 이동
				ballYdir = -2; // 공의 Y 좌표 이동
				playerX = 310; // 스틱의 X 좌표 위치로 재설정
				score = 0; // 점수 0으로 재설정
				totalBricks = 21; // 전체 브릭은 21개로
				map = new MapGenerator(3, 7); 
				// 브릭 세로로 3개, 가로로 7개 해서 총 21개
				repaint(); // 재시작
			}
        }		
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void moveRight() // 오른쪽 방향키 눌렀을 때의 메소드
	{
		play = true; // 플레이중이라면
		playerX+=20; // 스틱을 오른쪽으로 이동
	}
	public void moveLeft() // 왼쪽 방향키 눌렀을 때의 메솓,
	{
		play = true; // 플레이중이라면
		playerX-=20; // 스틱을 왼쪽으로 이동
	}
	public void actionPerformed(ActionEvent e)  // 게임이 시작되었을 때
	{
		timer.start(); // 타이머 스타트
		if(play) // 플레이중이라면
		{			
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 30, 8))) 
			{
				// 내부 영역이 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정합니다.(intersects)
				ballYdir = -ballYdir; // 공의 위아래 움직임 반전
				ballXdir = -2; // 공의 좌우 움직임 속도를 낮춤
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 550, 30, 8)))
			{
				// 내부 영역이 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정합니다.(intersects)
				ballYdir = -ballYdir; // 공의 위아래 움직임 반전
				ballXdir = ballXdir + 1; // 공의 좌우 움직임 속도를 올림
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 550, 40, 8)))
			{
				// 내부 영역이 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정합니다.(intersects)
				ballYdir = -ballYdir; // 공의 위아래 움직임 반전
			}
			
			// check map collision with the ball		
			A: for(int i = 0; i<map.map.length; i++)
			{
				for(int j =0; j<map.map[0].length; j++)
				{				
					if(map.map[i][j] > 0)
					{
						//scores++;
						int brickX = j * map.brickWidth + 80; // 각각의 브릭이 공과 부딫치게 되는 실제 x 좌표
						int brickY = i * map.brickHeight + 50; // 각각의 브릭이 공과 부딫치게 되는 실제 y 좌표
						int brickWidth = map.brickWidth;  // 브릭의 가로 길이
						int brickHeight = map.brickHeight; // 브릭의 세로 길이
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight); // 브릭(브릭의 X 좌표, 브릭의 Y 좌표, 가로 길이, 세로 길이)					
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20); // 공 반사..?
						Rectangle brickRect = rect; // 브릭 완성
						if(ballRect.intersects(brickRect)) // 브릭과 공이 부딫치게 된다면
						{					
							map.setBrickValue(0, i, j); // 브릭의 삭제..?
							score+=5; // 점수 5점 증가
							totalBricks--; // 전체 브릭 수 감소
							
							// when ball hit right or left of brick
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) // 공이 브릭의 좌우에 부딫쳤을 경우
							{
								ballXdir = -ballXdir; // 공의 좌우 방향 반전
							}
							// when ball hits top or bottom of brick
							else // 공이 브릭의 상하에 부딫쳤을 경우
							{
								ballYdir = -ballYdir; // 공의 상하 방향 반전
							}
							break A; // 브릭 삭제
						}
					}
				}
			}
			ballposX += ballXdir; // 공의 X 좌표에 좌우 딜레이를 더함
			ballposY += ballYdir; // 공의 Y 좌표에 상하 딜레이를 더함
			if(ballposX < 0) // 만약 공이 왼쪽 벽에 부딫친다면
			{
				ballXdir = -ballXdir; // 공의 좌우 방향 반전
			}
			if(ballposY < 0) // 만약 공이 위쪽 벽에 부딫친다면
			{
				ballYdir = -ballYdir; // 공의 상하 방향 반전
			}
			if(ballposX > 670) // 만약 공이 오른쪽 벽에 부딫친다면
			{
				ballXdir = -ballXdir;  // 공의 좌우 방향 반전
			}
			repaint();
		}
	}
}
*/