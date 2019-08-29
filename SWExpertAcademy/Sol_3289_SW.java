import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_3289 {
	public static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n, m,op,first,second;
		StringBuilder sb;
		for(int a = 1; a <= T ; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			op = 0;
			parent = new int[n + 1];
			makeSet(parent);
			sb = new StringBuilder();
			for(int i = 0; i < m; i++)
			{
				st = new  StringTokenizer(br.readLine(), " ");
				op = Integer.parseInt(st.nextToken());
				first = Integer.parseInt(st.nextToken());
				second = Integer.parseInt(st.nextToken());
				switch(op)
				{
				case 0:
					unionSet(first,second);
					break;
				case 1:
					if(findSet(first) == findSet(second))
						sb.append(1);
					else
						sb.append(0);
					break;
				}
			}
			System.out.println("#" + a + " " + sb.toString());
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
