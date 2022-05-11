package algorithmSolved_study;
import java.util.*;
public class BJ220511_2609 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt(); // 첫번째 자연수
		int B = s.nextInt(); // 두번째 자연수
		int maxNum = 0; // 최대 공약수를 구하기 위해 공약수를 입력하는 변수
		for (int i = 1; i <= A; i++) { 
			/* 큰 자연수든 작은 자연수든 어느 자연수를 넘어가면 더이상 공약수가 아니니
			   어느 자연수 변수를 적어도 상관없음*/
			if (A % i == 0 && B % i ==0) { // i값으로 두 자연수 모두 나눠지는 경우
				maxNum=i; // 그 값이 공약수(반복하면서 점점 커짐)
			}
		}
		System.out.println(maxNum); // 최대 공약수 출력
		for (int i = A; i <= A*B; i++) {
			/* 작든 크든 큰 자연수부터 최소공배수가 될 수 있어서 그리고 두 수에 공배수가 거의
			   없을 때 최소 공배수는 두 자연수의 곱이 됨*/
			if (i % A == 0 && i % B == 0) { // 
				System.out.println(i);
				break;
			}
		}
	}
}
/*
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
*/