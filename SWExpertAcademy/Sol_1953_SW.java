import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1953_SW {
	public static int N;
	public static int M;
	public static List<turnelInfo> tunnel[];
	public static int[][] arr;
	public static boolean visited[][];
	public static int max;
	public static Queue<Info> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tunnel = new ArrayList[8];
		for(int i = 1; i < 8; i ++ )
		{
			tunnel[i] = new ArrayList<>();
		}
		tunnel[1].add(new turnelInfo(0, 1));
		tunnel[1].add(new turnelInfo(-1, 0));
		tunnel[1].add(new turnelInfo(0, -1));
		tunnel[1].add(new turnelInfo(1, 0));
		
		tunnel[2].add(new turnelInfo(0, -1));
		tunnel[2].add(new turnelInfo(0, 1));
		
		tunnel[3].add(new turnelInfo(-1, 0));
		tunnel[3].add(new turnelInfo(1, 0));
	
		tunnel[4].add(new turnelInfo(0, -1));
		tunnel[4].add(new turnelInfo(1, 0));
		
		tunnel[5].add(new turnelInfo(0, 1));
		tunnel[5].add(new turnelInfo(1, 0));
		
		tunnel[6].add(new turnelInfo(0, 1));
		tunnel[6].add(new turnelInfo(-1, 0));
		
		tunnel[7].add(new turnelInfo(0, -1));
		tunnel[7].add(new turnelInfo(-1, 0));
		int T = Integer.parseInt(br.readLine());
		for(int a =1; a <=T ; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			arr = new int[N][M];
			visited = new boolean[N][M];
			for(int i = 0; i < N ; i ++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j ++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			q.offer(new Info(R, C, arr[R][C]));
			
			System.out.println("#" + a +  " "  + bfs(L));
		}
	}
	private static int bfs(int L) {
		int tx = 0, ty = 0;
		int count = 1, qput = 0;
		while(!q.isEmpty())
		{
			if(count == L)
				return qput;
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				Info temp = q.poll();
				int tun = temp.tunnelnum;
				for(int j = 0; j < tunnel[tun].size(); j ++)
				{
					int nextx = tunnel[tun].get(j).dx;
					int nexty =  tunnel[tun].get(j).dy;
					tx = temp.j +nextx;
					ty = temp.i +nexty;
					if(tx < 0 || ty <0 || tx>=M || ty >=N )continue;
					if(visited[ty][tx]) continue;
					if(arr[ty][tx] == 0) continue;
					int t = arr[ty][tx];
					boolean flag = false;
					for(int k = 0; k < tunnel[t].size(); k++)
					{
						int nnextx = tunnel[t].get(k).dx;
						int nnexty =  tunnel[t].get(k).dy;
						if(((nnextx + nextx)== 0) && ((nnexty + nexty) == 0)){
							flag = true;
						}
					}
					if(!flag) continue; 
					visited[ty][tx] = true;
					qput++;
					q.offer(new Info(ty, tx, t));
				
				}
			}
			count++;
			
		}
		return qput;
	}
	public static class turnelInfo{
		int dx;
		int dy;
		turnelInfo(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;			
		}
	}
	public static class Info{
		int i;
		int j;
		int tunnelnum;
		Info(int i, int j, int tunnelnum)
		{
			this.i = i;
			this.j = j;
			this.tunnelnum = tunnelnum;
		}
	}
}
