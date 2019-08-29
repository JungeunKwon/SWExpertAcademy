import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_7465_2 {
	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];
			makeSet(parent);
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				unionSet(first, second);
			}
			int cnt = 0;
			for(int i = 1; i <= N; i++)
			{
				if(parent[i] == i)
				{cnt ++;}
			}
			System.out.println("#" + a + " " + cnt);
		}

	}

	public static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x != y)
			parent[y] = x;
	}

	public static int findSet(int x) {
		if (x == parent[x]) // 자기가 자기를 가리키는 경우
			return x;
		else { // 계속 부모찾는 시간을 절약하려면
			int p = findSet(parent[x]);
			parent[x] = p;
			return findSet(p);
		}

	}

	public static void makeSet(int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
}
