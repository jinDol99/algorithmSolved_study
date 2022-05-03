package algorithmSolved_study;
import java.util.*;
public class BJ220417_5532 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int L = s.nextInt();
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        int D = s.nextInt();
        if (L >= 2 && L <= 40 && 1 <= A && A <= 1000 && B >= 1 && B <= 1000 && C >= 1 && C <= 100 && D >= 1 && D <= 100) {
            for (int i = 1; i < L; i++) {
                B -= D;
                A -= C;
                if (A <= 0 && B <= 0) {
                    L -= i;
                    break;
                }
            }
            System.out.println(L);
        }
    }
}