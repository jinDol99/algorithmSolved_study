package algorithmSolved_study;
import java.util.Scanner;

public class BJ220414_15727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		int L = sc.nextInt();
		
		if(L % 5 == 0)
			System.out.println(L / 5);
		else
			System.out.println((L / 5) + 1);
	}
}
