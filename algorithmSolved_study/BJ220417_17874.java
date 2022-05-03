package algorithmSolved_study;
import java.util.Scanner;

public class BJ220417_17874 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int h = scan.nextInt();
		int v = scan.nextInt();

		int c1 = 4 * h * v;
		int c2 = 4 * (n - v) * h;
		int c3 = 4 * (n - h) * v;
		int c4 = 4 * (n - h) * (n - v);

		if (c1 > c2 && c1 > c3 && c1 > c4) {
			System.out.println(c1);
		} else if (c2 > c1 && c2 > c3 && c2 > c4) {
			System.out.println(c2);
		} else if (c3 > c1 && c3 > c2 && c3 > c4) {
			System.out.println(c3);
		} else {
			System.out.println(c4);
		}
	}
}
