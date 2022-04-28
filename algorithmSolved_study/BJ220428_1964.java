package algorithmSolved_study;
import java.util.*;
public class BJ220428_1964 {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int N = s.nextInt();
		long dot = 5L;
		if (N>=1 & N <= 10000000) {
			for (int i = 1; i < N; i++) {
				dot += 3*i+4;
			}
			System.out.print(dot%45678);
		}
	}
}
