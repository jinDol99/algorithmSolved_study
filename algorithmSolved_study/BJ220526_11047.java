package algorithmSolved_study;
import java.util.*;
public class BJ220526_11047 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		int[] arr = new int[N];
		int cnt = 0; // �ʿ��� ������ ���� ����
		for (int i = 0; i < arr.length; i++) // ���� �Է�
			arr[i] = s.nextInt();
		for (int i = arr.length-1; i >= 0; i--) {
			if (K-arr[i] < 0)
				continue; // �־��� ���ݺ��� ������ �� ��θ� ��ŵ
			if (K-arr[i] >= 0)
				while (K-arr[i] >= 0) { // �־��� ���ݺ��� ������ �� ���
					K -= arr[i];
					cnt++;
				}
		}
		System.out.println(cnt);
	}
}
/*
�ر԰� ������ �ִ� ������ �� N�����̰�, ������ ������ �ſ� ���� ������ �ִ�.
������ ������ ����ؼ� �� ��ġ�� ���� K�� ������� �Ѵ�.
�̶� �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/