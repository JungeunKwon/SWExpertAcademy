import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_7569 {
	public static int M;
	public static int N;
	public static int H;
	public static Queue<Info> q;
	public static int daycount;
	public static int dk[] = {1,-1,0,0,0,0};
	public static int dy[] = {0,0,-1,1,0,0};
	public static int dx[] = {0,0,0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int arr[][][] = new int[H][N][M];
		q = new LinkedList<Info>();
	
		for(int k = 0; k < H; k++)
		{
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j <M; j++)
				{
					int temp  = Integer.parseInt(st.nextToken());
					arr[k][i][j] = temp;
					if(temp == 1)
					{
						Info info = new Info(k,i, j);
						q.offer(info);
					}
				}
			}
		}
		bfs(arr);
		int zerocount = 0;
		for(int k = 0; k < H; k++)
		{
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j <M; j++)
				{					
					if(arr[k][i][j] == 0)
					{
						zerocount++;
						break;
					}
				}
			}
		}
		if(zerocount > 0)
		{
			System.out.println(-1);
		}else
			System.out.println(daycount - 1);
		q.clear();
	}
	private static void bfs(int[][][] arr) {
		daycount = 0;
		int tk = 0 ,tx = 0, ty = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				Info temp = q.poll();
				tk = 0; tx = 0;  ty = 0;
				for(int j = 0; j < 6 ; j++)
				{
					tk = temp.k + dk[j];
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tk < 0 || ty< 0|| tx <0|| tk >= H || ty >= N || tx >= M)
						continue;
					if(arr[tk][ty][tx] == 0)
					{
						arr[tk][ty][tx] = 1;
						Info newInfo = new Info(tk, ty, tx);
						q.offer(newInfo);						
					}
				}
			}
			daycount ++;
		}
	}
	public static class Info{
		int k;
		int i;
		int j;

		Info(int k, int i, int j)
		{
			this.k = k;
			this.i = i;
			this.j = j;
		}
	}

}
