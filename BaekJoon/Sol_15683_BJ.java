import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_15683_BJ {
	public static int dx[] = {-1,0,1,0};
	public static int dy[] = {0,1,0,-1};
	public static int N;
	public static int M;
	public static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		min = Integer.MAX_VALUE;
		List<cctvInfo> list = new ArrayList<>();
		for(int i = 0; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(1 <= arr[i][j] && arr[i][j] <= 5)
				{
					list.add(new cctvInfo(i, j, arr[i][j]));
				}
			}
		}
		dfs(list, arr, list.size(), 0);
		System.out.println(min);

	}
	private static void dfs(List<cctvInfo> list, int[][] arr, int size, int idx) {
		if(idx == size)
		{
			int count = 0;
			for(int i = 0; i < N ; i ++)
			{
				for(int j = 0; j < M ; j ++)
				{
					if(arr[i][j] == 0) count++;
					if(count > min) return;
				}
			}
			if(min > count ) min = count;
			return;
		}
		cctvInfo temp = list.get(idx);
		int type = temp.type;
		int[][] tempv = new int[N][M];
		for(int i = 0; i < N ; i++)
		{
			System.arraycopy(arr[i], 0, tempv[i], 0, M);
		}
		if(type == 1)
		{
			for(int i = 0; i < 4; i ++)
			{
				for(int j = 0; j< N ; j++)
				{
					System.arraycopy(arr[j], 0, tempv[j], 0, M);
				}
				detect(tempv, temp.i, temp.j, i);
				dfs(list, tempv, list.size(), idx + 1);
			}
			//4번
		}else if(type == 2)
		{
			for(int i = 0; i < 2; i ++)
			{
				int tx = temp.j + dx[i], ty = temp.i + dy[i];
				while(tx >=0 && ty >= 0 && tx <M  && ty<N)
				{
					if(arr[ty][tx] == 6) break;
					if(tempv[ty][tx] == 0)
					{
						tempv[ty][tx] = 8;
					}
					tx = temp.j + dx[i];
					ty = temp.i + dy[i];
					
				}
			}
			//2번
		}
		else if(type == 3)
		{
			
			//2번
		}else if(type == 4)
		{
			
			//2번
		}else
		{
			//걍
			for(int i = 0; i < 4; i ++)
			{
				
			}
			dfs(list, tempv, size, idx + 1);
		}
		
	}
	public static void detect(int visited[][], int x, int y, int d)
	{
		//좌 상 우 하
		while(x >=0 && y >= 0 && x <M  && y<N)
		{
			if(visited[x][y] == 6) break;
			if(visited[x][y] == 0)
			{
				visited[x][y] = 8;
			}
			x = x + dx[d];
			y = y + dy[d];
			
		}
	}
	public static class cctvInfo{
		int i;
		int j;
		int type;
		cctvInfo(int i, int j, int type)
		{
			this.i = i;
			this.j = j;
			this.type = type;
		}
	}
}
