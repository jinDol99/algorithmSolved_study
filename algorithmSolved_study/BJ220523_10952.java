package algorithmSolved_study;
import java.util.*;
public class BJ220523_10952 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = 1, B = 1;
		while(true) {
			A = s.nextInt();
			B = s.nextInt();
			if (A == 0 & B == 0)
				break;
			System.out.println(A+B);
		}
	}
}
