package algorithmSolved_study;
import java.util.*;
public class BJ220526_11047 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		int[] arr = new int[N];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++)
			arr[i] = s.nextInt();
		for (int i = N-1; i >= 0; i--) {
			if (K-arr[i] < 0)
				continue;
			if (K-arr[i] >= 0) {
				while (K-arr[i] >= 0) {
					K -= arr[i];
					cnt++;
					if (K < 0) {
						K += arr[i];
						cnt--;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
