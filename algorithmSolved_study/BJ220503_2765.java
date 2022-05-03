package algorithmSolved_study;

import java.util.Scanner;

public class BJ220503_2765 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 1;
		while (true) {
			double wheel = scan.nextDouble();
			double rotation = scan.nextDouble();
			double time = scan.nextDouble();
			if (rotation == 0) {
				break;
			}
			time = (time / 60) / 60;
			double distance = ((((wheel * 3.1415927) * rotation) / 12) / 5280);
			double avgSpeed = (distance / time);

			System.out.printf(String.format("Trip #" + i + ": %.2f", distance) + " %.2f", avgSpeed);
			System.out.println();
			i++;
		}
	}
}
