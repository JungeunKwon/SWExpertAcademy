import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Sol_2636_BJ {
	public static Queue<Info> q;
	public static int H;
	public static int W;
	public static int dx[] = { 0, 0, -1, 1 };
	public static int dy[] = { -1, 1, 0, 0 };
	public static int arr[][];
	public static int result = 0;
	public static boolean visited[][];
	public static int timecount;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[H + 2][W + 2];
		
		
		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		timecount = 0;
		while(bfs());
		System.out.println(timecount);
		System.out.println(result);
	}

	private static boolean bfs() {
		q = new LinkedList<>();
		q.offer(new Info(0, 0));
		boolean flag = false;
		int tx = 0, ty = 0;
		int count = 0;
		visited = new boolean[H + 2][W + 2];
		visited[ty][tx] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Info temp = q.poll();
				for (int j = 0; j < 4; j++) {
					tx = temp.j + dx[j];
					ty = temp.i + dy[j];
					if(tx < 0 || ty <0 || tx>=W+1 || ty>=H+1 || visited[ty][tx]) continue;
					
					if(arr[ty][tx] == 1)
					{
						visited[ty][tx]  = true;
						arr[ty][tx] = 0;
						flag = true;
						count ++;
					}else if(arr[ty][tx] == 0)
					{
						q.offer(new Info(ty, tx));
						visited[ty][tx] = true;
					}
						
				}

			}

		}
		if(flag)
		{
			result = count;
			timecount++;
		}
		return flag;
	}

	public static class Info {
		int i;
		int j;

		Info(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
