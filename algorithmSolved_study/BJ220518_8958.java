package algorithmSolved_study;
import java.util.*;
public class BJ220518_8958 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int Try = s.nextInt();
		String[] que = new String[Try];
		for (int i = 0; i < Try; i++)
			que[i] = s.next();
		int[] score = new int[Try];
		int cnt=1;
		for (int i = 0; i < Try; i++) {
			for(int j = 0; j < que[i].length(); j++) {
				if (que[i].charAt(j) == 88)
					cnt = 1;
				if (que[i].charAt(j) == 79) {
					score[i] += cnt; cnt++;
				}
			}
			cnt = 1;
		}
		for (int i = 0; i < Try; i++)
			System.out.println(score[i]);
	}
}
/*
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 
예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
*/