package algorithmSolved_study;
import java.util.Scanner;
public class BJ220427_5543 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		if (a[0] >= 100 & a[0] <= 2000 & a[1] >= 100 & a[1] <= 2000 & a[2] >= 100 & a[2] <= 2000 & a[3] >= 100 & a[3] <= 2000 & a[4] >= 100 & a[4] <= 2000) {
			if (a[0] < a[1] & a[0] < a[2]) {
				if (a[3] < a[4]) {
					System.out.println(a[0] + a[3] - 50);
				} else 
					System.out.println(a[0] + a[4] - 50);
			} else if (a[1] < a[0] & a[1] < a[2]) {
				if (a[3] < a[4]) {
					System.out.println(a[1] + a[3] - 50);
				} else 
					System.out.println(a[1] + a[4] - 50);
			} else {
				if (a[3] < a[4]) {
					System.out.println(a[2] + a[3] - 50);
				} else 
					System.out.println(a[2] + a[4] - 50);
			}
		}
	}
}