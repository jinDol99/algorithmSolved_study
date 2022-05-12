package algorithmSolved_study;
import java.util.*;
public class BJ220512_2309 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] allNan = new int[9];
		int sum = 0;
        int a=0;
        int b=0;
		for (int i = 0; i < 9; i++) {
			allNan[i] = s.nextInt();
			sum += allNan[i];
		}
		Arrays.sort(allNan);
		sum -= 100;
        finish:
		for (int i=0; i<8; i++) {
			for (int j=i+1; j<9; j++) {
				if (allNan[i] + allNan[j] == sum) {
                    a=i;
                    b=j;
                    break finish;
				}
			}
		}
        for (int k = 0; k < 9; k++) {
		    if(k == a || k == b) {
				continue;
            }
			System.out.println(allNan[k]);
		}
	}
}
/*
�պ� ���� �ϰ� �����̵�� �Բ� ��ȭ�Ӱ� ��Ȱ�ϰ� �ִ� �鼳���ֿ��� ���Ⱑ ã�ƿԴ�. 
�ϰ��� ��ġ�� ���ƿ� �����̰� �ϰ� ���� �ƴ� ��ȩ ���̾��� ���̴�.
��ȩ ���� �����̴� ��� �ڽ��� "�鼳 ���ֿ� �ϰ� ������"�� ���ΰ��̶�� �����ߴ�. 
�پ ������ �������� ������ �ִ� �鼳���ִ�, ���ེ���Ե� �ϰ� �������� Ű�� ���� 
100�� ���� ����� �´�.
��ȩ �������� Ű�� �־����� ��, �鼳���ָ� ���� �ϰ� �����̸� ã�� ���α׷��� �ۼ��Ͻÿ�.
*/