import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_4485_BJ {
	public static int dx[] = {0,-1,0,1};
	public static int dy[] = {1,0,-1,0};
	public static int memo[][];
	public static int arr[][];
	public static Queue<Info> q;
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			if(N==0)return;
			arr = new int[N][N];
			memo = new int[N][N];
			q= new LinkedList<>();
			for(int i = 0; i < N; i ++)
			{
				st = new StringTokenizer(br.readLine());
				Arrays.fill(memo[i], -1);
				for(int j = 0; j < N; j ++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			q.offer(new Info(0, 0));
			bfs();						
			System.out.println("Problem "+ a+ ": " + memo[N-1][N-1]);
			a++;
		}
	}
	private static void bfs() {
		int tx = 0, ty = 0;
		memo[0][0] = arr[0][0];
		while(!q.isEmpty()) {
			Info temp = q.poll();
			
			for(int i =0; i < 4; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(tx <0 || ty <0 || tx>=N ||ty>=N)continue;
				int result = arr[ty][tx] + memo[temp.i][temp.j];
				if(memo[ty][tx] == -1)
				{
					memo[ty][tx] =result;
					q.offer(new Info(ty, tx));
				}else
				{
					if(memo[ty][tx] > result)
					{
						memo[ty][tx] = result;
						q.offer(new Info(ty, tx));
					}
				}
			
			}
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
