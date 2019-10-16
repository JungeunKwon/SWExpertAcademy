import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1261_BJ {
	public static int N;
	public static int M;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static int arr[][];
	public static int memo[][];
	public static Queue<Info> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //j
		M = Integer.parseInt(st.nextToken()); //i
		arr = new int[M ][N ];
		memo = new int[M][N];
		q = new LinkedList<>();
		String line;
		for(int i = 0; i < M; i++)
		{
			line = br.readLine();
			for(int j = 0; j < N; j ++)
			{
				arr[i][j] = line.charAt(j) - '0';
				memo[i][j] = -1;
			}
		}
		memo[0][0] = 0;
		q.offer(new Info(0, 0));
		bfs();
		System.out.println(memo[M - 1][N - 1]);
		
	}
	private static void bfs() {
		int tx = 0, ty =0;
		while(!q.isEmpty())
		{
			Info temp = q.poll();
			for(int i  = 0; i < 4; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(tx < 0 || ty <0 || tx>= N ||ty>=M) continue;
				
				if(memo[ty][tx] == -1)
				{
					memo[ty][tx] = memo[temp.i][temp.j] + arr[ty][tx];
					q.offer(new Info(ty, tx));
					
				}else
				{
					int result = memo[temp.i][temp.j] + arr[ty][tx];
					if(result < memo[ty][tx])
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
