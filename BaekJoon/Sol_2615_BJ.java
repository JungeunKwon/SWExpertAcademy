import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_2615_BJ {
	public static int dx[] = { 0, 0, -1, 1, 1, 1 };
	public static int dy[] = { -1, 1, 0, 0, -1, 1 };
	public static int count;
	public static int[][] arr;
	public static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[19][19];
		StringTokenizer st;
		visited = new boolean[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = false;
		aa: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (arr[i][j] != 0) {
					if (i != 0 && j != 0 && i != 18 && j != 18 && arr[i + 1][j - 1] == arr[i][j]) {
						arr[i+1][j-1] = 0;
						continue;
					}
					if (i != 0 && j != 0 && i != 18 && j != 18 && arr[i - 1][j - 1] == arr[i][j]) {
						arr[i -1][j -1] = 0;
						continue;
					}
					if (i != 0 && j != 0 && arr[i - 1][j] == arr[i][j]) {
						arr[i - 1][j] = 0;
						continue;
					}
					if (i != 0 && j != 0 && arr[i][j - 1] == arr[i][j]) {
						arr[i][j - 1] = 0;
						continue;
					}
					count = 0;
					find(i, j, arr[i][j]);
					visited = new boolean[19][19];
					if (count == 5) {
						flag = true;
						System.out.println(arr[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						break aa;
					}
					
				}
			}
		}
		if (!flag)
			System.out.println(0);
		for(int i = 0; i < 19 ; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	private static void find(int y, int x, int num) {
		int tx = 0, ty = 0;
		for (int j = 0; j < 6; j++) {
			tx = x + dx[j];
			ty = y + dy[j];
			if (tx < 0 || ty < 0 || tx >= 19 || ty >= 19)
				continue;
			if (!visited[ty][tx] && arr[ty][tx] == num) {
				int innercount = 0;
				visited[ty][tx] = true;
				while (arr[ty][tx] == num) {
					visited[ty][tx] = true;
					tx = tx + dx[j];
					ty = ty + dy[j];
					if (tx < 0 || ty < 0 || tx >= 19 || ty >= 19)
						break;
					if (arr[ty][tx] == num)
						innercount++;
				}
				if (innercount == 3) {
					count = 5;
					return;
				}
			}

		}

	}

}
