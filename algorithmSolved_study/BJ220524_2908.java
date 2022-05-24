package algorithmSolved_study;
import java.util.*;
public class BJ220524_2908 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int a1 = A/100;
		int a2 = A%100/10;
		int a3 = A%10;
		int b1 = B/100;
		int b2 = B%100/10;
		int b3 = B%10;
		int Ar = a3*100 + a2*10 + a1;
		int Br = b3*100 + b2*10 + b1;
		if(Ar > Br)
			System.out.println(Ar);
		else
			System.out.println(Br);
	}
}

/*KGH
 
  import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		StringBuffer A = new StringBuffer(a);
		StringBuffer B = new StringBuffer(b);
		StringBuffer  ra = A.reverse();
		StringBuffer rb = B.reverse();
		String RA = ra.toString();
		String RB = rb.toString();
		int ia = Integer.parseInt(RA);
		int ib = Integer.parseInt(RB);
		int big = 0;
		if(ia>ib) {
			big = ia;
		}
		else {
			big = ib;
		}
		System.out.println(big);
			
		
		

		}
}	
 */
