package algorithmSolved_study;
import java.util.*;
public class BJ220511_2609 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt(); // ù��° �ڿ���
		int B = s.nextInt(); // �ι�° �ڿ���
		int maxNum = 0; // �ִ� ������� ���ϱ� ���� ������� �Է��ϴ� ����
		for (int i = 1; i <= A; i++) { 
			/* ū �ڿ����� ���� �ڿ����� ��� �ڿ����� �Ѿ�� ���̻� ������� �ƴϴ�
			   ��� �ڿ��� ������ ��� �������*/
			if (A % i == 0 && B % i ==0) { // i������ �� �ڿ��� ��� �������� ���
				maxNum=i; // �� ���� �����(�ݺ��ϸ鼭 ���� Ŀ��)
			}
		}
		System.out.println(maxNum); // �ִ� ����� ���
		for (int i = A; i <= A*B; i++) {
			/* �۵� ũ�� ū �ڿ������� �ּҰ������ �� �� �־ �׸��� �� ���� ������� ����
			   ���� �� �ּ� ������� �� �ڿ����� ���� ��*/
			if (i % A == 0 && i % B == 0) { // 
				System.out.println(i);
				break;
			}
		}
	}
}
/*
�� ���� �ڿ����� �Է¹޾� �ִ� ������� �ּ� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/