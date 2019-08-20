import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2206 {
	public static int N;
	public static int M;
	public static boolean visited[][][];
	public static Queue<Info> q;
	public static int shortestcount;
	public static int dx [] = {0,0,-1,1};
	public static int dy [] = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][2];
		q = new LinkedList<>();
		shortestcount = 1;
		for(int i =1 ; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 1, k =0; j <=M; j++,k++)
			{
				arr[i][j] = line.charAt(k) - '0';
			}
		}
		q.offer(new Info(1, 1, 0));
		bfs(arr);
		/*
		 * if(min < Integer.MAX_VALUE) { System.out.println(min); }else
		 * System.out.println(-1);
		 */
	}
	private static void bfs(int[][] arr) {
		int tx = 0 , ty = 0;
		//visited[1][1][0] =true;
		//visited[1][1][1] = true;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i ++)
			{
				Info temp = q.poll();
				visited[temp.i][temp.j][temp.count] = true;
				if(temp.i == N && temp.j == M)
				{
					
					System.out.println(shortestcount);
					//q.clear();
					return;						
				}
				for(int j = 0; j < 4 ; j ++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
				
					if(tx <1 || ty < 1 || tx>M || ty >N)continue;
					if(ty == N && tx == M)
					{
						
						System.out.println(shortestcount + 1);
						//q.clear();
						return;						
					}
					if(arr[ty][tx] == 0 && !visited[ty][tx][temp.count])
					{
						q.offer(new Info(ty,tx,temp.count));
						visited[ty][tx][temp.count] = true;
					}
					if(arr[ty][tx] == 1 && temp.count < 1 && !visited[ty][tx][temp.count])
					{
						q.offer(new Info(ty,tx,temp.count + 1));
						visited[ty][tx][temp.count] = true;
					}
					
				}
			}shortestcount ++;
		}System.out.println(-1);
	}
	public static class Info{
		int i;
		int j;
		int count;
		Info(int i, int j, int count)
		{
			this.i = i ;
			this.j = j;
			this.count = count;
		}
	}
}
