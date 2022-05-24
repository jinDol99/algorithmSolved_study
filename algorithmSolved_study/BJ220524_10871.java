package algorithmSolved_study;
import java.util.*;
public class BJ220524_10871 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int X = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = s.nextInt();
			if (A[i] >= X)
				A[i] = 0;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				continue;
			}
			System.out.print(A[i] + " ");
		}
	}
}
