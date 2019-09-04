import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1824_SW {
	public static Queue<Info> q;
	public static char[][] arr;
	public static int R;
	public static int C;
	public static int dx[] = { 1, -1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 }; // 0오 //1왼 //2위//3아래
	public static boolean visited[][][][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new char[R][C];
			visited = new boolean[R][C][4][16];
			q = new LinkedList<>();
			int num = 0;
			int dir =0;
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					char c = line.charAt(j);
					arr[i][j] = c;
					if (i == 0 & j == 0) {
						if(Character.isDigit(c))
							num = arr[i][j] - '0';
						else if(c == '^')
						{
							dir = 2;
						}else if(c == 'v')
						{
							dir = 3;
						}else if(c == '<')
						{
							dir = 1;
						}else if(c == '>')
						{
							dir = 0;
						}
					}
				}
			}
			q.offer(new Info(0, 0, dir, num));
			System.out.print("#" + a + " ");
			bfs();
			
		}

	}

	private static void bfs() {
		int tx = 0, ty = 0;
		while (!q.isEmpty()) {
			Info temp = q.poll();
			if(visited[temp.i][temp.j][temp.dir][temp.memory]) continue;
			tx = temp.j + dx[temp.dir];
			ty = temp.i + dy[temp.dir];
			if (tx < 0) {
				tx = C - 1;
			} else if (ty < 0) {
				ty = R - 1;
			} else if (tx >= C) {
				tx = 0;
			} else if (ty >= R) {
				ty = 0;
			}
			
			boolean isstop = playOp(tx, ty,temp.dir, temp.memory);
			visited[temp.i][temp.j][temp.dir][temp.memory] = true;
			if(isstop)
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	private static boolean playOp(int tx, int ty, int dir, int memo) {
		boolean result = false;
		switch (arr[ty][tx]) {
		case '<':
			q.offer(new Info(ty, tx, 1, memo));
			break;
		case '>':
			q.offer(new Info(ty, tx, 0, memo));
			break;
		case '^':
			q.offer(new Info(ty, tx, 2, memo));
			break;
		case 'v':
			q.offer(new Info(ty, tx, 3, memo));
			break;
		case '_':
			if(memo == 0)
			{
				q.offer(new Info(ty, tx, 0, memo));
			}else
			{
				q.offer(new Info(ty, tx, 1, memo));
			}
			break;
		case '|':
			if(memo == 0)
			{
				q.offer(new Info(ty, tx, 3, memo));
			}else
			{
				q.offer(new Info(ty, tx, 2, memo));
			}
			break;
		case '?':
			q.offer(new Info(ty, tx, 0, memo));
			q.offer(new Info(ty, tx, 1, memo));
			q.offer(new Info(ty, tx, 2, memo));
			q.offer(new Info(ty, tx, 3, memo));
			break;
		case '.':
			q.offer(new Info(ty, tx, dir, memo));
			break;
		case '@':
			result = true;
			break;
		case '+':
			if(memo == 15)
				memo = 0;
			else
				memo ++;
			q.offer(new Info(ty, tx, dir, memo));
			break;
		case '-':
			if(memo == 0)
				memo = 15;
			else
				memo --;
			q.offer(new Info(ty, tx, dir, memo));
			break;
		default:
			int temp = arr[ty][tx] - '0';
			q.offer(new Info(ty, tx, dir, temp));
			break;

		}
		return result;
	}

	public static class Info {
		int i;
		int j;
		int dir;
		int memory;

		Info(int i, int j, int dir, int memory) {
			this.i = i;
			this.j = j;
			this.dir = dir;
			this.memory = memory;
		}
	}
}
