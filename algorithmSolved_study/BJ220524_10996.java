package algorithmSolved_study;

import java.util.Scanner;

public class BJ220524_10996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for (int i = 0; i<a*2;i++) {
			for(int j = 0; j<a;j++) {
				if(i%2!=0) {
					if(j%2!=0) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					if(j%2==0) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
		System.out.println();
		}

	}

}