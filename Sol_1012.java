import java.util.Scanner;

public class Sol_1012 {
	static int count;
	static int dx[] = {1,-1,0,0}; //j
	static int dy[] = {0,0,-1,1}; //i
	static int M;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int a = 1; a <=T; a ++)
		{
			M = sc.nextInt();
			N = sc.nextInt();
			int arr[][] = new int[N][M];
			int num = sc.nextInt();
			count = 0;
			for(int k = 0 ; k < num; k++)
			{
				int j = sc.nextInt();
				int i = sc.nextInt();
				arr[i][j] = 1;
			}
			for(int i = 0 ; i < N; i ++)
			{
				for(int j = 0 ; j  < M; j++)
				{
					if(arr[i][j] == 1)
					{
						dfs(arr, i,j);
						count ++;
					}
				}
			}
			System.out.println(count);
		}
	}
	private static void dfs(int[][] arr, int y, int x) {
		int tx = 0 , ty = 0;
		arr[y][x] = 0;
		for(int i = 0;  i < 4; i++)
		{
			tx = x + dx[i];
			ty = y + dy[i];
			if(tx < 0 || ty < 0 || tx >= M || ty >= N)
				continue;

			 if(arr[ty][tx] == 1) 
				 dfs(arr,ty,tx);
		}
	}
}
