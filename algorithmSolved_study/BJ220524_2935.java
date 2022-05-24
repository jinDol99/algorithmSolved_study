package algorithmSolved_study;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ220524_2935 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String a = sc.next();
	        BigInteger A = new BigInteger(a);
			String b = sc.next();
			String c = sc.next();
	        BigInteger C = new BigInteger(c);
	        BigInteger result = new BigInteger("0");
			switch (b) {
			case "*":
				 result = C.multiply(A);
				break;
			case "+":
				 result = C.add(A);
				break;
			}
			System.out.println(result);
		
		}

	}