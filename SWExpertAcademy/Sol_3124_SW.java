import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Sol_3124 {
	public static int[] parent;
	public static long result;
	public static long count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			parent = new int[V + 1];
			for (int i = 0; i < V + 1; i++)
				parent[i] = i;
			TreeSet<Edge> tree = new TreeSet<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				tree.add(new Edge(x, y, weight));
			}
			for(Edge e : tree)
			{
				unionSet(e);
				if(count == V-1)
				{
					break;
				}
			}
			tree.clear();
			System.out.println("#" + a + " " + result);
		}
	}

	private static void unionSet(Edge e) {
		int x = findSet(e.x);
		int y = findSet(e.y);
		if (x != y) {
			parent[y] = x;
			result += e.weight;
			count++;
		}
	}

	private static int findSet(int x) {
		if (x == parent[x])
			return x;
		
		return parent[x] = findSet(parent[x]);
	}

	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;

		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
	}

}
