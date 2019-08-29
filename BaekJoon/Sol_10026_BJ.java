import java.util.Scanner;

public class Sol_10026 {
	static int nyak;
	static int yak;
	static int dx[] = {0,0,-1,1}; //j
	static int dy[] = {-1,1,0,0}; //i
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int [][]arr = new int[N][N];
		int [][]yakarr = new int[N][N];
		for(int i = 0; i < N; i ++)
		{
			String line = sc.next();
			for(int j = 0 ; j < N; j ++)
			{
				switch(line.charAt(j))
				{
				case 'R': //빨강
					arr[i][j] = 1;
					yakarr[i][j] = 1;
					break;
				case 'B': //파랑
					arr[i][j] = 2;
					yakarr[i][j] = 2;
					break;
				case 'G': //초록
					arr[i][j] = 3;
					yakarr[i][j] = 1;
					break;
				}
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j= 0 ; j <N; j ++ )
			{
				if(arr[i][j] == 0 )
					continue;
				dfs(arr, i, j);
				nyak ++;
				
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j= 0 ; j <N; j ++ )
			{
				if(yakarr[i][j] == 0 )
					continue;
				dfs(yakarr,i,j);
				yak ++;
			}
		}
		System.out.println(nyak + " " + yak);
	}
	private static void dfs(int[][] arr, int y, int x) {
		int temp = arr[y][x];
		arr[y][x] = 0;
		int tx =0, ty =0;
		for(int i = 0; i < 4; i ++)
		{
			tx = x + dx[i];
			ty = y + dy[i];
			if(tx < 0 || ty < 0 || tx >= N || ty >= N)
				continue;
			if(arr[ty][tx] != 0 && temp == arr[ty][tx])
			{
				dfs(arr, ty, tx);
			}
		}
	}
}
