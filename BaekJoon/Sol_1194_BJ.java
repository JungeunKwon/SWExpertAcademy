import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1194_BJ {
	public static int dx[] = { 0, 1, 0, -1 };
	public static int dy[] = { 1, 0, -1, 0 };
	public static int N;
	public static int M;
	public static char arr[][];
	public static Queue<Info> q;
	public static int count;
	public static int disti;
	public static int distj;
	public static boolean visited[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M][1 << 6];
		q = new LinkedList<>();
		count = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j] == '0') {
					q.offer(new Info(i, j, 0,0));
					visited[i][j][0] = true;
				}
				if (arr[i][j] == '1') {
					disti = i;
					distj = j;
				}
			}
		}


		int result = bfs();
		if(result != -1) System.out.println(result+1);
		else 
			System.out.println(-1);
	}

	private static int bfs() {
		int tx = 0, ty = 0;

		while (!q.isEmpty()) {

			Info temp = q.poll();

			for (int j = 0; j < 4; j++) {
				tx = temp.j + dx[j];
				ty = temp.i + dy[j];
				int key = temp.key;
				if (tx < 0 || ty < 0 || tx >= M || ty >= N)
					continue;
				if (arr[ty][tx] == '1')
					return temp.cnt;
				if (arr[ty][tx] == '#')
					continue;
				if('a' <= arr[ty][tx] && arr[ty][tx] <= 'f')
				{
					
					key = key | (1<<(arr[ty][tx] - 'a'));
				}
				if('A' <= arr[ty][tx] && arr[ty][tx] <='F')
				{
					if((key & (1<<(arr[ty][tx] - 'A'))) == 0)
					{
						continue;
					}
					
				}
				if(visited[ty][tx][key]) continue;
				q.offer(new Info(ty, tx,(char) key, temp.cnt + 1));
				visited[ty][tx][key] = true;
			}
		}

		return -1;
	}

	public static class Info {
		int i;
		int j;
		int key;
		int cnt;

		Info(int i, int j, int key, int cnt) {
			this.i = i;
			this.j = j;
			this.key = key;
			this.cnt = cnt;
		}
	}
}
