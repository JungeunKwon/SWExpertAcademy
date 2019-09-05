import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1861_SW {
	public static int N;
	public static int[] store;
	public static Queue<Info>q;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static int count;
	public static int arr[][];
	public static int max;
	public static int finalnum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a = 1; a<=T; a++)
		{
			q = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			StringTokenizer st;
			store = new int[(N * N) + 1];
			max = 0;
			finalnum = N + 1;
			for(int i = 0; i < N; i ++)
			{
				st =  new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					count = 0;
					q.offer(new Info(i, j, arr[i][j]));
					bfs();
					store[arr[i][j]] = count;
					if(count > max)
					{
						max = count;
					}
				}
			}
			for(int i = 1 ; i <= N*N; i++)
			{
				if(store[i] == max)
				{
					finalnum = i;
					break;
				}
			}
			System.out.println("#" + a + " " + finalnum + " " + max);
		}
	}
	private static void bfs() {
		int tx = 0, ty = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i ++)
			{
				Info temp = q.poll();
				for(int j = 0; j < 4; j ++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx<0 ||ty<0||tx>=N ||ty>=N) continue;
					if(arr[ty][tx] - 1 == temp.num)
					{
						if(store[arr[ty][tx]] != 0)
						{
							count  = count + store[arr[ty][tx]] + 1;
							return;
						}
						q.offer(new Info(ty,tx,arr[ty][tx]));	
					}
					
				}
			}
			count++;
		}
	}
	public static class Info{
		int i;
		int j;
		int num;
		Info(int i, int j, int num)
		{
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}

}
