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
"OOXXOXXOOO"�� ���� OX������ ����� �ִ�. 
O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. 
������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. 
���� ���, 10�� ������ ������ 3�� �ȴ�.
"OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.
OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/