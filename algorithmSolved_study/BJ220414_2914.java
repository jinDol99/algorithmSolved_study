package algorithmSolved_study;

import java.util.Scanner;

public class BJ220414_2914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int melody = sc.nextInt();
		int avg = sc.nextInt();
		System.out.println((avg-1)*melody+1);
	}
}
