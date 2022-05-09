package algorithmSolved_study;
import java.util.Scanner;

public class BJ220510_17362 {
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);
        int finger = sc.nextInt() % 8;

        switch(finger){
            case 1:         System.out.println("1");
            break;
            case 2: case 0: System.out.println("2");
            break;
            case 3: case 7: System.out.println("3");
            break;
            case 4: case 6: System.out.println("4");
            break;
            case 5:         System.out.println("5");
            break;
        }
    }
}
/*					
   10  11 ...		그림과 같이 오른손을 기준으로 숫자를 세어나갈 때 
9   8  7  6			엄지 1, 검지 2, 중지 3, 약지 4, 소지 5, 약지 6,
1   2  3  4   5		중지 7, 검지 8, 엄지 9, 검지 10, ... 의 규칙으로					
   /\ /\ /\			계속 세어나갈 때 숫자 n을 입력했을 때 어떤 손가락이
   | || || | /\		해당되는지 출력하는 프로그램을 작성하시오.
⁄\ | || || || |		이 때, 출력값은 엄지, 검지, 중지, 약지, 소지 각각
\ \| || || || |		1, 2, 3, 4, 5로 출력하시오.
 \			  /
  \	손이에오 |		숫자에서 8을 나눈 나머지 값을 이용해 패턴을 찾음.
   \		 |		나머지 값이 1일 경우, 엄지(1)에 해당하며, 2 또는 0이면
   					검지(2), 3 또는 7일 경우 중지(3), 4 또는 6일 경우 약지(4),
					5일 경우 소지(5)임을 알 수 있음.
*/