package algorithmSolved_study;
import java.io.*;
import java.util.*;
public class BJ220510_15552 {
	public static void main(String[] args) throws IOException { // throws IOException: ���� �߻� ����
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // Scanner scan ����
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out)); // System.out.print() ����
		StringTokenizer spInput; // read.Line() �Է��ϸ� Line �����θ� �������⿡ ��������� �Է��ҷ��� ���
		int T = Integer.parseInt(input.readLine());
		// T�� ����(���ڷ� ����ȯ��) �Է�
		for (int i = 0; i < T; i++) {
			spInput = new StringTokenizer(input.readLine()); // scan = new Scanner(System.in) ����
			output.write((Integer.parseInt(spInput.nextToken()) + Integer.parseInt(spInput.nextToken())) + "\n");
			// .write �ɼ��� ���ۿ� �ִ� ���� ��� ����ϴ� ����
			// ���� ������ �Է��ϴ� �� ���� ���� ����ϰ� �⺻ �ٳѱ��� ��� \n�� �ٿ��� �ٳѱ�
		}
		output.close(); 
		// .wirte �ɼ��� �������� ������ �� �ڿ� .close �ɼ��� �������� ��
	}
}
/*
���������� for�� ������ Ǯ�� ���� �����ؾ� �� ���� �ִ�. 
����� ����� ������ ���� ���� �Է¹ްų� ����� �� �ð��ʰ��� �� �� �ִٴ� ���̴�.
C++�� ����ϰ� �ְ� cin/cout�� ����ϰ��� �Ѵٸ�, cin.tie(NULL)�� 
sync_with_stdio(false)�� �� �� ������ �ְ�, endl ��� ���๮��(\n)�� ����. 
��, �̷��� �ϸ� �� �̻� scanf/printf/puts/getchar/putchar �� 
C�� ����� ����� ����ϸ� �� �ȴ�.
Java�� ����ϰ� �ִٸ�, Scanner�� System.out.println ��� 
BufferedReader�� BufferedWriter�� ����� �� �ִ�. 
BufferedWriter.flush�� �� �������� �� ���� �ϸ� �ȴ�.
Python�� ����ϰ� �ִٸ�, input ��� sys.stdin.readline�� ����� �� �ִ�. 
��, �̶��� �� ���� ���๮�ڱ��� ���� �Է¹ޱ� ������ ���ڿ��� �����ϰ� ���� ��� 
.rstrip()�� �߰��� �� �ִ� ���� ����.
���� �Է°� ��� ��Ʈ���� �����̹Ƿ�, �׽�Ʈ���̽��� 
���� �Է¹޾Ƽ� ������ �� ���� ����� �ʿ�� ����. 
�׽�Ʈ���̽��� �ϳ� ���� �� �ϳ� ����ص� �ȴ�.
�ڼ��� ���� �� �ٸ� ����� ���� �� �ۿ� ����Ǿ� �ִ�.
�� ��α� �ۿ��� BOJ�� ��Ÿ ���� ���� ���� �� �� �ִ�.
*/