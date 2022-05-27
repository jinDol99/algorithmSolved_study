package algorithmSolved_study;
import java.util.*;
public class BJ220527_2693 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] T1 = new int[10];
		int[] cor = new int[T];
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T1.length; j++) {
				T1[j] = s.nextInt();
			}
			Arrays.sort(T1);
			cor[i] = T1[7];
		}
		for (int i = 0; i < cor.length; i++)
			System.out.println(cor[i]);
	}
}
