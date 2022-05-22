package algorithmSolved_study;
import java.util.*;
public class BJ220522_2920 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] code = new int[8];
		int sum = 1;
		for (int i = 0; i < code.length; i++) {
			code[i] = s.nextInt();
			sum = code[i] - sum;
		}
		if (sum == 5)
			System.out.println("ascending");
		else if (sum == -3)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
