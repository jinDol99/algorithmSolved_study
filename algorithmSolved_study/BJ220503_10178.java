package algorithmSolved_study;
import java.util.Scanner;

public class BJ220503_10178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		int[] c = new int[count];				// 첫 번째 숫자(사탕의 개수)를 담을 배열 c를 만듦
		int[] v = new int[count];				// 두 번째 숫자(형제의 수)를 담을 배열 v를 만듦

		for (int i = 0; i < c.length; i++) {	// c 배열의 크기(count 값을 넣어도 ㄱㅊ)만큼 for문 돌림
			c[i] = sc.nextInt();				// 입력된 첫 번째 숫자는 c 배열의 i번째, 두 번째 입력된 숫자는 v 배열의 i번째에 저장 
			v[i] = sc.nextInt();				// 참고: 굳이 print()를 사용하지 않아도 nextInt() 사용 가능함!
		}
		for (int j = 0; j < c.length; j++) {	// c 배열의 크기만큼 몫(나눈 사탕 개수)과 나머지(남는 사탕 개수)를 문장과 함깨 출력
			System.out.printf("You get %d piece(s) and your dad gets %d piece(s).\n", c[j] / v[j], c[j] % v[j] );
		}
	}
}