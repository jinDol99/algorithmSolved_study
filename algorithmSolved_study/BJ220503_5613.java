package algorithmSolved_study;

import java.util.Scanner;

public class BJ220503_5613 {

	public static void main(String[] args) {
		int result, num;
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		result = num;
		while(true) {
			String in = input.next();
			if(in.equals("=")) {
				break;
			}

			int b = input.nextInt();
			if(in.equals("+")) {
				result = result + b;
			}
			if(in.equals("-")) {
				result = result - b;
			}
			if(in.equals("*")) {
				result = result * b;
			}
			if(in.equals("/")) {
				result = result / b;
			}

		}
		System.out.println(result);		
	}

}
