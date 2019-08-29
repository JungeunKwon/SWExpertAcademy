import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_7699 {
	public static int dx[] = { 1, -1, 0, 0 };
	public static int dy[] = { 0, 0, 1, -1 };
	public static int R;
	public static int C;
	public static int max;
	public static boolean visited[][];
	public static char arr[][];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			visited = new boolean[R + 1][C + 1];
			arr = new char[R + 1][C + 1];

			for (int i = 1; i <= R; i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for (int j = 1, k = 0; j <= C; j++, k++) {
					arr[i][j] = line.charAt(k);
				}
			}
			dfs(1, 1, arr[1][1] + "");

			System.out.println("#" + a + " " + max);
		}
	}

	private static void dfs(int i, int j, String line) {
		int tx = 0, ty = 0;
		for (int k = 0; k < 4; k++) {
			tx = j + dx[k];
			ty = i + dy[k];
			if (tx <= 0 || ty <= 0 || tx > C || ty > R)
				continue;
			String point = arr[ty][tx] + "";
			if (!line.contains(point) && !visited[ty][tx]) {
				visited[ty][tx] = true;
				dfs(ty, tx, line + point);
				visited[ty][tx] = false;
			}

		}
		if (max < line.length()) {
			max = line.length();
		}
	}
}