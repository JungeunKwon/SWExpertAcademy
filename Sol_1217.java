/*
 SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.

2 5 = 2 X 2 X 2 X 2 X 2 = 32

3 6 = 3 X 3 X 3 X 3 X 3 X 3 = 729

[제약 사항]

총 10개의 테스트 케이스가 주어진다.

결과 값은 Integer 범위를 넘어가지 않는다.
 
[입력]

각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 두 개의 숫자가 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
 */

import java.util.Scanner;

public class Sol_1217 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		for(int a=1;a<=10;a++) {
			int t=sc.nextInt();
			int base = sc.nextInt();
			int exp = sc.nextInt();
			int result = pow(base, exp);
			System.out.println("#"+a+" "+ result);
		}
	}

	private static int pow(int base, int exp) {
		if(exp == 1)
		{
			return base;
		}
		if(exp == 0)
		{
			return 1;
		}
		
		return base * pow(base, exp-1);
	}


	
	
	
}
