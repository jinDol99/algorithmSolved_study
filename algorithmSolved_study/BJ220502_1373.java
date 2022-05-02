package algorithmSolved_study;
import java.util.*;
public class BJ220502_1373 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String octaNo = s.next();
		int a = 0, b = 0, c = 0;
		outer:
		for (;;) {
			if (octaNo.length() % 3 == 0) {
				for (int i = 0; i < octaNo.length();) {
					if (octaNo.charAt(i) == 49) {
						a=4;
					} else a=0;
					if (octaNo.charAt(i+1) == 49) {
						b=2;
					} else b=0;
					if (octaNo.charAt(i+2) == 49) {
						c=1;
					} else c=0;
					System.out.print(a+b+c);
					i+=3;
					if (i == octaNo.length()) break outer;
				}
			} else if (octaNo.length() % 3 == 1) {
				octaNo = "00" + octaNo;
			} else if (octaNo.length() % 3 == 2) {
				octaNo = "0" + octaNo;
			}
		}	
	}
}