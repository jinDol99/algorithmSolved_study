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
두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 
이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 
30, 60, 90등이 있으며, 최소 공배수는 30이다.
두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
*/