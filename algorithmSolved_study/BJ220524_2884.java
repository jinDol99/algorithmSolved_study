package algorithmSolved_study;
import java.util.*;
public class BJ220524_2884 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int H = s.nextInt();
		int M = s.nextInt();
		M -= 45;
		if (M < 0) {
			M += 60;
			H--;
		}
		if (H<0) {
			H += 24;
		}
		System.out.println(H + " " + M);
	}
}
