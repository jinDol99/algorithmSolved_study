package algorithmSolved_study;
import java.util.Scanner;

public class BJ220428_23972 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K, N;
		System.out.print("");
		K = sc.nextInt();
		N = sc.nextInt();
		
		if ( K >= 1 || N <= 200000000) {
			int X = ( K * N ) / ( N - 1 );
			if (X <= 0) {
				System.out.println("-1");
			} else {
				System.out.println(X);
			}
		} else {
			System.out.println("ss");
		}
	}
}