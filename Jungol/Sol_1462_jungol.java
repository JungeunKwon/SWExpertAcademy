import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1462_jungol {
	public static int N;
	public static int M;
	public static int count ;
	
	public static int max;
	public static Queue<Info> q;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[][] = new int [N][M];
		boolean visited[][] = new boolean[N][M];
		Info store = null;
		ArrayList<Info> list = new ArrayList<>();
		max = Integer.MIN_VALUE;
	
		for(int i =0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), "");
			String line = st.nextToken();
			for(int j = 0; j < M;  j++)
			{
				char temp = line.charAt(j);
				switch(temp)
				{
				case 'W': 
					arr[i][j] = -1;
					break;
				case 'L':
					arr[i][j] = 0;
					break;
					
				}
			}
		}
		for(int i =0; i < N; i++)
		{
			for(int j = 0; j < M;  j++)
			{
				if(arr[i][j] == 0)
				{
					q = new LinkedList<>();
					q.offer(new Info(i,j));
					bfs(arr,visited);
				
					visited = new boolean[N][M];
					
					if(count >= max)
					{
						max = count;
					}
					q.clear();
				}
			}
		}

		
		System.out.println(max);
	
	}
	
	private static void bfs(int[][] arr, boolean[][] visited) {
		int tx = 0, ty = 0;
		count = -1;
		while(!q.isEmpty())
		{
			int size = q.size();
			
			for(int i = 0; i < size; i ++)
			{
				Info temp = q.poll();
				visited[temp.i][temp.j] = true;
				
				for(int j = 0; j < 4; j++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx < 0 || ty < 0 || tx >= M || ty >= N)
						continue;
					if(arr[ty][tx] == 0 && !visited[ty][tx] )
					{
						visited[ty][tx] = true;
						q.offer(new Info(ty,tx));
					}
				}
			}count ++;
			
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
