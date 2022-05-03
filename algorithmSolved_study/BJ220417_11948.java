package algorithmSolved_study;
import java.util.*;
public class BJ220417_11948 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        int D = s.nextInt();
        int E = s.nextInt();
        int F = s.nextInt();
        int Isum = 0;
        if (A >= 0 && A <= 100 && B >= 0 && B <= 100 && C >= 0 && C <= 100 && D >= 0 && D <= 100 && E >= 0 && E <= 100 && F >= 0 && F <= 100) {
            if (A > B && C > B && D > B) {
                Isum += A + C + D;
                if (E > F) {
                    System.out.println(Isum + E);
                } else System.out.println(Isum + F);
            } else if (A > C && B > C && D > C) {
                Isum += A + B + D;
                if (E > F) {
                    System.out.println(Isum + E);
                } else System.out.println(Isum + F);
            } else if (A > D && B > D && C > D) {
                Isum += A + B + C;
                if (E > F) {
                    System.out.println(Isum + E);
                } else System.out.println(Isum + F);
            } else {
                Isum += B + C + D;
                if (E > F) {
                    System.out.println(Isum + E);
                } else System.out.println(Isum + F);
            }
        }

	}

}
