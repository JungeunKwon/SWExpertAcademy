import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_14502_BJ {
	public static int N;
	public static int M;
	public static int arr[][];
	public static int max;
	public static boolean visited[][];
	public static Queue<Info> q;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,-1,1};
	static int[][] temparr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		max = Integer.MIN_VALUE;
		List<Info>  list = new ArrayList<>();
		Info[] combilist = new Info[3];
		q = new LinkedList<>();

		for(int i = 0; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0)
				{
					list.add(new Info(i, j));
				}
					
			}
		}
		
		combi(list, combilist, 3, list.size());
		System.out.println(max);
	}
	private static void combi(List<Info> list, Info[] combilist, int r, int n) {
		if(r == 0)
		{

			visited = new boolean[N][M];
			temparr = new int[N][M];
			for(int i = 0; i < N ; i++)
			{
				System.arraycopy(arr[i], 0, temparr[i], 0, arr[i].length);
			}
			
			for(int i = 0; i < combilist.length; i ++)
			{
				temparr[combilist[i].i][combilist[i].j] = 1;
			}
			for(int i = 0; i < N; i ++)
			{
				for(int j = 0; j <M;j++)
				{
					if(visited[i][j]) continue;
					if(temparr[i][j] == 2)
					{
						visited[i][j] = true;
						q.offer(new Info(i, j));
						bfs(combilist);
					}				
				}
			}
			int count =0; 
			for(int i = 0; i < N; i ++)
			{
				for(int j = 0; j <M;j++)
				{
					if(temparr[i][j] == 0)
					{
						count ++;
					}
				}
			}
		
			if(max < count)
				max = count;
		
			return;
		}
		if(r > n)return;
		combilist[r-1] = list.get(n-1);
		combi(list, combilist, r-1, n-1);
		combi(list, combilist, r, n-1);
		
	}
	private static void bfs( Info[] combilist) {
		int tx = 0, ty = 0;
	
		while(!q.isEmpty())
		{
			
			Info temp = q.poll();
			for(int i = 0; i < 4; i ++)
			{
				tx =temp.j + dx[i];
				ty = temp.i + dy[i];
				if(ty<0 || tx <0 || tx>=M ||ty>=N) continue;
				if(visited[ty][tx]) continue;
				if(temparr[ty][tx] == 0)
				{
					temparr[ty][tx] = 2;
					visited[ty][tx] =true;
					q.offer(new Info(ty, tx));
				}
			}			
		
		}
	}
	public static class Info
	{
		int i;
		int j;
		Info(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "Info [i=" + i + ", j=" + j + "]";
		}
	}

}
