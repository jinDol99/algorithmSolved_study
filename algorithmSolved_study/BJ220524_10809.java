package algorithmSolved_study;
import java.util.*;
public class BJ220524_10809 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String S = s.next();
		for (int i = 97; i < 123; i++)
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) == i) {
					System.out.print(j + " ");
					break;
				}
				if (j == S.length()-1)
					System.out.print(-1 + " ");
			}
	}
}
