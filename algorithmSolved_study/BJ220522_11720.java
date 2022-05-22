package algorithmSolved_study;
import java.util.*;
public class BJ220522_11720 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		String num = s.next();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += num.charAt(i)-48;
		}
		System.out.println(sum);
	}
}