import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Sol_1258_SW {
	public static Queue<Info> q;
	public static int dx[] = {0,1};
	public static int dy[] = {1,0};
	public static int N;
	public static LinkedList<Info> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1 ; a<=T; a++)
		{
			N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N + 1][N + 1];
			list = new LinkedList<>();
			StringTokenizer st;
			q = new LinkedList<>();
			for(int i = 1; i <= N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1 ; j <= N ; j ++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 1; i <= N; i++)
			{
				for(int j = 1; j <= N; j ++ )
				{
					if(arr[i][j] != 0)
					{
						q.offer(new Info(i, j));
						bfs(arr);
						count++;
					}
				}
			}
			Collections.sort(list);
			
			System.out.print("#" + a + " " +count + " ");
			for(int i = 0; i  < list.size(); i ++)
			{
				System.out.print(list.get(i).i + " " + list.get(i).j + " ");
			}
			System.out.println();
		}
	}
	private static void bfs(int[][] arr) {
		int tx = 0, ty = 0;
		int firstX = q.peek().j;
		int firstY = q.peek().i;
		//System.out.println( (firstY)+ " " + (firstX));
		while(!q.isEmpty())
		{
			Info temp = q.poll();
			for(int i = 0; i < 2; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(tx <= 0 || ty <=0 || tx>N ||ty>N)continue;
				if(arr[ty][tx] != 0)
				{
					arr[ty][tx] = 0;
					q.offer(new Info(ty, tx));
				}
			}
		}
	
		list.add(new Info((ty - firstY) + 1, (tx - firstX)));
	}
	public static class Info implements Comparable<Info>{
		int i;
		int j;
		Info(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Info o) {
			int x = this.i * this.j;
			int y = o.i * o.j;
			if(x == y)
			{
				return this.i - o.i;
			}
			return x - y;
		}
	}
}
