/*
 문제 푸는 중! - 박진석
 */
package algorithmSolved_study;
import java.util.Scanner;

public class BJ20524_2858 {
	public static void main(String[] args) {
		int B = 0;
		int R = 0;
		int L = 0;
		int W = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		
		B = sc.nextInt();	//((w*2)+(l*2)-4)
		R = sc.nextInt();	//r= (w-2)*(l-2)
		W = (R/2)+L;
		L = ((B+4)/2)-W;
		
		System.out.printf("%d, %d, %d, %d",W,L,B,R);
	}
}
/*
문제---------------------------------
상근이는 기숙사 생활을 한다. 상근이의 방의 크기는 L×W 이다.
수업시간에 타일 채우기 경우의 수를 계산하던 상근이는 자신의 방도 1×1크기 타일로 채우려고 한다.
이때, 가장자리는 빨간색으로, 나머지는 갈색으로 채우려고 한다. 아래 그림은 상근이의 방의 크기가 4×3일 때 이다.



어느 날 상근이네 방에 하근이가 놀러왔다. 하근이는 아름다운 타일 배치에 감동받았다.
다시 방으로 돌아온 하근이는 빨간색과 갈색 타일의 개수는 기억했지만, 방의 크기는 기억해내지 못했다.
빨간색과 갈색 타일의 개수가 주어졌을 때, 상근이 방의 크기를 구하는 프로그램을 작성하시오.


입력----------------------------------
첫째 줄에 빨간색 타일의 수 R과 갈색 타일의 수 B가 주어진다. (8 ≤ R ≤ 5000, 1 ≤ B ≤ 2,000,000)


출력----------------------------------
첫째 줄에 상근이네 방의 크기 L과 W을 공백으로 구분하여 출력한다.
만약, 두 수가 다르다면, 큰 수가 L이 되고 작은 수가 W이 된다. 항상 정답이 유일한 경우만 입력으로 주어진다.


예제 입력 / 출력 1 -------------------
8 1 / 3 3

예제 입력 / 출력 2 -------------------
10 2 / 4 3

예제 입력 / 출력 3 -------------------
24 24 / 8 6
*/