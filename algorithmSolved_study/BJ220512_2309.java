package algorithmSolved_study;
import java.util.*;
public class BJ220512_2309 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] allNan = new int[9]; // 모든 난쟁이들 키 배열
		int sum = 0; // 난쟁이들의 키의 합
        int a=0; // 가짜 난쟁이1
        int b=0; // 가짜 난쟁이2
		for (int i = 0; i < 9; i++) { 
			allNan[i] = s.nextInt(); // 모든 난쟁이들의 키 입력
			sum += allNan[i]; // 입력된 난쟁이들의 키 전부 더하기
		}
		Arrays.sort(allNan); // 오름차순으로 정렬
		sum -= 100; // 전체 키에 100을 빼서 가짜 난쟁이 2명의 키의 합
        finish: // 반복을 끝내기 위한 finish
		for (int i=0; i<8; i++) { // 0~7까지
			for (int j=i+1; j<9; j++) { // 1~8까지
				if (allNan[i] + allNan[j] == sum) {
					// 두 난쟁이 키의 합이 가짜 난쟁이들의 키의 합과 같을 경우
                    a=i; // 가짜 난쟁이1의 위치 저장
                    b=j; // 가짜 난쟁이2의 위치 저장
                    break finish; // 모든 반복 종료
				}
			}
		}
        for (int k = 0; k < 9; k++) {
		    if(k == a || k == b) { // 가짜 난쟁이1과 가짜 난쟁이2 스킵
				continue;
            }
			System.out.println(allNan[k]); // 진짜 일곱 난쟁이 출력
		}
	}
}
/*
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 
100이 됨을 기억해 냈다.
아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
*/