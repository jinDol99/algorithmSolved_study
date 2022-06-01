package BrickBreaker;
/*import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
public class Gameplay extends JPanel implements KeyListener, ActionListener
{
	private boolean play = false; // ���� ���� ��
	private int score = 0; // ����
	private int totalBricks = 48; // ���� ��ü ����(�����ִ� ����)
	private Timer timer; // Ÿ�̸�
	private int delay=8; // �� �ӵ�(���ڰ� �������� �����̰� �� �ɷ� ������)
	private int playerX = 310; // ��ƽ�� X ��ǥ
	private int ballposX = 120; // ���� X ��ǥ
	private int ballposY = 350; // ���� Y ��ǥ
	private int ballXdir = -1; // ���� X ���� �̵��� �ӵ�(���ڰ� Ŀ������ Ŀ��)
	private int ballYdir = -2; // ���� Y ���� �̵��� �ӵ�(���ڰ� Ŀ������ Ŀ��)
	private MapGenerator map; 
	public Gameplay()
	{
		map = new MapGenerator(4, 12); // �긯�� ����(���� ����, ���� ����)
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
		g.fillRect(1, 1, 692, 592); // ����� ���� ����(����,����, ����,���� ��ǥ)
		
		// drawing map
		map.draw((Graphics2D) g);
		
		// borders
		g.setColor(Color.yellow); // ����� ����
		g.fillRect(0, 0, 3, 592); // ���� ���
		g.fillRect(0, 0, 692, 3); // ���� ���
		g.fillRect(683, 0, 3, 592); // ������ ���
		
		// the scores 		
		g.setColor(Color.white); // ���� ����
		g.setFont(new Font("serif",Font.BOLD, 25)); // ���� ��Ʈ �� ũ��
		g.drawString(""+score, 590,30); // (�⺻ ����, ���� X ��ǥ, Y ��ǥ)
		
		// the paddle
		g.setColor(Color.yellow); // ��ƽ ����
		g.fillRect(playerX, 550, 100, 8); 
		// ��ƽ ��ǥ(X ��ǥ, Y ��ǥ, ����, �β�)
		
		// the ball
		g.setColor(Color.red); // ���� ����
		g.fillOval(ballposX, ballposY, 20, 20); 
		// (���� X ��ǥ, ���� Y ��ǥ, ���� �¿� ����, ���� ���� ����)
	
		// when you won the game
		if(totalBricks <= 0) // ���� �긯�� ������ 0�� �����϶�(�¸���)
		{
			 play = false;
             ballXdir = 0; // ���� X �̵��� 0���� (����)
     		 ballYdir = 0; // ���� Y �̵��� 0���� (����)
             g.setColor(Color.RED); // �¸��� ������ ���� ����
             g.setFont(new Font("serif",Font.BOLD, 30));
             // �¸��� ������ ���� ��Ʈ�� ũ��
             g.drawString("You Won", 260,300);
             // �¸��� ������ ���� �� X ��ǥ, Y ��ǥ
             g.setColor(Color.RED);
             // �¸��� ������ ���� ����
             g.setFont(new Font("serif",Font.BOLD, 20));
             // �¸��� ������ ���� ��Ʈ�� ũ��
             g.drawString("Press (Enter) to Restart", 230,350);
             // �¸��� ������ ���� �� X ��ǥ, Y ��ǥ
		}
		
		// when you lose the game
		if(ballposY > 570) // ���� �ٴ� �Ʒ��� �������� ��(�й��)
        {
			 play = false;
             ballXdir = 0; // ���� X �̵��� 0���� (����)
     		 ballYdir = 0; // ���� Y �̵��� 0���� (����)
             g.setColor(Color.RED); // �й�� ������ ���� ����
             g.setFont(new Font("serif",Font.BOLD, 30));
             // �й�� ������ ���� ��Ʈ�� ũ��
             g.drawString("Game Over, Scores: "+score, 190,300);
             // �й�� ������ ����(+����) �� X ��ǥ, Y ��ǥ
             g.setColor(Color.RED);
             // �й�� ������ ���� ����
             g.setFont(new Font("serif",Font.BOLD, 20));  
             // �й�� ������ ���� ��Ʈ�� ũ��
             g.drawString("Press (Enter) to Restart", 230,350);
             // �й�� ������ ���� �� X ��ǥ, Y ��ǥ
        }
		g.dispose(); // ������ Frame�� ����
	}
	public void keyPressed(KeyEvent e) // Ư�� Ű�� ��������
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) // ������ ����Ű �Է�
		{        
			if(playerX >= 600) // ��ƽ�� ������ ���� ���������
			{
				playerX = 600; // �� �ڸ� �״��
			}
			else // ��ƽ�� ������ ���� ������� �ʴٸ�
			{
				moveRight(); // ��ƽ�� ������ �̵�
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) // ���� ����Ű �Է�
		{          
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
			if(!play) // ������ �÷��� ���� �ʰ� �ִ� ��Ȳ(�׾��� ��)
			{
				play = true;
				ballposX = 120; // ���� X ��ǥ �⺻ ��ġ�� �缳��
				ballposY = 350; // ���� Y ��ǥ �⺻ ��ġ�� �缳��
				ballXdir = -1; // ���� X ��ǥ �̵�
				ballYdir = -2; // ���� Y ��ǥ �̵�
				playerX = 310; // ��ƽ�� X ��ǥ ��ġ�� �缳��
				score = 0; // ���� 0���� �缳��
				totalBricks = 21; // ��ü �긯�� 21����
				map = new MapGenerator(3, 7); 
				// �긯 ���η� 3��, ���η� 7�� �ؼ� �� 21��
				repaint(); // �����
			}
        }		
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void moveRight() // ������ ����Ű ������ ���� �޼ҵ�
	{
		play = true; // �÷������̶��
		playerX+=20; // ��ƽ�� ���������� �̵�
	}
	public void moveLeft() // ���� ����Ű ������ ���� �ޙ�,
	{
		play = true; // �÷������̶��
		playerX-=20; // ��ƽ�� �������� �̵�
	}
	public void actionPerformed(ActionEvent e)  // ������ ���۵Ǿ��� ��
	{
		timer.start(); // Ÿ�̸� ��ŸƮ
		if(play) // �÷������̶��
		{			
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 30, 8))) 
			{
				// ���� ������ ������ ���� ������ ���� ������ �������� ����� �����մϴ�.(intersects)
				ballYdir = -ballYdir; // ���� ���Ʒ� ������ ����
				ballXdir = -2; // ���� �¿� ������ �ӵ��� ����
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 550, 30, 8)))
			{
				// ���� ������ ������ ���� ������ ���� ������ �������� ����� �����մϴ�.(intersects)
				ballYdir = -ballYdir; // ���� ���Ʒ� ������ ����
				ballXdir = ballXdir + 1; // ���� �¿� ������ �ӵ��� �ø�
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 550, 40, 8)))
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
			if(ballposX > 670) // ���� ���� ������ ���� �΋Hģ�ٸ�
			{
				ballXdir = -ballXdir;  // ���� �¿� ���� ����
			}
			repaint();
		}
	}
}
*/