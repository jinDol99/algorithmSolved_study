package algorithmSolved_study;
import java.util.Scanner;
public class BJ220503_14681 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (;;) {
            int x = s.nextInt();
            int y = s.nextInt();
            if (x>=-1000 && x<=1000 && x!=0 && y>=-1000 && y<=1000 && y!=0) {
                if (x>0 && y>0) {
                    System.out.println("1");
                } else if (x<0 && y>0) {
                    System.out.println("2");
                } else if (x<0 && y<0) {
                    System.out.println("3");
                } else if (x>0 && y<0) {
                    System.out.println("4");
                }
                break;
            }
        }
    }
}