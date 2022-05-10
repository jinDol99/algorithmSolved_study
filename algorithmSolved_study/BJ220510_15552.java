package algorithmSolved_study;
import java.io.*;
import java.util.*;
public class BJ220510_15552 {
	public static void main(String[] args) throws IOException { // throws IOException: 예외 발생 막음
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // Scanner scan 역할
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out)); // System.out.print() 역할
		StringTokenizer spInput; // read.Line() 입력하면 Line 단위로만 나눠지기에 공백단위로 입력할려고 사용
		int T = Integer.parseInt(input.readLine());
		// T에 문자(숫자로 형변환됨) 입력
		for (int i = 0; i < T; i++) {
			spInput = new StringTokenizer(input.readLine()); // scan = new Scanner(System.in) 역할
			output.write((Integer.parseInt(spInput.nextToken()) + Integer.parseInt(spInput.nextToken())) + "\n");
			// .write 옵션은 버퍼에 있는 값을 모두 출력하는 역할
			// 공백 단위로 입력하는 두 값의 합을 출력하고 기본 줄넘김이 없어서 \n을 붙여서 줄넘김
		}
		output.close(); 
		// .wirte 옵션을 썼을때는 무조건 그 뒤에 .close 옵션을 사용해줘야 함
	}
}
/*
본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 
입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.
C++을 사용하고 있고 cin/cout을 사용하고자 한다면, cin.tie(NULL)과 
sync_with_stdio(false)를 둘 다 적용해 주고, endl 대신 개행문자(\n)를 쓰자. 
단, 이렇게 하면 더 이상 scanf/printf/puts/getchar/putchar 등 
C의 입출력 방식을 사용하면 안 된다.
Java를 사용하고 있다면, Scanner와 System.out.println 대신 
BufferedReader와 BufferedWriter를 사용할 수 있다. 
BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 
단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 
.rstrip()을 추가로 해 주는 것이 좋다.
또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 
전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 
테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
자세한 설명 및 다른 언어의 경우는 이 글에 설명되어 있다.
이 블로그 글에서 BOJ의 기타 여러 가지 팁을 볼 수 있다.
*/