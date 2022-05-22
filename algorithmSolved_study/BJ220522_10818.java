package algorithmSolved_study;
import java.util.*;
public class BJ220522_10818 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int max = -1000000, min = 1000000;
		for (int i = 0; i < N; i++) {
			int num = s.nextInt();
			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}
		System.out.println(min + " " + max);
	}
}
