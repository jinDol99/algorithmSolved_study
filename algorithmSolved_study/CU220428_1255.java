package algorithmSolved_study;
import java.util.Scanner;
public class CU220428_1255 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final double a = s.nextDouble();
		final double b = s.nextDouble();
		if (a <= b) {
			for (double i=0.00; a+i <= b;) {
				System.out.printf("%.2f",a+i);
				System.out.print(" ");
				i+=0.01;
				i++;
			}
		}
	}
}
