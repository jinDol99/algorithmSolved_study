package algorithmSolved_study;
import java.util.*;
public class BJ220511_2609 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int maxNum = 0;
		for (int i = 1; i <= A; i++) {
			if (A % i == 0 && B % i ==0) {
				maxNum=i;
			}
		}
		System.out.println(maxNum);
		for (int i = A; i <= A*B; i++) {
			if (i % A == 0 && i % B == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
/*
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
*/