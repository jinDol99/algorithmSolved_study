package algorithmSolved_study;
import java.util.Scanner;
public class BJ220429_1065 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int sum = 0;
		if (N >= 1 && N <= 1000) {
			for (int i = 1; i <= N; i++) {
				String j = Integer.toString(i);
				if (i < 100) {
					sum++;
				} else if (i >= 100) {
					if (i == 1000) {
						break;
					}
					if (j.charAt(1) - j.charAt(0) == j.charAt(2) - j.charAt(1)) {
						sum++;
					}
				}
			} System.out.println(sum);
		}
	}
}