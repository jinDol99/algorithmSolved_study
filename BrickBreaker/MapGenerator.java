package BrickBreaker;
/*import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class MapGenerator 
{
	public int map[][]; // 브릭 생성을 위한 배열
	public int brickWidth; // 브릭의 가로
	public int brickHeight; // 브릭의 세로
	public MapGenerator (int row, int col) // 브릭 생성
	{
		map = new int[row][col]; // 브릭의 가로와 세로로 배열을 만듦
		for(int i = 0; i<map.length; i++) // 브릭의 세로 갯수까지 반복
		{
			for(int j =0; j<map[0].length; j++) // 브릭의 가로 갯수까지 반복
			{
				map[i][j] = 1; // 나중에 있을 브릭의 생성을 위한 모든 값에 1 넣기
			}			
		}
		brickWidth = 540/col; // 브릭의 가로는 540/col이 된다.
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
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight); 
					// 브릭의 범위(X 좌표, Y 좌표, 가로 길이, 세로 길이)

					// this is just to show separate brick, game can still run without it
					g.setStroke(new BasicStroke(3)); // 브릭과 브릭 사이를 구분하는 선의 두께
					g.setColor(Color.white); // 브릭과 브릭 사이를 구분하는 선의 색깔
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
}*/