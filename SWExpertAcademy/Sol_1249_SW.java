import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;

public class Sol_1249_SW {

	public static int N;
	public static int arr[][];
	public static int memo[][];
	public static int endx;
	public static int endy;
	public static Queue<Info> q;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1 ; a <=T ; a++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			memo = new int[N][N];
			endx = N - 1;
			endy = N - 1;
			q = new LinkedList<>();
			String st;
			for(int i = 0; i < N; i  ++)
			{
				st = br.readLine();
				for(int j = 0; j < N; j ++)
				{
					arr[i][j] = st.charAt(j) - '0';
					if(i==0 && j==0)
					{
						memo[i][j] = 0;
					}else
					{
						memo[i][j] = -1;
					}
				}
			}
			
			q.offer(new Info(0,0));
			bfs();
			System.out.println("#" +  a +  " "  + memo[N-1][N-1]);
			}
	}
	private static void bfs() {
		int tx = 0, ty = 0;
		while(!q.isEmpty())
		{
			Info temp = q.poll();
			for(int i = 0; i <4 ; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(tx< 0 || ty<0 || tx>=N || ty>=N)continue;
				if(memo[ty][tx] == -1 )
				{
					memo[ty][tx] = memo[temp.i][temp.j] + arr[ty][tx];
					q.offer(new Info(ty, tx));
				}else
				{
					int tempresult = memo[temp.i][temp.j] + arr[ty][tx];
					if(memo[ty][tx] > tempresult)
					{
						memo[ty][tx] = tempresult;
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
