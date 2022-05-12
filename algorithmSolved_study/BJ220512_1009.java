package algorithmSolved_study;
import java.util.*;
public class BJ220512_1009 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] com = new int[T];
		for (int i = 0; i < T; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int task=1;
			for (int j=0; j < b; j++) {
				task *= a;
				task %= 10;
				if (task==0)
					task=10;
			}
			com[i] = task;
		}
		for (int i : com)
			System.out.println(i);
	}
}
/*
����̴� �ֽ� ��ǻ�� 10�븦 ������ �ִ�. ��� �� ����̴� ���� �����͸� ó���ؾ� �� ���� ���ܼ� 
�� ��ǻ�Ϳ� 1������ 10�������� ��ȣ�� �ο��ϰ�, 10���� ��ǻ�Ͱ� ������ ���� ������� 
�����͵��� ó���ϱ�� �Ͽ���.
1�� �����ʹ� 1�� ��ǻ��, 2�� �����ʹ� 2�� ��ǻ��, 3�� �����ʹ� 3�� ��ǻ��, ... ,
10�� �����ʹ� 10�� ��ǻ��, 11�� �����ʹ� 1�� ��ǻ��, 12�� �����ʹ� 2�� ��ǻ��, ...
�� �������� ������ �׻� a�� b���� ���� ���·� �־�����. 
����̴� ���� ������ �����Ͱ� ó���� ��ǻ���� ��ȣ�� �ñ�������. 
�̸� �������ִ� ���α׷��� �ۼ��϶�.
*/