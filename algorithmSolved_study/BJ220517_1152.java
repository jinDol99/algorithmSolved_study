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
���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������? 
�̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.
*/