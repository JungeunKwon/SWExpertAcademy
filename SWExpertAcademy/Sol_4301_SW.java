import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_4301_SW {
	public static int dx[] = { 0, 2 };
	public static int dy[] = { 2, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int arr[][] = new int[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						int tx = j;
						int ty = i;
						for (int k = 0; k < 2; k++) {
							tx = j + dx[k];
							ty = i + dy[k];
							if (tx < 0 || ty < 0 || tx >= M || ty >= N)
								continue;
							if (arr[ty][tx] == 0) {
								arr[ty][tx] = 1;
								count++;
							}
						}
					}
				}
			}
			int result = (M * N) - count;
			System.out.println("#" + a + " " + result);
		}

	}

}
