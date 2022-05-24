package algorithmSolved_study;
import java.util.*;
public class BJ220524_2475 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
			sum += arr[i]*arr[i];
		}
		System.out.println(sum % 10);
	}
}
