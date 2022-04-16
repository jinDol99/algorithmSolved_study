package algorithmSolved_study;
import java.util.Scanner;

public class BJ220417_20499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K, A, D;
		do {
		System.out.print("¼ýÀÚ:");
		
		sc = new Scanner(sc.next()).useDelimiter("/");
		
		K = sc.nextInt();
		D = sc.nextInt();
		A = sc.nextInt();

		if(K >= 0 && K <= 20 && D >= 0 && D <= 20 && A >= 0 && A <= 20)
			break;
		
		} while (true);
		
		if((K + A < D)||(D == 0))
			System.out.print("hasu");
		else
			System.out.println("gosu");
	}
}