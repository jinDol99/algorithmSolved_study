package algorithmSolved_study;
import java.util.*;
public class BJ220530_1110 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int temp = (a%10)*10+(a/10 + a%10)%10;
		int cnt = 1;
		while (a != temp) {
			temp = (temp%10)*10+(temp/10 + temp%10)%10;
			cnt++;
		}
		System.out.println(cnt);
	}
}
