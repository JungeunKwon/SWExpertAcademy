/*
8*8 체스보드에 8개의 퀸을 서로 공격하지 못하게 놓는 문제는 잘 알려져 있는 문제이다.

퀸은 같은 행, 열, 또는 대각선 위에 있는 말을 공격할 수 있다. 이 문제의 한가지 정답은 아래 그림과 같다.
 



이 문제의 조금 더 일반화된 문제는 Franz Nauck이 1850년에 제기했다.

N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지가 있을까?

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 하나의 자연수 N(1 ≤ N ≤ 10)이 주어진다.


[출력]

각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */
import java.util.Scanner;

public class Sol_2806 {
	static int N;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int a=1;a<=T;a++) {
			N =sc.nextInt();
			cnt = 0;
			int [] arr = new int[N];
			findQueen(arr, 0);
			System.out.println("#"+a+" " + cnt);
		}
	}
	private static void findQueen(int[] arr, int depth) {
		if(depth == arr.length)
		{
			cnt ++;
			return;
		}
		for(int i = 0; i < N; i++)
		{
			arr[depth] = i;
			/*
			 *  arr[0]
			 *  arr[1] 이게 depth 값 이차원 배열에서 i 값이고
			 *  arr[2] 
			 *  arr[3]
			 *  i = 0 1 2 3  이게  각 depth 에서 좌표? 이차원 배열에서  j 라고 생각하기,
			 */
			if(isPromising(arr, depth)) //백트래킹, 
			{
				findQueen(arr, depth + 1);
			}
		}
	}
	private static boolean isPromising(int[] arr, int depth) {
		boolean flag = true;
		for(int i = 0; i < depth ; i++)
		{
			if(arr[i] == arr[depth])  
			{
				flag = false;
				break;
			}
			if(Math.abs(arr[depth] - arr[i]) == (depth - i)) {
				flag = false;
				break;
			}
		
		}
		
		return flag;
	}



}
