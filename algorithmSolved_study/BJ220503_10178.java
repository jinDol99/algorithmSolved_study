package algorithmSolved_study;
import java.util.Scanner;

public class BJ220503_10178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		int[] c = new int[count];
		int[] v = new int[count];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		for (int j = 0; j < c.length; j++) {
			System.out.printf("You get %d piece(s) and your dad gets %d piece(s).\n", c[j] / v[j], c[j] % v[j] );
		}
	}
}