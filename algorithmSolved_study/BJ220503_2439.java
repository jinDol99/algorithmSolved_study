package algorithmSolved_study;
import java.util.Scanner;
public class BJ220503_2439 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if (N >= 1 && N <= 100) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j+1<N-i)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
