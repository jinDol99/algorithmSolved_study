package algorithmSolved_study;

import java.util.Scanner;

public class BJ220503_4153 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("ют╥б");
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int numa = a*a;
			int numb = b*b;
			int numc = c*c;
			
			if(a==0&&b==0&&c==0) {
				break;
			}
			if(numa+numb==numc) { 
				System.out.println("right");
			}
			else if(numa+numc==numb) {
				System.out.println("right");
			}
			else if(numb+numc==numa) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
			
		}

	}

}
