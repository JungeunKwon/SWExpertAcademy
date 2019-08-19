import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2178 {
	public static int N;
	public static int M;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,1,-1};
	public static int min;
	public static int count;
	public static Queue<Info> q;
	public static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N + 1][M + 1];
		visited = new boolean[N+1][M+1];
		min = Integer.MAX_VALUE;
		count = 1;
		q = new LinkedList<>();
		for(int i = 1; i <= N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			//int k =0;
			for(int j = 1, k = 0; j <= M; j++, k++)
			{
				arr[i][j] = line.charAt(k) - '0';
				
			}
		}
		q.offer(new Info(1,1));
		bfs(arr);
		System.out.println(min + 1);
	}
	private static void bfs(int[][] arr) {
		int tx = 0,  ty = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i =0; i < size; i++)
			{
				Info temp = q.poll();
				visited[temp.i][temp.j] = true;
				for(int j = 0; j < 4; j++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx <1 || ty <1 || tx > M|| ty>N)
					{
						continue;
					}
					if(arr[ty][tx] == 1 && !visited[ty][tx])
					{
						visited[ty][tx] = true;
						q.offer(new Info(ty,tx));
					}
					if(ty == N && tx == M)
					{
						if(min > count)
							min = count;
						break;
					}
				}
			}
			count ++;
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
