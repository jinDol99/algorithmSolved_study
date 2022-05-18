package algorithmSolved_study;
import java.util.*;
public class BJ220518_1157 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String StrUp = str.toUpperCase();
		int[] sarr = new int[StrUp.length()];
		int[] alp = new int[26];
		for (int i = 0; i < StrUp.length(); i++) {
			sarr[i] = StrUp.charAt(i);
		}
		for (int i = 65; i <= 90; i++) {
			for (int j = 0; j < StrUp.length(); j++) {
				if (sarr[j] == i) {
					alp[i-65] += 1;
				}
			}
		}
		int rec = 0;
		int cnt = 0;
		int equ = 0;
		for (int i = 0; i < alp.length; i++) {
			if (alp[i] > rec) {
				rec = alp[i];
				cnt = i;
			}
		}
		for (int i = 0; i < alp.length; i++) {
			if (rec == alp[i])
				equ++;
		}
		if (equ > 1)
			System.out.println("?");
		else
			System.out.println((char)(cnt+65));
	}
}
/*
알파벳 대소문자로 된 단어가 주어지면, 
이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
단, 대문자와 소문자를 구분하지 않는다.
*/