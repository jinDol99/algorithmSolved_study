package algorithmSolved_study;
import java.util.*;
public class BJ220517_1152 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int count = 0;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == 32)
				count++;
		}
		if (str.charAt(0) != 32) count++;
		System.out.println(count);
	}
}
/*
영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 
이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
*/