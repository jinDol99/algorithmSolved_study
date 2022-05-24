package algorithmSolved_study;
import java.util.*;
public class BJ220524_1920 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();
		Arrays.sort(A);
		int M = s.nextInt();
		int[] Marr = new int[M];
		for (int i = 0; i < Marr.length; i++) {
			Marr[i] = s.nextInt();
			if (Arrays.binarySearch(A, Marr[i]) >= 0) {
				Marr[i] = 1;
			} else {
				Marr[i] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			System.out.println(Marr[i]);
		}
	}
}