package algorithmSolved_study;
import java.util.*;
public class BJ220524_3052 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10];
		int[] rest = new int[10];
		int cnt = 10;
		for (int i = 0; i < 10; i++) {
			arr[i] = s.nextInt();
			arr[i] %= 42;
			rest[i] = arr[i];
		}
		for (int i = 0; i < 10; i++)
			for (int j = i+1; j < 10; j++) {
				if (arr[i] == rest[j]) {
					cnt--; rest[j] =-1;
					break;
				}
			}
		System.out.println(cnt);
	}
}
