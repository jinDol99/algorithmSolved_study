package algorithmSolved_study;
import java.util.*;
public class BJ220511_1292 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int[] arr = new int[B];
		int cnt = 0;
		int a = 1;
		int sum=0;
		for (int i = 0; i < B; i++) {
			arr[i] = a;
			cnt++;
			if (a == cnt) {
				a++; cnt=0;
			}
			if (i >= A-1) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}
}
