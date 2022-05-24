package algorithmSolved_study;
import java.util.*;
public class BJ220524_2587 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}
}
