package algorithmSolved_study;

import java.util.Scanner;

public class BJ220523_10179 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double [] ab = new double [a];
		for (int i = 0; i<ab.length; i++) {
			ab[i] = sc.nextDouble();
			double c = ab[i];
			double d = c*(double)4/5;
			ab[i] = d;
		}
		for (int i = 0; i<ab.length; i++) {
			System.out.printf("$%.2f\n",ab[i]);
		}
		
	

	}

}