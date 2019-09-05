import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_16973_BJ {
	public static int N;
	public static int M;
	public static int arr[][];
	public static Queue<Info> q;
	public static int dx[] = { 0, 0, -1, 1 };
	public static int dy[] = { 1, -1, 0, 0 }; // 아래 위 왼 오
	public static int H;
	public static int W;
	public static boolean visited[][];
	public static int count;
	public static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		min = Integer.MAX_VALUE;
		visited = new boolean[N + 1][M + 1];
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int startx = Integer.parseInt(st.nextToken());
		int starty = Integer.parseInt(st.nextToken());
		int endx = Integer.parseInt(st.nextToken());
		int endy = Integer.parseInt(st.nextToken());

		q.offer(new Info(startx, starty, 0));
		visited[startx][starty] = true;
		q.offer(new Info(startx + H - 1, starty, 1));
		q.offer(new Info(startx, starty + W - 1, 2));
		q.offer(new Info(startx + H - 1, starty + W - 1, 3));
		
		bfs(endx, endy);
		System.out.println(min);
		q.clear();
	}

	private static void bfs(int endx, int endy) {
		int tx = 0, tx2 = 0, tx3 = 0, tx4 = 0, ty = 0, ty2 = 0, ty3 = 0, ty4 = 0;
		while (!q.isEmpty()) {
			int size = q.size() / 4;
			for (int i = 0; i < size; i++) {
				Info temp1 = q.poll();
				Info temp2 = q.poll();
				Info temp3 = q.poll();
				Info temp4 = q.poll();
				loop : for (int j = 0; j < 4; j++) {
					tx = temp1.j + dx[j];
					ty = temp1.i + dy[j];
					tx2 = temp2.j + dx[j];
					ty2 = temp2.i + dy[j];
					tx3 = temp3.j + dx[j];
					ty3 = temp3.i + dy[j];
					tx4 = temp4.j + dx[j];
					ty4 = temp4.i + dy[j];
					if (tx <= 0 || ty <= 0 || ty > N || tx > M) continue;
					if (tx2 <= 0 || ty2 <= 0 || ty2 > N || tx2 > M) continue;
					if (tx3 <= 0 || ty3 <= 0 || ty3 > N || tx3 > M) continue;
					if (tx4 <= 0 || ty4 <= 0 || ty4 > N || tx4 > M) continue;
					if(visited[ty][tx]) continue;
					
					for(int y = ty; y <= ty2; y++) {
						if(arr[y][tx] == 1) continue loop;
						if(arr[y][tx3] == 1) continue loop;
					}
					for(int x = tx; x <= tx3; x++) {
						if(arr[ty][x] == 1) continue loop;
						if(arr[ty2][x] == 1) continue loop;
					}
					
					if ((tx == endy && ty == endx)) {
						if (min > count + 1) {
							min = count + 1;
						}
						return;
					}
					q.offer(new Info(ty, tx, temp1.po));
					q.offer(new Info(ty2, tx2, temp2.po));
					q.offer(new Info(ty3, tx3, temp3.po));
					q.offer(new Info(ty4, tx4, temp4.po));
					visited[ty][tx] = true;

				}
			}
			count++;
		}
		min = -1;
	}

	public static class Info {
		int i;
		int j;
		int po;

		Info(int i, int j, int po) {
			this.i = i;
			this.j = j;
			this.po = po;
		}
	}
}
