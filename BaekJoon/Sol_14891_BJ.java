import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_14891_BJ {
	public static List<roateInfo> list;
	public static int[][] topni;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		list = new ArrayList<>();
		
		topni = new int[5][8];
		visited = new boolean[5];
		for (int i = 1; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				topni[i][j] = line.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			// list.add(new roateInfo(index, dir));
			visited = new boolean[5];
			findall(index, dir);
			for (int j = 0; j < list.size(); j++) {
				roateInfo temp = list.get(j);
				if (temp.dir == 1) {
					rightrotate(topni[temp.index]);
				} else {
					leftrotate(topni[temp.index]);
				}
				list.remove(j);
				j--;
			}
		}
		int result = 0;
		for (int i = 1; i < 5; i++) {
			if (topni[i][0] == 1) {
				result += Math.pow(2, (i - 1));
			}
		}
		System.out.println(result);
	}

	private static void findall(int index, int dir) {
		if (index <= 0 || index > 4)
			return;
		if (visited[index])
			return;
		visited[index] = true;
		list.add(new roateInfo(index, dir));
		int nextidx = 0;
		nextidx = index + 1;
		if (nextidx <= 4) {
			if (topni[index][2] != topni[nextidx][6]) {
				findall(nextidx, -dir);
			}
		}
		nextidx = index - 1;
		if (nextidx > 0) {
			if (topni[index][6] != topni[nextidx][2]) {
				findall(nextidx, -dir);
			}
		}
	}

	public static void rightrotate(int arr[]) {
		int temp = arr[0];
		for (int i = 1; i < 8; i++) {
			int t = arr[i];
			arr[i] = temp;
			temp = t;
		}
		arr[0] = temp;
	}

	public static void leftrotate(int arr[]) {
		int temp = arr[7];
		for (int i = 7; i >= 0; i--) {
			int t = arr[i];
			arr[i] = temp;
			temp = t;
		}
		arr[7] = temp;
	}

	public static class roateInfo {
		int index;
		int dir;

		roateInfo(int index, int dir) {
			this.index = index;
			this.dir = dir;
		}
	}
}
