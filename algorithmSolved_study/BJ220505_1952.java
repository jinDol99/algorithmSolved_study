package algorithmSolved_study;
import java.util.*;
public class BJ220505_1952 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();
        int sum = 0;
        if (M >= 2 && M <= 100 && N >= 2 && N <= 100) {
            if (M <= N) {
                sum += M+(M-2);
            } else {
                sum += N+(N-1);
            }
        }
        System.out.println(sum);
    }
}