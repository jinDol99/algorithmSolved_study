package algorithmSolved_study;
import java.util.*;
public class BJ220522_10950 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] A = new int[T];
		int[] B = new int[T];
		for (int i = 0; i < T; i++) {
			A[i] = s.nextInt();
			B[i] = s.nextInt();
		}
		for (int i = 0; i < T; i++)
			System.out.println(A[i]+B[i]);
	}
}