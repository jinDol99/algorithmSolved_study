package algorithmSolved_study;
import java.util.*;
public class BJ220602_2748 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] arr = new long[n+1];
		arr[0] = 0; 
		if (n == 1)
		arr[1] = 1;
		if(n > 1) {
			arr[1] = 1;
			for (int i = 2; i < arr.length; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
		System.out.println(arr[n]);
	}
}