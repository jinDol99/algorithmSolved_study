package algorithmSolved_study;
import java.util.*;
public class BJ220527_1978 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		int cnt = 0;
		next:
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
			for (int j = 2; j <= arr[i]; j++) {
				if (arr[i] == j)
					cnt++;
				if (arr[i] % j == 0)
					break;
			}
		}
		System.out.println(cnt);
	}
}
