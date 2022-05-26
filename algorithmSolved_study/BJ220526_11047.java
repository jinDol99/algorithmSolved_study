package algorithmSolved_study;
import java.util.*;
public class BJ220526_11047 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		int[] arr = new int[N];
		int cnt = 0; // 필요한 동전의 최저 갯수
		for (int i = 0; i < arr.length; i++) // 동전 입력
			arr[i] = s.nextInt();
		for (int i = arr.length-1; i >= 0; i--) {
			if (K-arr[i] < 0)
				continue; // 주어진 가격보다 동전이 더 비싸면 스킵
			if (K-arr[i] >= 0)
				while (K-arr[i] >= 0) { // 주어진 가격보다 동전이 덜 비쌈
					K -= arr[i];
					cnt++;
				}
		}
		System.out.println(cnt);
	}
}
/*
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
*/