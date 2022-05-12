package algorithmSolved_study;
import java.util.*;
import java.io.*;
public class BJ220512_1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer spInput;
		int T=Integer.parseInt(input.readLine());
		int Max, Min, R, a, b;
		for (int i = 0; i < T; i++) {
			spInput = new StringTokenizer(input.readLine());
			a = Integer.parseInt(spInput.nextToken());
			b = Integer.parseInt(spInput.nextToken());
			if(a > b) {
				Max = a; Min = b;
			} else {
				Max = b; Min = a;
			}
			while(Max % Min != 0) {
				R=Max%Min;
				Max=Min; Min=R;
			}
			output.write((a*b)/Min + "\n");
		}
		output.flush();
		output.close();
	}
}
/*
�� �ڿ��� A�� B�� ���ؼ�, A�� ����̸鼭 B�� ����� �ڿ����� A�� B�� �������� �Ѵ�. 
�̷� ����� �߿��� ���� ���� ���� �ּҰ������� �Ѵ�. ���� ���, 6�� 15�� ������� 
30, 60, 90���� ������, �ּ� ������� 30�̴�.
�� �ڿ��� A�� B�� �־����� ��, A�� B�� �ּҰ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/