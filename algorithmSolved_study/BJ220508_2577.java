package algorithmSolved_study;
import java.util.*;
public class BJ220508_2577 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();
		int[] arr = new int[10]; 
		int ABC = A*B*C;
		for (int i = 0; ABC > 0; i++) {
			arr[ABC%10] += 1;
			ABC /= 10;
		}
		for (int numbers: arr)
			System.out.println(numbers);
	}
}
/*
�� ���� �ڿ��� A, B, C�� �־��� �� A �� B �� C�� ����� ����� 0���� 9���� ������ ���ڰ� 
�� ���� ���������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� ��� A = 150, B = 266, C = 427 �̶�� 
A �� B �� C = 150 �� 266 �� 427 = 17037300 �� �ǰ�, 
����� ��� 17037300 ���� 0�� 3��, 1�� 1��, 3�� 2��, 7�� 2�� ������.
*/