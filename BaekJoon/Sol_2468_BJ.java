import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2468 {
	public static int N;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int max;
	public static Queue<Info> q	;
	public static boolean visited[][];
	public static int Range;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		int inputmax = Integer.MIN_VALUE;
		for(int i = 0; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > inputmax)
				{
					inputmax = arr[i][j];
				}
			}
		}
		visited = new boolean[N][N];
		q = new LinkedList<>();
		Range = 0;
		max = Integer.MIN_VALUE;
		while(Range < inputmax)
		{
			int count = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j ++)
				{
					if(arr[i][j] > Range && !visited[i][j])
					{
						q.offer(new Info(i, j));
						bfs(arr);
						count ++;
					}
					
				}
			}
			if(max < count)
			{
				max = count;
			}
			visited = new boolean[N][N];
			Range ++;
		
		}
		System.out.println(max);
		
	}
	private static void bfs(int[][] arr) {
		int tx =0, ty = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				Info temp = q.poll();
				for(int j = 0; j < 4 ; j ++)
				{
					tx = dx[j] + temp.j;
					ty = dy[j] + temp.i;
					if(tx < 0 || ty < 0 || tx>=N ||ty>=N)continue;
					if(arr[ty][tx] > Range && !visited[ty][tx])
					{
						q.offer(new Info(ty, tx));
						visited[ty][tx] = true;
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
