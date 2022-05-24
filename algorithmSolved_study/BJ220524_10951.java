package algorithmSolved_study;
import java.util.*;
public class BJ220524_10951 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = 0, B = 0;
		while (s.hasNextInt()) {
			A = s.nextInt();
			B = s.nextInt();
			if (A % 1 != 0 & B % 1 != 0)
				break;
			System.out.println(A+B);
		}
		s.close();
	}
}
