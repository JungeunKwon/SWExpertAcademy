import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_7396_SW {
	public static Queue<Info> q; 
	public static int min;
	public static int N;
	public static int M;
	public static int dx[] = {1,0};
	public static int dy[] = {0,1};
	public static char arr[][];
	public static int count;
	public static boolean[][] visited;
	static StringBuilder result;
	public static void main(String[] args) throws Exception{
		//정29현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a<=T ; a++)
		{
			q = new LinkedList<>();
			min = Integer.MAX_VALUE;
			count  = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N][M];
			arr = new char[N][M];
			String line;
			for(int i = 0; i < N; i ++)
			{
				line = br.readLine();
				for(int j = 0; j < M ; j ++)
				{
					arr[i][j] = line.charAt(j);
				}
			}
			q.offer(new Info(0, 0));
			result = new StringBuilder();
			System.out.print("#" + a  + " ");
			bfs();
			System.out.println(result.toString());

		}
			
	}
	private static void bfs() {
		int tx = 0, ty = 0;
		char before = arr[0][0];
		while(!q.isEmpty())
		{
			result.append(before);
			int size = q.size();
			char next = 'z';
			
			for(int i = 0; i < size; i ++)
			{
				Info temp = q.poll();
				if(arr[temp.i][temp.j] != before) continue;
				for(int j = 0; j < 2; j++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx < 0 || ty < 0 || tx>= M || ty>=N) continue;
					if(visited[ty][tx]) continue;

						if(arr[ty][tx] < next)
						{
							next = arr[ty][tx];	
						}
						q.offer(new Info(ty, tx));
						visited[ty][tx] = true;
					
				}
			}	
			before = next;
		}
		
	}
	public static class Info
	{
		int i;
		int j;
		Info(int i,int j)
		{
			this.i = i;
			this.j = j;
		}
		
	}
}
