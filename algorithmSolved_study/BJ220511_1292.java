package algorithmSolved_study;
import java.util.*;
public class BJ220511_1292 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt(); // 시작 정수 입력
		int B = s.nextInt(); // 끝 정수 입력
		int[] arr = new int[B]; // 끝 정수에 맞게 배열 설정
		int cnt = 0; // 같은 숫자를 일정 횟수 출력하기 위한 변수
		int a = 1; // 현재 입력되고 있는 숫자를 나타내는 변수
		int sum=0; // 일정 구간의 더해진 값을 나타내는 변수
		for (int i = 0; i < B; i++) { // 끝 정수 횟수만큼 반복
			arr[i] = a; // 처음엔 1이 입력
			cnt++; // 카운트 1 증가
			if (a == cnt) { // 입력되는 숫자와 카운트가 동일해지면
				a++; cnt=0; // 입력 숫자는 1 늘리고 카운트는 0으로
			}
			if (i >= A-1) { // A번째에 해당하는 순서부터는
				sum += arr[i]; // 합에 다 더해줌
			}
		}
		System.out.println(sum);
	}
}
/*
동호는 내년에 초등학교를 입학한다. 그래서 동호 어머니는 수학 선행 학습을 위해 쉽게 푸는 
문제를 동호에게 주었다.
이 문제는 다음과 같다. 1을 한 번, 2를 두 번, 3을 세 번, 
이런 식으로 1 2 2 3 3 3 4 4 4 4 5 .. 이러한 수열을 만들고 어느 일정한 
구간을 주면 그 구간의 합을 구하는 것이다.
하지만 동호는 현재 더 어려운 문제를 푸느라 바쁘기에 우리가 동호를 도와주자
*/