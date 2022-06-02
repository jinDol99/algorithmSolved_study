package BrickBreaker;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Gameplay extends JPanel implements KeyListener, ActionListener
{ //ㅁㅁ
	public boolean play = false; // 게임 시작 전
	private int score = 0; // 점수
	private int totalBricks = 10; // 블럭의 전체 갯수(남아있는 갯수)
	private Timer timer; // 타이머
	private int delay = 8; // 공 속도(숫자가 작을수록 딜레이가 덜 걸려 빨라짐)
	private int playerX = 500; // 스틱의 X 좌표
	private int ballposX = 500; // 공의 X 좌표
	private int ballposY = 600; // 공의 Y 좌표
	private int ballXdir = -1; // 공의 X 방향 이동의 속도(숫자가 커질수록 커짐)
	private int ballYdir = 2; // 공의 Y 방향 이동의 속도(숫자가 커질수록 커짐)
	private MapGene map;
	private int pl = 100;
	private boolean direction = false;
	public static int stage = 1;
	private boolean _chkLose = true;
	public Gameplay()
	{
		map = new MapGene(2, 5); // 브릭의 갯수(세로 갯수, 가로 갯수)
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
		g.fillRect(1, 1, 1000, 700); // 배경의 색깔 범위(서쪽,북쪽, 동쪽,남쪽 좌표)
		
		// drawing map
		map.draw((Graphics2D) g);
		
		// borders
		g.setColor(Color.yellow); // 경계의 색깔
		g.fillRect(0, 0, 3, 700); // 왼쪽 경계
		g.fillRect(0, 0, 1000, 3); // 위쪽 경계
		g.fillRect(983, 0, 3, 700); // 오른쪽 경계
		
		// the scores 		
		g.setColor(Color.white); // 점수 색깔
		g.setFont(new Font("serif",Font.BOLD, 25)); // 점수 폰트 및 크기
		g.drawString("Stage : "+stage, 450,30);
		g.drawString("Score : "+score, 850,30); // (기본 점수, 점수 X 좌표, Y 좌표)
		// the paddle
		g.setColor(Color.yellow); // 스틱 색깔
		g.fillRect(playerX, 650, pl, 8); 
		// 스틱 좌표(X 좌표, Y 좌표, 길이, 두께)
		
		// the ball
		g.setColor(Color.red); // 공의 색깔
		g.fillOval(ballposX, ballposY, 20, 20);
		// (공의 X 좌표, 공의 Y 좌표, 공의 좌우 길이, 공의 상하 길이)
		// when you won the game
		if(totalBricks <= 0) // 남은 브릭의 갯수가 0개 이하일때(승리시)
		{
			if (stage == 1)
				win();
			else if (stage == 2)
				win2();
			else
				win3(g);
		}
		// when you lose the game
		if(ballposY > 670) // 공이 바닥 아래로 내려갔을 때(패배시)
		    {
				//repaint();
			    lose(g);
		    }
		g.dispose();
	}
	
	public void win() {
		ballposX = 500; // 공의 X 좌표 기본 위치로 재설정
		ballposY = 600; // 공의 Y 좌표 기본 위치로 재설정
		ballXdir = -1; // 공의 X 좌표 이동
		ballYdir = 2; // 공의 Y 좌표 이동
		playerX = 500; // 스틱의 X 좌표 위치로 재설정
		score = 0; // 점수 0으로 재설정
		totalBricks = 24; // 전체 브릭은 21개로
		stage++;
		map = new MapGene(4, 6); 
		// 브릭 세로로 3개, 가로로 7개 해서 총 21개
		play = false;
		repaint(); // 재시작
	}
	public void win2() {
		ballposX = 500; // 공의 X 좌표 기본 위치로 재설정
		ballposY = 600; // 공의 Y 좌표 기본 위치로 재설정
		ballXdir = -1; // 공의 X 좌표 이동
		ballYdir = 2; // 공의 Y 좌표 이동
		playerX = 500; // 스틱의 X 좌표 위치로 재설정
		score = 0; // 점수 0으로 재설정
		totalBricks = 48; // 전체 브릭은 21개로
		stage++;
		map = new MapGene(8, 6); 
		// 브릭 세로로 3개, 가로로 7개 해서 총 21개
		play = false;
		repaint(); // 재시작
	}
	public void win3(Graphics g) {
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
	public void lose(Graphics g) {
		
		_chkLose = false; // 시작 시 엔터 키 누르는거 방지 -> 유효성체크 필
		play = false;
        ballXdir = 0; // 공의 X 이동을 0으로 (정지)
        ballYdir = 0; // 공의 Y 이동을 0으로 (정지)
        //setVisible(false);
        // new RetryGame();
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
		stage = 1; // 스테이지 초기화
		//setVisible(true);
		
	}
	public void keyPressed(KeyEvent e) // 특정 키를 눌렀을때
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) // 오른쪽 방향키 입력
		{        
			System.out.println("오른쪽");
			if(playerX >= 880) // 스틱이 오른쪽 벽에 닿아있으면
			{
				playerX = 880; // 그 자리 그대로
			}
			else // 스틱이 오른쪽 벽에 닿아있지 않다면
			{
				moveRight(); // 스틱의 오른쪽 이동
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) // 왼쪽 방향키 입력
		{
			System.out.println("왼쪽");
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
			if(_chkLose) return;
			
			System.out.println("엔터");
			// 유효성 추가 -> 게임 시작시 엔터 누르면 바로 다음 스테이지 진행
			restart();
        }		
	}
	public void restart() {
		if(!play) // 게임이 플레이 되지 않고 있는 상황(죽었을 때)
		{
			//setVisible(false);
			ballposX = 500; // 공의 X 좌표 기본 위치로 재설정
			ballposY = 600; // 공의 Y 좌표 기본 위치로 재설정
			ballXdir = -1; // 공의 X 좌표 이동
			ballYdir = 2; // 공의 Y 좌표 이동
			playerX = 500; // 스틱의 X 좌표 위치로 재설정
			score = 0; // 점수 0으로 재설정
			totalBricks = 10; // 전체 브릭은 24개로
			map = new MapGene(2, 5);
			repaint();
			setVisible(true);
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void moveRight() // 오른쪽 방향키 눌렀을 때의 메소드
	{
		 // 스틱을 오른쪽으로 이동
			play = true; // 스타트
			playerX+=20;
			direction = false;
	}
	public void moveLeft() // 왼쪽 방향키 눌렀을 때의 메솓,
	{
			play = true; // 스타트
			playerX-=20;
			direction = true;
	}
	
	public void actionPerformed(ActionEvent e)  // 게임이 시작되었을 때
	{
		timer.start(); // 타이머 스타트
		if(play) // 플레이중이라면
		{
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 650, pl, 8))) 
			{
				// 내부 영역이 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정합니다.(intersects)
				ballYdir = -ballYdir; // 공의 위아래 움직임 반전
				if (direction == true)
					ballXdir = -5; // 공의 좌우 움직임 속도를 낮춤
				else if (direction == false)
					ballXdir = 5;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 650, pl, 8)))
			{
				// 내부 영역이 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정합니다.(intersects)
				ballYdir = -ballYdir; // 공의 위아래 움직임 반전
				ballXdir = ballXdir + 3; // 공의 좌우 움직임 속도를 올림
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 650, pl, 8)))
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
			if(ballposX > 970) // 만약 공이 오른쪽 벽에 부딫친다면
			{
				ballXdir = -ballXdir;  // 공의 좌우 방향 반전
			}
			repaint();	
		}
	}
}

class MapGene {
	public int map[][]; // 브릭 생성을 위한 배열
	public int brickWidth; // 브릭의 가로
	public int brickHeight; // 브릭의 세로
	public MapGene (int row, int col) // 브릭 생성
	{
		map = new int[row][col]; // 브릭의 가로와 세로로 배열을 만듦
		for(int i = 0; i<map.length; i++) // 브릭의 세로 갯수까지 반복
		{
			for(int j =0; j<map[0].length; j++) // 브릭의 가로 갯수까지 반복
			{
				map[i][j] = 1; // 나중에 있을 브릭의 생성을 위한 모든 값에 1 넣기
			}			
		}
		brickWidth = 800/col; // 브릭의 가로는 540/col이 된다.
		brickHeight = 150/row; // 브릭의 세로는 150/row가 된다.
	}	
	public void draw(Graphics2D g) // 브릭 그리기
	{
		for(int i = 0; i<map.length; i++) // 브릭의 세로 갯수까지 반복
		{
			for(int j =0; j<map[0].length; j++) // 브릭의 가로 갯수까지 반복
			{
				if(map[i][j] > 0) // 어차피 모든 값에 1을 넣었기에 실질적으로 처음부터 끝까지 전부 실행
				{
					g.setColor(Color.yellow); // 브릭의 색깔
					g.fillRoundRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight, 20, 20); 
					// 브릭의 범위(X 좌표, Y 좌표, 가로 길이, 세로 길이)

					// this is just to show separate brick, game can still run without it
					g.setStroke(new BasicStroke(3)); // 브릭과 브릭 사이를 구분하는 선의 두께
					g.setColor(Color.black); // 브릭과 브릭 사이를 구분하는 선의 색깔
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);	
					// 브릭을 구분하는 선의 범위(X 좌표, Y 좌표, 가로 길이, 세로 길이)
				}
			}
		}
	}
	public void setBrickValue(int value, int row, int col) // 생성자
	{
		map[row][col] = value;
	}
}
public class Main {
	public Main() {
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
		new Main();
	}
}
/*import java.awt.Color;
import javax.swing.JFrame;
public class Main {
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
}*/