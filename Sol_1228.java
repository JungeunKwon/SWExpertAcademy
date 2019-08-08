/*
 * 0 ~ 999999 사이의 수를 나열하여 만든 암호문이 있다.

암호문을 급히 수정해야 할 일이 발생했는데, 이 암호문은 특수 제작된 처리기로만 수정이 가능하다.

이 처리기는 다음과 같이 1개의 기능을 제공한다.

1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]

위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

[입력]

첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)

두 번째 줄 : 원본 암호문

세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)

네 번째 줄 : 명령어

위와 같은 네 줄이 한 개의 테스트 케이스이며, 총 10개의 테스트 케이스가 주어진다.

[출력]

#기호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 수정된 암호문의 처음 10개 항을 출력한다.
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Sol_1228 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//int T = sc.nextInt();
		
		for(int a=1;a<=10;a++) {
			int length =sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for(int i =0 ; i < length; i++)
			{
				list.add(sc.nextInt());
			}
			int N = sc.nextInt();
			for(int i = 0 ; i < N; i++)
			{
				char op = sc.next().toCharArray()[0];
				int position = sc.nextInt();
				int num = sc.nextInt();
				for(int j = position; j<position+num; j++)
				{
					list.add(j, sc.nextInt());
				}
			}
			
			System.out.print("#" +  a + " ");
			for(int i = 0 ; i <10; i++)
			{
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
