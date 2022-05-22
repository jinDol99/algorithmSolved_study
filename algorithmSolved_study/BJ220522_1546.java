package algorithmSolved_study;
import java.util.*;
public class BJ220522_1546 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = 0;
		double sum = 0;
		int[] sc = new int[N];
		for (int i = 0; i < N; i++) {
			sc[i] = s.nextInt();
			if (sc[i] > M)
				M = sc[i];
		}
		for(int i = 0; i < N; i++) {
			sum += (double)sc[i]/M*100;
		}
		sum = sum/N;
		System.out.println(sum);
	}
}
