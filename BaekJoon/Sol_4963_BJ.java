import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_4963_BJ {
	public static int N;
	public static int M;
	public static int dx[] = {-1,1,0,0,-1,1,-1,1};
	public static int dy[] = {0,0,-1,1,-1,1,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			int[][] arr = new int[N][M];
			boolean visited[][] = new boolean[N][M];
			for(int i = 0; i < N; i++)
			{
				st  = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(arr[i][j] == 1 && !visited[i][j])
					{
						dfs(arr, visited,i,j);
						count ++;
					}
				}
			}
			System.out.println(count);
		}
	}
	private static void dfs(int[][] arr, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		int tx = 0, ty = 0;
		for(int k = 0; k < 8; k++)
		{
			tx = j + dx[k];
			ty = i + dy[k];
			if(tx <0 || ty <0 || tx>=M || ty>=N ) continue;
			if(arr[ty][tx] == 1 && !visited[ty][tx])
			{	
				visited[ty][tx] = true;
				dfs(arr,visited,ty,tx);
			}
		}
	}

}
