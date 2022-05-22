package algorithmSolved_study;
import java.util.*;
public class BJ220522_2675 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] R = new int[T];
		String[] S = new String[T];
		for (int i = 0; i < T; i++) {
			R[i] = s.nextInt();
			S[i] = s.next();
		}
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			for (int j = 1; j <= R[i]*S[i].length(); j++) {
				System.out.print(S[i].charAt(cnt));
				if (j % R[i] == 0)
					cnt++;
			}
			cnt=0;
			System.out.println();
		}
	}
}
