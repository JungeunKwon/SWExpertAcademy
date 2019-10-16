import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1717_BJ {
	public static int N;
	public static int M;
	public static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for(int i  = 0; i <= N ; i ++)
		{
			parent[i] = i;
		}
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int check  = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(check == 0)
			{
				unionSet(a,b);
			}else
			{
				if(findSet(a) == findSet(b))
				{
					System.out.println("YES");
				}else
				{
					System.out.println("NO");
				}
			}
		}

	}
	private static int findSet(int a) {
		if(parent[a] == a)
			return a;
		else {
			int p = findSet(parent[a]);
			parent[a] = p;
			return p;
		}
	}
	private static void unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a!=b)
		{
			parent[b] = a;
		}
		
	}

}
