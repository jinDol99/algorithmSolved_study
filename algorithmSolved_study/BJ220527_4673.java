package algorithmSolved_study;
import java.util.*;
public class BJ220527_4673 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			if (i >= 0 & i < 10)
				arr[i] = i*2;
			else if (i < 100 & i >= 10) 
				arr[i] = i/10 + i%10 + i;
			else if (i < 1000 & i >= 100)
				arr[i] = i/100 + (i%100)/10 + i%10 + i;
			else if (i < 10000)
				arr[i] = i/1000 + (i%1000)/100 + (i%100)/10 + i%10 + i;
		}
		next:
		for (int i = 0; i <= 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				if (arr[j] == i) {
					continue next;
				}
			}
			System.out.println(i);
		}
	}
}
