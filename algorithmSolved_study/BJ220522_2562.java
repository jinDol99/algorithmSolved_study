package algorithmSolved_study;
import java.util.*;
public class BJ220522_2562 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] num = new int[9];
		int max = 0, cnt = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = s.nextInt();
			if (num[i] > max) {
				max = num[i];
				cnt = i+1;
			}
		}
		System.out.println(max + "\n" + cnt);
	}
}
