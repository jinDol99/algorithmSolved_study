package algorithmSolved_study;
import java.util.*;
public class BJ220522_2438 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = -1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
