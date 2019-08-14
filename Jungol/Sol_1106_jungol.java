/*
N×M장기판에 졸 한개와 말 한개가 놓여 있다. 말의 이동 방향이 다음과 같다고 할 때, 말이 최소의 이동횟수로 졸을 잡으려고 한다. 
말이 졸을 잡기 위한 최소 이동 횟수를 구하는 프로그램을 작성해보자.

첫 줄은 장기판 행의 수(N)와 열의 수(M)를 받는다.(1≤N, M≤100)
둘째 줄은 말이 있는 위치의 행(R), 열(C)의 수와 졸이 있는 위치의 행(S), 열(K)의 수를 입력받는다. 
단, 장기판의 제일 왼쪽 위의 위치가 (1,1)이다.
각 행과 열은 R(1≤R≤N), C(1≤C≤M), S(1≤S≤N), K(1≤K≤M)이다.

말이 졸을 잡기 위한 최소 이동 횟수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1106_jungol {
	public static int N;
	public static int M;
	public static Queue<Info> q;
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,1,-1};
	public static int dxx[] = {-1,1,-1,1};
	public static int dyy[] = {-1,-1,1,1};
	public static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		int arr[][] = new int[N+1][M+1];
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr[R][C] = 1;
		q.offer(new Info(R,C));
		arr[S][K] = 2;
		bfs(arr);
	}
	private static void bfs(int[][] arr) {
		int tx = 0 , ty = 0;
		int txx = 0, tyy = 0;
		count = 1;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				Info temp = q.poll();
				for(int j = 0 ; j < 4 ; j++)
				{
					tx = dx[j] + temp.j;
					ty = dy[j] + temp.i;
					if(tx < 1 ||ty < 1 || tx >= M+1 || ty >= N+1)
						continue;
					if(arr[ty][tx] == 2)
					{
						System.out.println(count);
						return;
					}
					for(int k = 0; k < 4; k++)
					{
						txx = tx + dxx[k];
						tyy = ty + dyy[k];
						if(txx < 1 ||tyy < 1 || txx >= M+1 || tyy >= N+1)
							continue;
						if(arr[tyy][txx] == 2)
						{
							System.out.println(count);
							return;
						}
						if(arr[tyy][txx] == 0)
						{
							arr[tyy][txx] = 1;
							q.offer(new Info(tyy,txx));
						}
					}
				}
			}count ++;
			
		}
	}
	public static class Info{
		int i;
		int j;
		Info(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
}
