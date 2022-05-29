package algorithmSolved_study;
import java.util.*;
public class BJ220529_1032 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
		char a = 63;
		String[] str = new String[cnt];
		for (int i = 0; i < str.length; i++)
			str[i] = s.next();
		for (int i = 1; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				if (str[0].charAt(j) == a)
					continue;
				if (str[0].charAt(j) != str[i].charAt(j))
					str[0] = str[0].substring(0,j) + a + str[0].substring(j+1);
			}
		}
		System.out.println(str[0]);
	}
}
/*
���� -> ���� -> cmd�� �ĺ���. ���� ȭ���� ���� ���δ�. 
���⼭ dir�̶�� ġ�� �� ���丮�� �ִ� ������丮�� ������ ��� ���´�. 
�̶� ���ϴ� ������ ã������ ������ ���� �ϸ� �ȴ�.
dir *.exe��� ġ�� Ȯ���ڰ� exe�� ������ �� ���´�. 
"dir ����"�� ���� ġ�� �� ���Ͽ� �´� ���ϸ� �˻� ����� ���´�. 
���� ���, dir a?b.exe��� �˻��ϸ� ���ϸ��� ù ��° ���ڰ� a�̰�, 
�� ��° ���ڰ� b�̰�, Ȯ���ڰ� exe�� ���� ��� ���´�. 
�̶� �� ��° ���ڴ� �ƹ��ų� ���͵� �ȴ�. ���� ���, 
acb.exe, aab.exe, apb.exe�� ���´�.
�� ������ �˻� ����� ���� �־����� ��, �������� �� �ľ� �� ����� ���������� 
����ϴ� �����̴�. ���Ͽ��� ���ĺ��� "." �׸��� "?"�� ���� �� �ִ�. 
�����ϸ� ?�� ���� ��� �Ѵ�. �� ���丮���� �˻� ����� ���� ���ϸ� �ִٰ� �����ϰ�, 
���� �̸��� ���̴� ��� ����.
*/