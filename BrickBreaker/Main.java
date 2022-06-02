package BrickBreaker;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Gameplay extends JPanel implements KeyListener, ActionListener
{ //����
	public boolean play = false; // ���� ���� ��
	private int score = 0; // ����
	private int totalBricks = 10; // ���� ��ü ����(�����ִ� ����)
	private Timer timer; // Ÿ�̸�
	private int delay = 8; // �� �ӵ�(���ڰ� �������� �����̰� �� �ɷ� ������)
	private int playerX = 500; // ��ƽ�� X ��ǥ
	private int ballposX = 500; // ���� X ��ǥ
	private int ballposY = 600; // ���� Y ��ǥ
	private int ballXdir = -1; // ���� X ���� �̵��� �ӵ�(���ڰ� Ŀ������ Ŀ��)
	private int ballYdir = 2; // ���� Y ���� �̵��� �ӵ�(���ڰ� Ŀ������ Ŀ��)
	private MapGene map;
	private int pl = 100;
	private boolean direction = false;
	public static int stage = 1;
	private boolean _chkLose = true;
	public Gameplay()
	{
		map = new MapGene(2, 5); // �긯�� ����(���� ����, ���� ����)
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g) // ���� ������Ʈ�� ����
	{
		// background
		g.setColor(Color.black); // ����� ����
		g.fillRect(1, 1, 1000, 700); // ����� ���� ����(����,����, ����,���� ��ǥ)
		
		// drawing map
		map.draw((Graphics2D) g);
		
		// borders
		g.setColor(Color.yellow); // ����� ����
		g.fillRect(0, 0, 3, 700); // ���� ���
		g.fillRect(0, 0, 1000, 3); // ���� ���
		g.fillRect(983, 0, 3, 700); // ������ ���
		
		// the scores 		
		g.setColor(Color.white); // ���� ����
		g.setFont(new Font("serif",Font.BOLD, 25)); // ���� ��Ʈ �� ũ��
		g.drawString("Stage : "+stage, 450,30);
		g.drawString("Score : "+score, 850,30); // (�⺻ ����, ���� X ��ǥ, Y ��ǥ)
		// the paddle
		g.setColor(Color.yellow); // ��ƽ ����
		g.fillRect(playerX, 650, pl, 8); 
		// ��ƽ ��ǥ(X ��ǥ, Y ��ǥ, ����, �β�)
		
		// the ball
		g.setColor(Color.red); // ���� ����
		g.fillOval(ballposX, ballposY, 20, 20);
		// (���� X ��ǥ, ���� Y ��ǥ, ���� �¿� ����, ���� ���� ����)
		// when you won the game
		if(totalBricks <= 0) // ���� �긯�� ������ 0�� �����϶�(�¸���)
		{
			if (stage == 1)
				win();
			else if (stage == 2)
				win2();
			else
				win3(g);
		}
		// when you lose the game
		if(ballposY > 670) // ���� �ٴ� �Ʒ��� �������� ��(�й��)
		    {
				//repaint();
			    lose(g);
		    }
		g.dispose();
	}
	
	public void win() {
		ballposX = 500; // ���� X ��ǥ �⺻ ��ġ�� �缳��
		ballposY = 600; // ���� Y ��ǥ �⺻ ��ġ�� �缳��
		ballXdir = -1; // ���� X ��ǥ �̵�
		ballYdir = 2; // ���� Y ��ǥ �̵�
		playerX = 500; // ��ƽ�� X ��ǥ ��ġ�� �缳��
		score = 0; // ���� 0���� �缳��
		totalBricks = 24; // ��ü �긯�� 21����
		stage++;
		map = new MapGene(4, 6); 
		// �긯 ���η� 3��, ���η� 7�� �ؼ� �� 21��
		play = false;
		repaint(); // �����
	}
	public void win2() {
		ballposX = 500; // ���� X ��ǥ �⺻ ��ġ�� �缳��
		ballposY = 600; // ���� Y ��ǥ �⺻ ��ġ�� �缳��
		ballXdir = -1; // ���� X ��ǥ �̵�
		ballYdir = 2; // ���� Y ��ǥ �̵�
		playerX = 500; // ��ƽ�� X ��ǥ ��ġ�� �缳��
		score = 0; // ���� 0���� �缳��
		totalBricks = 48; // ��ü �긯�� 21����
		stage++;
		map = new MapGene(8, 6); 
		// �긯 ���η� 3��, ���η� 7�� �ؼ� �� 21��
		play = false;
		repaint(); // �����
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
		
		_chkLose = false; // ���� �� ���� Ű �����°� ���� -> ��ȿ��üũ ��
		play = false;
        ballXdir = 0; // ���� X �̵��� 0���� (����)
        ballYdir = 0; // ���� Y �̵��� 0���� (����)
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
		stage = 1; // �������� �ʱ�ȭ
		//setVisible(true);
		
	}
	public void keyPressed(KeyEvent e) // Ư�� Ű�� ��������
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) // ������ ����Ű �Է�
		{        
			System.out.println("������");
			if(playerX >= 880) // ��ƽ�� ������ ���� ���������
			{
				playerX = 880; // �� �ڸ� �״��
			}
			else // ��ƽ�� ������ ���� ������� �ʴٸ�
			{
				moveRight(); // ��ƽ�� ������ �̵�
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) // ���� ����Ű �Է�
		{
			System.out.println("����");
			if(playerX < 10) // ��ƽ�� ���� ���� ���������
			{
				playerX = 10; // �� �ڸ� �״��
			}
			else // ��ƽ�� ���� ���� ������� �ʴٸ�
			{
				moveLeft(); // ��ƽ�� ���� �̵�
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_ENTER) // Enter�� ������ ��
		{
			if(_chkLose) return;
			
			System.out.println("����");
			// ��ȿ�� �߰� -> ���� ���۽� ���� ������ �ٷ� ���� �������� ����
			restart();
        }		
	}
	public void restart() {
		if(!play) // ������ �÷��� ���� �ʰ� �ִ� ��Ȳ(�׾��� ��)
		{
			//setVisible(false);
			ballposX = 500; // ���� X ��ǥ �⺻ ��ġ�� �缳��
			ballposY = 600; // ���� Y ��ǥ �⺻ ��ġ�� �缳��
			ballXdir = -1; // ���� X ��ǥ �̵�
			ballYdir = 2; // ���� Y ��ǥ �̵�
			playerX = 500; // ��ƽ�� X ��ǥ ��ġ�� �缳��
			score = 0; // ���� 0���� �缳��
			totalBricks = 10; // ��ü �긯�� 24����
			map = new MapGene(2, 5);
			repaint();
			setVisible(true);
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void moveRight() // ������ ����Ű ������ ���� �޼ҵ�
	{
		 // ��ƽ�� ���������� �̵�
			play = true; // ��ŸƮ
			playerX+=20;
			direction = false;
	}
	public void moveLeft() // ���� ����Ű ������ ���� �ޙ�,
	{
			play = true; // ��ŸƮ
			playerX-=20;
			direction = true;
	}
	
	public void actionPerformed(ActionEvent e)  // ������ ���۵Ǿ��� ��
	{
		timer.start(); // Ÿ�̸� ��ŸƮ
		if(play) // �÷������̶��
		{
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 650, pl, 8))) 
			{
				// ���� ������ ������ ���� ������ ���� ������ �������� ����� �����մϴ�.(intersects)
				ballYdir = -ballYdir; // ���� ���Ʒ� ������ ����
				if (direction == true)
					ballXdir = -5; // ���� �¿� ������ �ӵ��� ����
				else if (direction == false)
					ballXdir = 5;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 650, pl, 8)))
			{
				// ���� ������ ������ ���� ������ ���� ������ �������� ����� �����մϴ�.(intersects)
				ballYdir = -ballYdir; // ���� ���Ʒ� ������ ����
				ballXdir = ballXdir + 3; // ���� �¿� ������ �ӵ��� �ø�
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 650, pl, 8)))
			{ 
				// ���� ������ ������ ���� ������ ���� ������ �������� ����� �����մϴ�.(intersects)
				ballYdir = -ballYdir; // ���� ���Ʒ� ������ ����
			}
			
			// check map collision with the ball		
			A: for(int i = 0; i<map.map.length; i++)
			{
				for(int j =0; j<map.map[0].length; j++)
				{				
					if(map.map[i][j] > 0)
					{
						//scores++;
						int brickX = j * map.brickWidth + 80; // ������ �긯�� ���� �΋Hġ�� �Ǵ� ���� x ��ǥ
						int brickY = i * map.brickHeight + 50; // ������ �긯�� ���� �΋Hġ�� �Ǵ� ���� y ��ǥ
						int brickWidth = map.brickWidth;  // �긯�� ���� ����
						int brickHeight = map.brickHeight; // �긯�� ���� ����
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight); // �긯(�긯�� X ��ǥ, �긯�� Y ��ǥ, ���� ����, ���� ����)					
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20); // �� �ݻ�..?
						Rectangle brickRect = rect; // �긯 �ϼ�
						if(ballRect.intersects(brickRect)) // �긯�� ���� �΋Hġ�� �ȴٸ�
						{					
							map.setBrickValue(0, i, j); // �긯�� ����..?
							score+=5; // ���� 5�� ����
							totalBricks--; // ��ü �긯 �� ����
							// when ball hit right or left of brick
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) // ���� �긯�� �¿쿡 �΋H���� ���
							{
								ballXdir = -ballXdir; // ���� �¿� ���� ����
							}
							// when ball hits top or bottom of brick
							else // ���� �긯�� ���Ͽ� �΋H���� ���
							{
								ballYdir = -ballYdir; // ���� ���� ���� ����
							}
							break A; // �긯 ����
						}
					}
				}
			}
			ballposX += ballXdir; // ���� X ��ǥ�� �¿� �����̸� ����
			ballposY += ballYdir; // ���� Y ��ǥ�� ���� �����̸� ����
			if(ballposX < 0) // ���� ���� ���� ���� �΋Hģ�ٸ�
			{
				ballXdir = -ballXdir; // ���� �¿� ���� ����
			}
			if(ballposY < 0) // ���� ���� ���� ���� �΋Hģ�ٸ�
			{
				ballYdir = -ballYdir; // ���� ���� ���� ����
			}
			if(ballposX > 970) // ���� ���� ������ ���� �΋Hģ�ٸ�
			{
				ballXdir = -ballXdir;  // ���� �¿� ���� ����
			}
			repaint();	
		}
	}
}

class MapGene {
	public int map[][]; // �긯 ������ ���� �迭
	public int brickWidth; // �긯�� ����
	public int brickHeight; // �긯�� ����
	public MapGene (int row, int col) // �긯 ����
	{
		map = new int[row][col]; // �긯�� ���ο� ���η� �迭�� ����
		for(int i = 0; i<map.length; i++) // �긯�� ���� �������� �ݺ�
		{
			for(int j =0; j<map[0].length; j++) // �긯�� ���� �������� �ݺ�
			{
				map[i][j] = 1; // ���߿� ���� �긯�� ������ ���� ��� ���� 1 �ֱ�
			}			
		}
		brickWidth = 800/col; // �긯�� ���δ� 540/col�� �ȴ�.
		brickHeight = 150/row; // �긯�� ���δ� 150/row�� �ȴ�.
	}	
	public void draw(Graphics2D g) // �긯 �׸���
	{
		for(int i = 0; i<map.length; i++) // �긯�� ���� �������� �ݺ�
		{
			for(int j =0; j<map[0].length; j++) // �긯�� ���� �������� �ݺ�
			{
				if(map[i][j] > 0) // ������ ��� ���� 1�� �־��⿡ ���������� ó������ ������ ���� ����
				{
					g.setColor(Color.yellow); // �긯�� ����
					g.fillRoundRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight, 20, 20); 
					// �긯�� ����(X ��ǥ, Y ��ǥ, ���� ����, ���� ����)

					// this is just to show separate brick, game can still run without it
					g.setStroke(new BasicStroke(3)); // �긯�� �긯 ���̸� �����ϴ� ���� �β�
					g.setColor(Color.black); // �긯�� �긯 ���̸� �����ϴ� ���� ����
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);	
					// �긯�� �����ϴ� ���� ����(X ��ǥ, Y ��ǥ, ���� ����, ���� ����)
				}
			}
		}
	}
	public void setBrickValue(int value, int row, int col) // ������
	{
		map[row][col] = value;
	}
}
public class Main {
	public Main() {
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