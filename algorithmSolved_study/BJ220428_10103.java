package algorithmSolved_study;
import java.util.Scanner;
public class BJ220428_10103 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a_score = 100;
		int b_score = 100;
		int n = s.nextInt();
		if (n >= 1 & n <= 15) {
			for (int i = 0; i < n; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				if (a<b) {
					a_score -= b;
				} else if (a>b) {
					b_score -= a;
				}
			}
			System.out.println(a_score + "\n" + b_score);
		}
	}
}
