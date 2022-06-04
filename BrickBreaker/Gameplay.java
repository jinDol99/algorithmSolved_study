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
	public Gameplay() { // �߰� ������ ���� �ڵ�
		map = new MapGenerator(2, 5);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g) { // ���� ������Ʈ�� ���� �� �׸��� �ڵ�
		g.setColor(Color.black); // ���� ���� �ʿ��� ������Ʈ�� ����
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

		if(totalBricks <= 0) { // �¸���
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
		if(ballposY > 670) { // �й��
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
	public void win() { // ù�������� Ŭ�����
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
	public void win2() { // �ι�° �������� Ŭ�����
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
	public void win3(Graphics g) { // ������ �������� Ŭ�����
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
	public void lose(Graphics g) { // �й��
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
	public void keyPressed(KeyEvent e) { // ���� Ű���� Ŭ���� ó�� �ڵ�
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // ������ ����Ű Ŭ�� 
			if(playerX >= 880) {
				playerX = 880;
			}
			else {
				moveRight();
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // ���� ����Ű Ŭ��
			if(playerX < 10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
        }
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { // ���� Ŭ��
			if(_chkLose) return;
			restart();
        }		
	}
	public void restart() { // ����۽�
		if(!play & temp == 1) { // ù��° �������� �����
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
		} else if (!play & temp == 2) // �ι�° �������� �����
			win();
		else if (!play & temp == 3) // ����° �������� �����
			win2();
	}
	public void keyReleased(KeyEvent e) {} // �߻� �޼ҵ� ����
	public void keyTyped(KeyEvent e) {} // �߻� �޼ҵ� ����
	public void moveRight() { // ��ƽ ���������� �̵�
			play = true;
			playerX+=20;
			direction = false;
	}
	public void moveLeft() { // ��ƽ �������� �̵�
			play = true;
			playerX-=20;
			direction = true;
	}
	public void actionPerformed(ActionEvent e) { // ���� ������Ʈ�� �̵� �� �浹 �� ó��
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