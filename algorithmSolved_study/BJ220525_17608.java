package algorithmSolved_study;
import java.util.*;
public class BJ220525_17608 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int max = 0;
		int cnt = 0;
		int[] cm = new int[N];
		for (int i  = 0; i < N; i++) {
			cm[i] = s.nextInt();
		}
		for (int i = N-1; i >= 0; i--) {
			if (cm[i] > max) {
				max = cm[i];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
