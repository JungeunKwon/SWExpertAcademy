import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_3055_BJ {
	public static Queue<Info> q;
	public static int result;
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};
	public static int H;
	public static int W;
	public static char[][] arr;
	public static boolean visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		arr= new char[H][W];
		visited = new boolean[H][W];
		Info posK = null;
		result = 0;
		for(int i = 0; i < H ; i ++)
		{
			String line = br.readLine();
			for(int j = 0; j <W; j++)
			{
				char c = line.charAt(j);
				arr[i][j] = c;
				if(c == 'S')
				{
					visited[i][j] = true;
					posK = new Info(i, j,false);
				}else if(c == '*')
				{
					q.offer(new Info(i, j, true));
				}
			}
		}
		q.offer(posK);
		bfs();
		if(result < 0 ) System.out.println("KAKTUS");
		else System.out.println(result + 1);
		
	}
	private static void bfs() {
		int tx = 0, ty =0;
		while(!q.isEmpty())
		{
			
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				Info temp = q.poll();
				for(int  j = 0; j < 4; j ++)
				{
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx < 0 || ty < 0 || tx >=W || ty >=H)continue;
					if(arr[ty][tx] == 'X' || arr[ty][tx] == '*') continue;
					if(arr[ty][tx] == 'D' && !temp.iswater)
						return;
					else if(arr[ty][tx] == 'D' && temp.iswater) continue;
					if(arr[ty][tx] == '.' )
					{
						if(temp.iswater)
						{
							arr[ty][tx] = '*';
							q.offer(new Info(ty, tx, temp.iswater));
						}else if(!temp.iswater && !visited[ty][tx])
						{
							q.offer(new Info(ty, tx, temp.iswater));
							visited[ty][tx] = true;
						}
						
					}
					
				}
			}
			result ++;
			
		}
		result = -1;
	}
	public static class Info{
		int i;
		int j;
		boolean iswater;
		Info(int i, int j, boolean iswater)
		{
			this.i = i;
			this.j = j;
			this.iswater = iswater;
		}
	}
}
