import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1600_2_BJ {
	public static int W;
	public static int H;
	public static int arr[][];
	public static boolean visited[][][];
	public static int dx[] = {1,0,-1,0};
	public static int dy[] = {0,1,0,-1};
	public static int horsedx[] = {-2,-1,1,2,2,1,-1,-2};
	public static int horsedy[] = {-1,-2,-2,-1,1,2,2,1};
	public static int min;
	public static Queue<Info> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visited = new boolean[H][W][K+1];
		min = Integer.MAX_VALUE;
		q= new LinkedList<>();
		for(int i = 0; i < H; i ++)
		{
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++)
			{
				
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][0][K] = true;
		q.offer(new Info(0, 0, K, 0));
		bfs();
		
		
		if(min== Integer.MAX_VALUE)
		{
			System.out.println(-1);
			
		}else
		{
			System.out.println(min);
		}
	}
	private static void bfs() {
		int tx = 0, ty =0;
		while(!q.isEmpty())
		{
			Info temp = q.poll();
			if(temp.i == H-1 && temp.j == W-1)
			{
				if(min > temp.move)
					min = temp.move;
				continue;
			}
			if(temp.k > 0) //말 가능하면
			{
				for(int i = 0; i <8; i ++)
				{
					tx = temp.j + horsedx[i];
					ty = temp.i + horsedy[i];
					if(isOver(ty, tx)) continue;
					if(arr[ty][tx] == 1 )continue;
					if(!visited[ty][tx][temp.k-1])
					{
						visited[ty][tx][temp.k-1] = true;
						q.offer(new Info(ty, tx, temp.k - 1, temp.move + 1));
					}
				}
			}
			for(int i = 0; i <4; i ++)
			{
				tx = temp.j + dx[i];
				ty = temp.i + dy[i];
				if(isOver(ty, tx)) continue;
				if(arr[ty][tx] == 1 )continue;
				if(!visited[ty][tx][temp.k])
				{
					visited[ty][tx][temp.k] = true;
					q.offer(new Info(ty, tx, temp.k, temp.move + 1));
				}
			}
			
		}
	}
	public static boolean isOver(int i, int j)
	{
		if(i < 0 || j <0 || i >=H || j >=W)return true;
		else
			return false;
	}
	public static class Info{
		int i;
		int j;
		int k;
		int move;
		Info(int i, int j, int k, int move)
		{
			this.i = i;
			this.j = j;
			this.k = k;
			this.move = move;
		}
	}

}
