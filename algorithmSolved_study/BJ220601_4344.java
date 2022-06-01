package algorithmSolved_study;
import java.util.*;
public class BJ220601_4344 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int C = s.nextInt();
		for (int i = 0; i < C; i++) {
			int N = s.nextInt();
			int sum = 0;
			int[] arr = new int[N];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = s.nextInt();
				sum += arr[j];
			}
			double cnt = 0;
			for (int j = 0; j < arr.length; j++)
				if (arr[j] > sum/arr.length)
					cnt++;
			System.out.printf("%.3f%%\n",(cnt/arr.length)*100 );
		}
	}
}
