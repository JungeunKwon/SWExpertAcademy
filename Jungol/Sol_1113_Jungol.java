import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1113_Jungol {
	public static int M;
	public static int N;
	public static int arr[][];
	public static int disti;
	public static int distj;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,-1,1}; //¿À, ¿Þ, À§, ¾Æ·¡
	public static Queue<Info> q;
	public static int min;
	public static boolean visited[][];
	public static int memo[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		memo = new int[M][N];
		visited = new boolean[M][N];
		st = new StringTokenizer(br.readLine());
		disti = Integer.parseInt(st.nextToken());
		distj = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		min = Integer.MAX_VALUE;
		for(int i = 0; i < M; i ++)
		{
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q.offer(new Info(0, 0, 4, 0));
		bfs();
		System.out.println(memo[disti][distj] - 1);
	}
	private static void bfs() {
		int tx = 0, ty =0;
		while(!q.isEmpty())
		{
			Info temp = q.poll();
			for(int i = 0; i < 4; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
				if(arr[ty][tx] == 0) continue;
				if(temp.dir != i)
				{
					if(memo[ty][tx] >= temp.count + 1)
					{
						memo[ty][tx] = temp.count + 1;
						q.offer(new Info(ty, tx, i, temp.count + 1));
					}
				}else
				{
					if(memo[ty][tx] >= temp.count)
					{
						memo[ty][tx] = temp.count;
						q.offer(new Info(ty, tx, temp.dir, temp.count));
					}
					
				}
			}
			
		}
	}
	public static class Info{
		int i;
		int j;
		int dir;
		int count;
		Info(int i, int j, int dir, int count)
		{
			this.i = i;
			this.j = j;
			this.dir = dir;
			this.count = count;
		}
	}
}
