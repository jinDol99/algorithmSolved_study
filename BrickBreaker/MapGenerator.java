package BrickBreaker;
/*import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class MapGenerator 
{
	public int map[][]; // �긯 ������ ���� �迭
	public int brickWidth; // �긯�� ����
	public int brickHeight; // �긯�� ����
	public MapGenerator (int row, int col) // �긯 ����
	{
		map = new int[row][col]; // �긯�� ���ο� ���η� �迭�� ����
		for(int i = 0; i<map.length; i++) // �긯�� ���� �������� �ݺ�
		{
			for(int j =0; j<map[0].length; j++) // �긯�� ���� �������� �ݺ�
			{
				map[i][j] = 1; // ���߿� ���� �긯�� ������ ���� ��� ���� 1 �ֱ�
			}			
		}
		brickWidth = 540/col; // �긯�� ���δ� 540/col�� �ȴ�.
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
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight); 
					// �긯�� ����(X ��ǥ, Y ��ǥ, ���� ����, ���� ����)

					// this is just to show separate brick, game can still run without it
					g.setStroke(new BasicStroke(3)); // �긯�� �긯 ���̸� �����ϴ� ���� �β�
					g.setColor(Color.white); // �긯�� �긯 ���̸� �����ϴ� ���� ����
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
}*/